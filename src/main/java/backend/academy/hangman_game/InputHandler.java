package backend.academy.hangman_game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public WordCategory chooseCategory() {
        System.out.println("Выберите категорию:");
        System.out.println("1. Животные");
        System.out.println("2. Виды спорта");
        System.out.println("3. Автомобильные марки");

        int choice = getValidIntegerInput();
        return switch (choice) {
            case 1 -> WordCategory.ANIMALS;
            case 2 -> WordCategory.SPORT_TYPES;
            case 3 -> WordCategory.CAR_BRANDS;
            default -> {
                System.out.println("Некорректный выбор, выбрана категория по умолчанию.");
                yield WordCategory.ANIMALS;
            }
        };
    }

    public WordDifficultyLevel chooseDifficultyLevel() {
        System.out.println("Выберите уровень сложности:");
        System.out.println("1. Легкий");
        System.out.println("2. Средний");
        System.out.println("3. Сложный");

        int choice = getValidIntegerInput();
        return switch (choice) {
            case 1 -> WordDifficultyLevel.EASY;
            case 2 -> WordDifficultyLevel.MEDIUM;
            case 3 -> WordDifficultyLevel.HARD;
            default -> {
                System.out.println("Некорректный выбор, выбран уровень сложности по умолчанию.");
                yield WordDifficultyLevel.EASY;
            }
        };
    }

    public char getGuess() {
        System.out.println("Введите букву:");
        String input = scanner.nextLine().trim();
        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Некорректный ввод. Пожалуйста, введите одну букву.");
            return getGuess();
        }
        return Character.toLowerCase(input.charAt(0));
    }

    public boolean getYesNoAnswer() {
        System.out.println("Хотите сыграть еще раз? (да/нет)");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("да") || input.equals("д");
    }

    private int getValidIntegerInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // Clear the newline character
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}
