package backend.academy.samples.hangman_game_tests;

import backend.academy.hangman_game.GameManager;
import backend.academy.hangman_game.GameWordDTO;
import backend.academy.hangman_game.WordCategory;
import backend.academy.hangman_game.WordDifficultyLevel;
import backend.academy.hangman_game.WordsStorage;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

//Тест для проверки, что игра не запускается с некорректной длиной слова
public class GameWordLengthTest {
    @Test
    public void shouldNotStartGameWithInvalidWordLength() {
        // Arrange
        GameWordDTO invalidWord =
            new GameWordDTO("аа", "Некорректное слово", WordCategory.ANIMALS, WordDifficultyLevel.EASY);
        WordsStorage wordsStorage = new WordsStorage(List.of(invalidWord));

        GameManager gameManager = new GameManager(wordsStorage);

        // Act & Assert
        assertThatThrownBy(() -> gameManager.startNewGame(WordCategory.ANIMALS, WordDifficultyLevel.EASY))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Некорректная длина слова");
    }
}
