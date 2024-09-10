package backend.academy.hangman_game;

import java.util.ArrayList;
import java.util.List;

public class GameWordsCreator {

    private static List<GameWordDTO> words;

    public static List<GameWordDTO> gameWordsCreating(
        List<String> words,
        List<String> hints,
        List<WordCategory> wordCategories
    ) {
        if (GameWordsCreator.areArgumentsSameLength(words, hints, wordCategories)) {
            GameWordsCreator.words = GameWordsCreator.wordsListCreating(words, hints, wordCategories);
        }
        return GameWordsCreator.words;
    }

    private static List<GameWordDTO> wordsListCreating(
        List<String> words,
        List<String> hints,
        List<WordCategory> wordCategories
    ) {
        List<GameWordDTO> wordsList = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            wordsList.add(new GameWordDTO(words.get(i), hints.get(i), wordCategories.get(i)));
        }
        return wordsList;
    }

    private static boolean areArgumentsSameLength(
        List<String> words,
        List<String> hints,
        List<WordCategory> wordCategories
    ) {
        return words.size() == hints.size() && hints.size() == wordCategories.size();
    }

}
