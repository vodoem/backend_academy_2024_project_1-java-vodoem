package backend.academy.samples.hangman_game_tests;

import backend.academy.hangman_game.Game;
import backend.academy.hangman_game.GameWordDTO;
import backend.academy.hangman_game.WordCategory;
import backend.academy.hangman_game.WordDifficultyLevel;
import backend.academy.hangman_game.WordsStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

//Тест для проверки состояния игры после каждого ввода
public class GameStateTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        WordsStorage wordsStorage = new WordsStorage(
            List.of(new GameWordDTO("кот", "Домашнее животное", WordCategory.ANIMALS, WordDifficultyLevel.EASY)));
        game = new Game(wordsStorage);
        game.initializeGame(WordCategory.ANIMALS, WordDifficultyLevel.EASY);
    }

    @Test
    public void shouldDisplayWordProgressCorrectlyAfterEachGuess() {
        // Act
        game.handleGuess('к');
        String progressAfterFirstGuess = game.getWordProgress();

        game.handleGuess('о');
        String progressAfterSecondGuess = game.getWordProgress();

        // Assert
        assertThat(progressAfterFirstGuess).isEqualTo("к _ _");
        assertThat(progressAfterSecondGuess).isEqualTo("к о _");
    }
}
