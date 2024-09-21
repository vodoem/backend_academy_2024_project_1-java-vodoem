package backend.academy.hangman_game;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InputHandler {
    private static final int FIRST_CHOICE = 1;
    private static final int SECOND_CHOICE = 2;
    private static final int THIRD_CHOICE = 3;

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
            case FIRST_CHOICE -> WordCategory.ANIMALS;
            case SECOND_CHOICE -> WordCategory.SPORT_TYPES;
            case THIRD_CHOICE -> WordCategory.CAR_BRANDS;
            default -> {
                System.out.println("Некорректный выбор, выбрана категория по умолчанию.");
                Random random = new Random();
                List<WordCategory> categories = List.of(WordCategory.values());
                yield categories.get(random.nextInt(categories.size()));
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
            case FIRST_CHOICE -> WordDifficultyLevel.EASY;
            case SECOND_CHOICE -> WordDifficultyLevel.MEDIUM;
            case THIRD_CHOICE -> WordDifficultyLevel.HARD;
            default -> {
                System.out.println("Некорректный выбор, выбран уровень сложности по умолчанию.");
                Random random = new Random();
                List<WordDifficultyLevel> levels = List.of(WordDifficultyLevel.values());
                yield levels.get(random.nextInt(levels.size()));
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
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.next();
            }
        }
    }
}
