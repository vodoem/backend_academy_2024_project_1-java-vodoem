package backend.academy.hangman_game;

public enum WordDifficultyLevel {
    HARD("Сложно"),
    MEDIUM("Средне"),
    EASY("Легко");
    private final String title;

    WordDifficultyLevel(String title) {
        this.title = title;
    }

    //не используется, но может использоваться в InputHandler (на мой взгляд только усложнит читабильность)
    @Override public String toString() {
        return title;
    }
}
