package backend.academy.hangman_game;

public enum WordCategory {
    ANIMALS("Животные"),
    SPORT_TYPES("Виды спорта"),
    CAR_BRANDS("Марки машин");

    private final String title;

    private WordCategory(String title) {
        this.title = title;
    }

    @Override public String toString() {
        return title;
    }
}
