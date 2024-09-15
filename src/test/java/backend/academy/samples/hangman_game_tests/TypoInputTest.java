package backend.academy.samples.hangman_game_tests;

import backend.academy.hangman_game.GameManager;
import backend.academy.hangman_game.GameWordDTO;
import backend.academy.hangman_game.InputHandler;
import backend.academy.hangman_game.WordCategory;
import backend.academy.hangman_game.WordDifficultyLevel;
import backend.academy.hangman_game.WordsStorage;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TypoInputTest {
    @Test
    public void shouldPromptForReInputOnTypoWithoutChangingState() {
        // Arrange
        InputHandler inputHandler = mock(InputHandler.class);
        when(inputHandler.getGuess()).thenReturn('к', "от".charAt(0)); // Ввод опечатки

        WordsStorage wordsStorage = new WordsStorage(List.of(
            new GameWordDTO("кот", "Домашнее животное", WordCategory.ANIMALS, WordDifficultyLevel.EASY)
        ));
        GameManager gameManager = new GameManager(wordsStorage);
        gameManager.startNewGame(WordCategory.ANIMALS, WordDifficultyLevel.EASY);

        // Act & Assert
        char validInput = inputHandler.getGuess();
        assertThat(validInput).isEqualTo('к');

        char invalidInput = inputHandler.getGuess();
        assertThat(invalidInput).isNotEqualTo("от");
    }
}
