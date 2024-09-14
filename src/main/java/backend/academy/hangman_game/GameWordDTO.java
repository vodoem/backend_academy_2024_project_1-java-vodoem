package backend.academy.hangman_game;

public class GameWordDTO {
    private final String word;
    private final String hint;
    private final WordCategory category;
    private final WordDifficultyLevel difficulty;

    public GameWordDTO(String word, String hint, WordCategory category, WordDifficultyLevel difficulty) {
        this.word = word;
        this.hint = hint;
        this.category = category;
        this.difficulty = difficulty;
    }

    public String getWord() {
        return word;
    }

    public String getHint() {
        return hint;
    }

    public WordCategory getCategory() {
        return category;
    }

    public WordDifficultyLevel getDifficulty() {
        return difficulty;
    }
}
