package backend.academy.hangman_game;

public class RightWordDTO {
    private final String word;
    private final String hint;
    private final WordDifficultyLevel wordDifficultyLevel;
    private final WordCategoty wordCategoty;

    public RightWordDTO(String word, String hint, WordCategoty wordCategoty) {
        this.word = word;
        this.hint = hint;
        this.wordCategoty = wordCategoty;
        if (word.length() < 5) {
            wordDifficultyLevel = WordDifficultyLevel.Easy;
        } else if (word.length() < 8) {
            wordDifficultyLevel = WordDifficultyLevel.Medium;
        } else {
            wordDifficultyLevel = WordDifficultyLevel.Hard;
        }
    }

    public WordCategoty getWordCategoty() {
        return wordCategoty;
    }

    public WordDifficultyLevel getWordDifficultyLevel() {
        return wordDifficultyLevel;
    }

    public String getHint() {
        return hint;
    }

    public String getWord() {
        return word;
    }
}
