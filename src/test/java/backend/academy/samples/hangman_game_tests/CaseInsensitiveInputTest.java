package backend.academy.samples.hangman_game_tests;

import backend.academy.hangman_game.GameManager;
import backend.academy.hangman_game.GameWordDTO;
import backend.academy.hangman_game.WordCategory;
import backend.academy.hangman_game.WordDifficultyLevel;
import backend.academy.hangman_game.WordsStorage;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//Тест для проверки ввода вне зависимости от регистра
public class CaseInsensitiveInputTest {
    @Test
    public void shouldAcceptUpperCaseAndLowerCaseLettersEqually() {
        // Arrange
        WordsStorage wordsStorage = new WordsStorage(List.of(
            new GameWordDTO("кот", "Домашнее животное", WordCategory.ANIMALS, WordDifficultyLevel.EASY)
        ));
        GameManager gameManager = new GameManager(wordsStorage);
        gameManager.startNewGame(WordCategory.ANIMALS, WordDifficultyLevel.EASY);

        // Act
        gameManager.guess('К');  // Ввод заглавной буквы
        gameManager.guess('о');  // Ввод строчной буквы
        gameManager.guess('Т');  // Ввод заглавной буквы

        // Assert
        assertThat(gameManager.getCurrentGameProgress()).contains("к о т");
    }
}
