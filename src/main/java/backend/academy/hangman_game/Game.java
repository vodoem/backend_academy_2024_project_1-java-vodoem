package backend.academy.hangman_game;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private static List<GameWordDTO> gameWords;
    private static WordDifficultyLevel difficultyLevel;
    private static WordCategory category;
    private static GameWordDTO randomWord;
    private static int acceptableMissNumber;
    private static int remainingAttempts;
    private static final Set<Character> guessedLetters = new HashSet<>();
    private static final Set<Character> incorrectGuesses = new HashSet<>();

    public static void initializeGameWords(
        List<String> words, List<String> hints, List<WordCategory> wordCategories
    ) {
        Game.gameWords = GameWordsCreator.gameWordsCreating(words, hints, wordCategories);
        WordsStorage.initializeGameWords(gameWords);
    }

    public static void start() throws IOException {
        // Запрашиваем у пользователя уровень сложности и категорию слов
        difficultyLevelRequest();
        categoryRequest();

        // Устанавливаем случайное слово
        setRandomWord(category, difficultyLevel);
        setAcceptableMissNumber(difficultyLevel);

        remainingAttempts = acceptableMissNumber;

        System.out.println("Игра началась! Ваша подсказка: " + randomWord.getHint());

        // Главный игровой цикл
        play();
    }

    private static void play() throws IOException {
        HangmanFigure hangmanFigure = new HangmanFigure(acceptableMissNumber);
        InputHandler inputHandler = new InputHandler();

        while (remainingAttempts > 0 && !isWordGuessed()) {
            displayGameState(hangmanFigure);
            handleUserGuess(inputHandler);
        }

        concludeGame(hangmanFigure);
        inputHandler.close();
    }


    private static void displayGameState(HangmanFigure hangmanFigure) {
        System.out.println("\nТекущий прогресс: " + getWordProgress());
        System.out.println("Осталось попыток: " + remainingAttempts);
        System.out.println(hangmanFigure.getFigure(remainingAttempts));
    }


    private static void handleUserGuess(InputHandler inputHandler) throws IOException {
        char guess = inputHandler.getGuess();

        if (guessedLetters.contains(guess) || incorrectGuesses.contains(guess)) {
            System.out.println("Эта буква уже была использована.");
            return;
        }

        if (randomWord.getWord().indexOf(guess) >= 0) {
            guessedLetters.add(guess);
            System.out.println("Правильно!");
        } else {
            incorrectGuesses.add(guess);
            remainingAttempts--;
            System.out.println("Неправильно!");
        }
    }


    private static void concludeGame(HangmanFigure hangmanFigure) {
        if (isWordGuessed()) {
            System.out.println("Поздравляем! Вы угадали слово: " + randomWord.getWord());
        } else {
            System.out.println("Вы проиграли. Загаданное слово было: " + randomWord.getWord());
            System.out.println(hangmanFigure.getFigure(remainingAttempts));
        }
    }


    private static String getWordProgress() {
        StringBuilder progress = new StringBuilder();
        for (char letter : randomWord.getWord().toCharArray()) {
            if (guessedLetters.contains(letter)) {
                progress.append(letter);
            } else {
                progress.append('_');
            }
            progress.append(' ');
        }
        return progress.toString().trim();
    }


    private static boolean isWordGuessed() {
        for (char letter : randomWord.getWord().toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }


    private static void difficultyLevelRequest() throws IOException {
        InputHandler ih = new InputHandler();
        Game.difficultyLevel = ih.selectDifficulty();
    }


    private static void categoryRequest() throws IOException {
        InputHandler ih = new InputHandler();
        Game.category = ih.selectCategory();
    }


    private static void setRandomWord(WordCategory category, WordDifficultyLevel difficultyLevel) {
        Game.randomWord = WordsStorage.getRandomWordWithChosenCategoryAndDifficultLevel(category, difficultyLevel);
    }


    private static void setAcceptableMissNumber(WordDifficultyLevel difficultyLevel) {
        switch (difficultyLevel) {
            case EASY -> Game.acceptableMissNumber = 13;
            case MEDIUM -> Game.acceptableMissNumber = 10;
            case HARD -> Game.acceptableMissNumber = 7;
        }
    }
}

