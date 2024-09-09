package backend.academy.hangman_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsStorage {
    private static List<GameWordDTO> gameWords;

    public static void initializeGameWords(List<GameWordDTO> gameWords) {
        WordsStorage.gameWords = gameWords;
    }

    public static List<GameWordDTO> getGameWords() {
        return gameWords;
    }

    public static GameWordDTO getRandomWordWithChosenCategoryAndDifficultLevel(
        WordCategory wordCategory,
        WordDifficultyLevel wordDifficultyLevel
    ) {
        Random randomizer = new Random();
        List<GameWordDTO> list =
            WordsStorage.getGameWordsWithChosenCategoryAndDifficultLevel(wordCategory, wordDifficultyLevel);
        return list.get(randomizer.nextInt(list.size()));
    }

    private static List<GameWordDTO> getGameWordsWithChosenCategoryAndDifficultLevel(
        WordCategory wordCategory,
        WordDifficultyLevel wordDifficultyLevel
    ) {
        List<GameWordDTO> resultList = new ArrayList<>();
        for (GameWordDTO word : WordsStorage.gameWords) {
            if (word.getWordCategoty() == wordCategory && word.getWordDifficultyLevel() == wordDifficultyLevel) {
                resultList.add(word);
            }
        }
        return resultList;
    }

}
