package backend.academy.hangman_game;

import lombok.experimental.UtilityClass;
import java.io.IOException;
import java.util.List;

@UtilityClass
public class Main {
    public static void main(String[] args) throws IOException {
        // Список слов
        List<String> words = List.of(
            "лев", "тигр", "слон", "кошка", "собака", "гетеродонтозавр",           // ANIMALS
            "футбол", "баскетбол", "теннис", "волейбол", "гольф", // SPORT_TYPES
            "бмв", "мерседес", "тойота", "ауди", "хонда"        // CAR_BRANDS
        );

        // Список подсказок
        List<String> hints = List.of(
            "Царь зверей", "Полосатый хищник", "Большое млекопитающее", "Домашнее животное", "Друг человека", "Динозавр, живший в ранней юре, 200–190 миллионов лет назад",   // ANIMALS
            "Игра ногами", "Игра с мячом и кольцом", "Ракетки и мяч", "Игра у сетки", "Игра с клюшкой",        // SPORT_TYPES
            "Немецкая марка", "Люкс немецкого автопрома", "Японский автогигант", "Четыре кольца", "Японская марка"  // CAR_BRANDS
        );

        // Список категорий
        List<WordCategory> wordCategories = List.of(
            WordCategory.ANIMALS, WordCategory.ANIMALS, WordCategory.ANIMALS, WordCategory.ANIMALS, WordCategory.ANIMALS, WordCategory.ANIMALS, // ANIMALS
            WordCategory.SPORT_TYPES, WordCategory.SPORT_TYPES, WordCategory.SPORT_TYPES, WordCategory.SPORT_TYPES, WordCategory.SPORT_TYPES, // SPORT_TYPES
            WordCategory.CAR_BRANDS, WordCategory.CAR_BRANDS, WordCategory.CAR_BRANDS, WordCategory.CAR_BRANDS, WordCategory.CAR_BRANDS  // CAR_BRANDS
        );

        Game.initializeGameWords(words, hints, wordCategories);

        Game.start();
    }
}
