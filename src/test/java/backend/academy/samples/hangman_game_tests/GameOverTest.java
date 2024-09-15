package backend.academy.samples.hangman_game_tests;

import backend.academy.hangman_game.GameManager;
import backend.academy.hangman_game.GameWordDTO;
import backend.academy.hangman_game.WordCategory;
import backend.academy.hangman_game.WordDifficultyLevel;
import backend.academy.hangman_game.WordsStorage;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//Тест для проверки поражения после превышения числа попыток
public class GameOverTest {
    @Test
    public void shouldLoseGameAfterMaxAttemptsExceeded() {
        //Arrange
        WordsStorage wordsStorage = new WordsStorage(
            List.of(new GameWordDTO("кот", "Домашнее животное", WordCategory.ANIMALS, WordDifficultyLevel.HARD)));
        GameManager gameManager = new GameManager(wordsStorage);
        gameManager.startNewGame(WordCategory.ANIMALS, WordDifficultyLevel.HARD);
        //Act
        gameManager.guess('й');
        gameManager.guess('й');
        gameManager.guess('й');
        gameManager.guess('й');
        gameManager.guess('й');
        gameManager.guess('й');
        gameManager.guess('й');
        //Assert
        assertThat(gameManager.isGameOver()).isTrue();
    }
}
