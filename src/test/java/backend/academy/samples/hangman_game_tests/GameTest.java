package backend.academy.samples.hangman_game_tests;

import backend.academy.hangman_game.GameWordDTO;
import backend.academy.hangman_game.WordCategory;
import backend.academy.hangman_game.WordDifficultyLevel;
import backend.academy.hangman_game.WordsStorage;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {
    @Test
    void shouldSelectRandomWordFromCorrectCategoryAndDifficulty(){
        List<GameWordDTO> gameWords = List.of(
            new GameWordDTO("лев", "Царь зверей", WordCategory.ANIMALS),
            new GameWordDTO("футбол", "Игра ногами", WordCategory.SPORT_TYPES)
        );
        WordsStorage.initializeGameWords(gameWords);

        GameWordDTO randomWord = WordsStorage.getRandomWordWithChosenCategoryAndDifficultLevel(WordCategory.ANIMALS,
            WordDifficultyLevel.EASY);

        assertThat(randomWord.getWord()).isEqualTo("лев");
    }
}
