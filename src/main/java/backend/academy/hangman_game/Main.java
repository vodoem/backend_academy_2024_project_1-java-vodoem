package backend.academy.hangman_game;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Список слов и подсказок
        List<GameWordDTO> words = List.of(
            new GameWordDTO("слон", "Большое млекопитающее", WordCategory.ANIMALS, WordDifficultyLevel.MEDIUM),
            new GameWordDTO("кот", "Домашнее животное", WordCategory.ANIMALS, WordDifficultyLevel.EASY),
            new GameWordDTO("дельфин", "Умное морское млекопитающее", WordCategory.ANIMALS, WordDifficultyLevel.HARD),

            new GameWordDTO("футбол", "Спорт с мячом", WordCategory.SPORT_TYPES, WordDifficultyLevel.EASY),
            new GameWordDTO("баскетбол", "Спорт с кольцом", WordCategory.SPORT_TYPES, WordDifficultyLevel.MEDIUM),
            new GameWordDTO("триатлон", "Соревнование на выносливость", WordCategory.SPORT_TYPES,
                WordDifficultyLevel.HARD),

            new GameWordDTO("форд", "Американская марка автомобилей", WordCategory.CAR_BRANDS,
                WordDifficultyLevel.EASY),
            new GameWordDTO("мерседес", "Немецкий люкс-бренд", WordCategory.CAR_BRANDS, WordDifficultyLevel.MEDIUM),
            new GameWordDTO("ламборгини", "Итальянский спортивный автомобиль", WordCategory.CAR_BRANDS,
                WordDifficultyLevel.HARD)
        );

        InputHandler inputHandler = new InputHandler();
        WordsStorage wordsStorage = new WordsStorage(words);
        GameManager gameManager = new GameManager(wordsStorage);

        do {
            WordCategory category = inputHandler.chooseCategory();
            WordDifficultyLevel difficultyLevel = inputHandler.chooseDifficultyLevel();

            gameManager.startNewGame(category, difficultyLevel);

            while (!gameManager.isGameOver()) {
                char guess = inputHandler.getGuess();
                gameManager.guess(guess);
                System.out.println("Текущее состояние слова: " + gameManager.getCurrentGameProgress());
            }

            System.out.println("Игра окончена! Загаданное слово было: " + gameManager.getCurrentWord());
        } while (inputHandler.getYesNoAnswer());
    }
}
