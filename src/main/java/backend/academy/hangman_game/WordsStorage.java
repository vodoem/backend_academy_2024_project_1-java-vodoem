package backend.academy.hangman_game;

import java.util.List;
import java.util.Random;

public class WordsStorage {
    private final List<GameWordDTO> words;

    public WordsStorage(List<GameWordDTO> words) {
        this.words = words;
    }

    public GameWordDTO getRandomWordWithChosenCategoryAndDifficultyLevel(
        WordCategory category,
        WordDifficultyLevel difficulty
    ) {
        Random random = new Random();
        return words.stream()
            .filter(word -> word.getCategory() == category && word.getDifficulty() == difficulty)
            .findAny()
            .orElse(words.get(random.nextInt(words.size())));
    }

    public List<GameWordDTO> getWords() {
        return words;
    }
}
