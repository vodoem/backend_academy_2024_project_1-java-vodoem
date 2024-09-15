package backend.academy.hangman_game;

public class GameManager {
    private final Game game;
    private HangmanFigure hangmanFigure;

    public GameManager(WordsStorage wordsStorage) {
        this.game = new Game(wordsStorage);
    }

    public void setHangmanFigure(int maxAttempts) {
        this.hangmanFigure = new HangmanFigure(maxAttempts);
    }

    public void startNewGame(WordCategory category, WordDifficultyLevel difficultyLevel) {
        game.initializeGame(category, difficultyLevel);
        System.out.println("Подсказка: " + game.getHint());
        setHangmanFigure(game.getMaxAttempts());
    }

    public void guess(char letter) {
        game.handleGuess(Character.toLowerCase(letter));
    }

    public String getGameState() {
        return game.getWordProgress() + " | Осталось попыток: " + game.getRemainingAttempts() + "\n" +
            hangmanFigure.getFigure(game.getRemainingAttempts());
    }

    public boolean isGameOver() {
        return game.isGameOver();
    }

    public String getCurrentWord() {
        return game.getWord();
    }
}
