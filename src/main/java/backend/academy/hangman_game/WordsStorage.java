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

        List<GameWordDTO> filteredWords = words.stream()
            .filter(word -> word.getCategory() == category &&
                word.getDifficulty() == difficulty &&
                word.getWord().length() > 2)
            .toList();

        if (filteredWords.isEmpty()) {
            throw new IllegalArgumentException("Некорректная длина слова: слово должно содержать более 2 символов");
        }

        return filteredWords.get(random.nextInt(filteredWords.size()));
    }

    public List<GameWordDTO> getWords() {
        return words;
    }
}
