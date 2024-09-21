package backend.academy.hangman_game;

public enum WordCategory {
    ANIMALS("Животные"),
    SPORT_TYPES("Виды спорта"),
    CAR_BRANDS("Марки машин");

    private final String title;

    WordCategory(String title) {
        this.title = title;
    }

    //не используется, но может использоваться в InputHandler (на мой взгляд только усложнит читабильность)
    @Override public String toString() {
        return title;
    }
}
