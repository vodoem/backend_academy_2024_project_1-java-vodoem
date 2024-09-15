package backend.academy.samples.hangman_game_tests;

import backend.academy.hangman_game.GameManager;
import backend.academy.hangman_game.GameWordDTO;
import backend.academy.hangman_game.WordCategory;
import backend.academy.hangman_game.WordDifficultyLevel;
import backend.academy.hangman_game.WordsStorage;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//Тест для проверки правильности выбора слова из списка
public class GameManagerTest {
    @Test
    public void shouldSelectCorrectWordFromList() {
        // Arrange
        WordsStorage wordsStorage = mock(WordsStorage.class);
        GameWordDTO mockWord =
            new GameWordDTO("кот", "Домашнее животное", WordCategory.ANIMALS, WordDifficultyLevel.EASY);
        when(wordsStorage.getRandomWordWithChosenCategoryAndDifficultyLevel(any(), any())).thenReturn(mockWord);

        GameManager gameManager = new GameManager(wordsStorage);

        // Act
        gameManager.startNewGame(WordCategory.ANIMALS, WordDifficultyLevel.EASY);

        // Assert
        assertThat(gameManager.getCurrentWord()).contains("кот");  // Проверка правильного выбора слова
    }
}
