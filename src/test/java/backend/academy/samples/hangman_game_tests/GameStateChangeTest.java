package backend.academy.samples.hangman_game_tests;

import backend.academy.hangman_game.GameManager;
import backend.academy.hangman_game.GameWordDTO;
import backend.academy.hangman_game.WordCategory;
import backend.academy.hangman_game.WordDifficultyLevel;
import backend.academy.hangman_game.WordsStorage;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//Тест для проверки состояния игры при правильных/неправильных угадываниях
public class GameStateChangeTest {
    @Test
    public void shouldChangeGameStateCorrectlyAfterEachGuess() {
        // Arrange
        WordsStorage wordsStorage = new WordsStorage(List.of(
            new GameWordDTO("кот", "Домашнее животное", WordCategory.ANIMALS, WordDifficultyLevel.EASY)
        ));
        GameManager gameManager = new GameManager(wordsStorage);
        gameManager.startNewGame(WordCategory.ANIMALS, WordDifficultyLevel.EASY);

        // Act
        gameManager.guess('к');
        assertThat(gameManager.getCurrentGameProgress()).contains("к _ _");

        gameManager.guess('п');  // Неправильная буква
        assertThat(gameManager.getCurrentGameProgress()).contains("к _ _");
    }
}
