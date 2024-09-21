package backend.academy.hangman_game;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class InputHandler {
    private static final int FIRST_CHOICE = 1;
    private static final int SECOND_CHOICE = 2;
    private static final int THIRD_CHOICE = 3;
    private final Random random = new SecureRandom();
    private final PrintStream printStream = System.out;
    private final Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    }

    public WordCategory chooseCategory() {
        printStream.println("Выберите категорию:");
        printStream.println("1. Животные");
        printStream.println("2. Виды спорта");
        printStream.println("3. Автомобильные марки");

        int choice = getValidIntegerInput();
        return switch (choice) {
            case FIRST_CHOICE -> WordCategory.ANIMALS;
            case SECOND_CHOICE -> WordCategory.SPORT_TYPES;
            case THIRD_CHOICE -> WordCategory.CAR_BRANDS;
            default -> {
                printStream.println("Некорректный выбор, выбрана категория по умолчанию.");
                List<WordCategory> categories = List.of(WordCategory.values());
                yield categories.get(random.nextInt(categories.size()));
            }
        };
    }

    public WordDifficultyLevel chooseDifficultyLevel() {
        printStream.println("Выберите уровень сложности:");
        printStream.println("1. Легкий");
        printStream.println("2. Средний");
        printStream.println("3. Сложный");

        int choice = getValidIntegerInput();
        return switch (choice) {
            case FIRST_CHOICE -> WordDifficultyLevel.EASY;
            case SECOND_CHOICE -> WordDifficultyLevel.MEDIUM;
            case THIRD_CHOICE -> WordDifficultyLevel.HARD;
            default -> {
                printStream.println("Некорректный выбор, выбран уровень сложности по умолчанию.");
                List<WordDifficultyLevel> levels = List.of(WordDifficultyLevel.values());
                yield levels.get(random.nextInt(levels.size()));
            }
        };
    }

    public char getGuess() {
        printStream.println("Введите букву:");
        String input = scanner.nextLine().trim();
        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            printStream.println("Некорректный ввод. Пожалуйста, введите одну букву.");
            return getGuess();
        }
        return Character.toLowerCase(input.charAt(0));
    }

    public boolean isContinueGameRequested() {
        printStream.println("Хотите сыграть еще раз? (да/нет)");
        String input = scanner.nextLine().trim().toLowerCase();
        return "да".equalsIgnoreCase(input) || "д".equalsIgnoreCase(input);
    }

    private int getValidIntegerInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                printStream.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.next();
            }
        }
    }
}
