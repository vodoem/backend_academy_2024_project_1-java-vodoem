package backend.academy.hangman_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordsStorage {
    private static List<RightWordDTO> gameWords;

    public static void initializeGameWords(List<RightWordDTO> gameWords){
        WordsStorage.gameWords = gameWords;
    }

    public static List<RightWordDTO> getGameWords() {
        return gameWords;
    }

    public static RightWordDTO getRandomWordWithChosenCategoryAndDifficultLevel(
        WordCategoty wordCategoty,
        WordDifficultyLevel wordDifficultyLevel
    ) {
        Random randomizer = new Random();
        List<RightWordDTO> list =
            WordsStorage.getGameWordsWithChosenCategoryAndDifficultLevel(wordCategoty, wordDifficultyLevel);
        return list.get(randomizer.nextInt(list.size()));
    }

    private static List<RightWordDTO> getGameWordsWithChosenCategoryAndDifficultLevel(
        WordCategoty wordCategoty,
        WordDifficultyLevel wordDifficultyLevel
    ) {
        List<RightWordDTO> resultList = new ArrayList<>();
        for (RightWordDTO word : WordsStorage.gameWords) {
            if (word.getWordCategoty() == wordCategoty && word.getWordDifficultyLevel() == wordDifficultyLevel) {
                resultList.add(word);
            }
        }
        return resultList;
    }

}
