package backend.academy.hangman_game;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private final WordsStorage wordsStorage;
    private GameWordDTO currentWord;
    private final Set<Character> guessedLetters;
    private final Set<Character> incorrectGuesses; //не использую в логике, но возможно будет полезна при расширении функционала
    private int remainingAttempts;

    public Game(WordsStorage wordsStorage) {
        this.wordsStorage = wordsStorage;
        this.guessedLetters = new HashSet<>();
        this.incorrectGuesses = new HashSet<>();
    }

    public void initializeGame(WordCategory category, WordDifficultyLevel difficultyLevel) {
        currentWord = wordsStorage.getRandomWordWithChosenCategoryAndDifficultyLevel(category, difficultyLevel);
        remainingAttempts = getMaxAttempts(difficultyLevel);
        guessedLetters.clear();
        incorrectGuesses.clear();
    }

    public int getMaxAttempts() {
        return getMaxAttempts(currentWord.getDifficulty());
    }

    private int getMaxAttempts(WordDifficultyLevel difficultyLevel) {
        return switch (difficultyLevel) {
            case EASY -> 13;
            case MEDIUM -> 10;
            case HARD -> 7;
            default -> 0;
        };
    }


    public void handleGuess(char letter) {
        if (currentWord.getWord().indexOf(letter) >= 0) {
            guessedLetters.add(letter);
        } else {
            incorrectGuesses.add(letter);
            remainingAttempts--;
        }
    }

    public String getWordProgress() {
        StringBuilder progress = new StringBuilder();
        for (char letter : currentWord.getWord().toCharArray()) {
            if (guessedLetters.contains(letter)) {
                progress.append(letter);
            } else {
                progress.append('_');
            }
            progress.append(' ');
        }
        return progress.toString().trim();
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public boolean isGameOver() {
        return remainingAttempts <= 0 || isWordGuessed();
    }

    private boolean isWordGuessed() {
        for (char letter : currentWord.getWord().toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    public String getHint() {
        return currentWord.getHint();
    }

    public String getWord() {
        return currentWord.getWord();
    }
}
