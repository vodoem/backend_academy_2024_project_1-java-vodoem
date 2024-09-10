package backend.academy.hangman_game;

public class GameWordDTO {
    private final String word;
    private final String hint;
    private final WordDifficultyLevel wordDifficultyLevel;
    private final WordCategory wordCategory;

    public GameWordDTO(String word, String hint, WordCategory wordCategory) {
        this.word = word;
        this.hint = hint;
        this.wordCategory = wordCategory;
        if (word.length() < 5) {
            this.wordDifficultyLevel = WordDifficultyLevel.EASY;
        } else if (word.length() < 7) {
            this.wordDifficultyLevel = WordDifficultyLevel.MEDIUM;
        } else {
            this.wordDifficultyLevel = WordDifficultyLevel.HARD;
        }
    }

    public WordCategory getWordCategoty() {
        return wordCategory;
    }

    public WordDifficultyLevel getWordDifficultyLevel() {
        return wordDifficultyLevel;
    }

    public String getHint() {
        return hint;
    }

    public String getWord() {
        return word;
    }
}
