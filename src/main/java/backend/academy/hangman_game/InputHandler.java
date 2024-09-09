package backend.academy.hangman_game;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;
    private final WordDifficultyLevel[] difficultyLevels = WordDifficultyLevel.values();
    private final WordCategory[] categories = WordCategory.values();

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    // Метод для выбора уровня сложности
    public WordDifficultyLevel selectDifficulty() {
        System.out.println("Выберите уровень сложности:");
        displayOptions(difficultyLevels);
        int selectedOption = getUserSelection(difficultyLevels.length);
        System.out.println("Вы выбрали: " + difficultyLevels[selectedOption - 1]);
        return difficultyLevels[selectedOption - 1];
    }

    // Метод для выбора категории слов
    public WordCategory selectCategory() {
        System.out.println("Выберите категорию слов:");
        displayOptions(categories);
        int selectedOption = getUserSelection(categories.length);
        System.out.println("Вы выбрали: " + categories[selectedOption - 1]);
        return categories[selectedOption - 1];
    }

    // Метод для отображения вариантов
    private <T extends Enum<T>> void displayOptions(T[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i].toString());
        }
    }

    // Метод для получения корректного выбора пользователя
    private int getUserSelection(int maxOption) {
        int selection = promptForNumber();
        while (!isValidSelection(selection, maxOption)) {
            System.out.println("Некорректный ввод. Попробуйте снова.");
            selection = promptForNumber();
        }
        return selection;
    }

    private int promptForNumber() {
        while (!scanner.hasNextInt()) {
            System.out.print("Введите число: ");
            scanner.next(); // Пропустить нечисловой ввод
        }
        return scanner.nextInt();
    }

    private boolean isValidSelection(int selection, int maxOption) {
        return selection >= 1 && selection <= maxOption;
    }

    // Метод для ввода буквы
    public char getGuess() {
        System.out.println("Введите букву для угадывания: ");
        String input = scanner.next();
        while (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Введите одну букву: ");
            input = scanner.next();
        }
        return Character.toLowerCase(input.charAt(0));
    }

    public void close() {
        scanner.close();
    }
}
