package backend.academy.hangman_game;

public enum WordDifficultyLevel {
    Hard("Сложно"),
    Medium("Средне"),
    Easy("Легко");
    private final String title;

    private WordDifficultyLevel(String title) {
        this.title = title;
    }

    @Override public String toString() {
        return title;
    }
}
