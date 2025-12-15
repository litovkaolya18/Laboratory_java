import number1.Fraction;
import number3.ListChange;

import java.util.Scanner;
import java.lang.*;
import java.util.*;

/**
 * Класс для проверок
 */
class Check {
    private Scanner scanner;

    public Check() {
        this.scanner = new Scanner(System.in);
    }

    // Геттер для scanner
    public Scanner getScanner() {
        return scanner;
    }

    // Проверить и получить целое число
    public int getInt(String number) {
        while (true) {
            System.out.print(number);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число: ");
            }
        }
    }

    // Статический метод для создания дроби из ввода
    public static Fraction inputFraction(Scanner scanner) {
        System.out.print("Введите числитель: ");
        int numerator = scanner.nextInt();

        int denominator;
        while (true) {
            System.out.print("Введите знаменатель: ");
            denominator = scanner.nextInt();
            if (denominator != 0) {
                break;
            }
            System.out.println("Ошибка! Знаменатель не может быть 0. Попробуйте снова.");
        }
        // Очистка буфера
        scanner.nextLine();

        return new Fraction(numerator, denominator);
    }


    // Проверить, что знаменатель не равен 0
    public int getDenominator(String number) {
        while (true) {
            int den = getInt(number);
            if (den != 0) {
                return den;
            }
            System.out.println("Ошибка! Знаменатель не может быть равен 0.");
        }
    }

    /**
     * Получить текст с проверкой на пустоту
     * @param message сообщение для пользователя
     * @return проверенный текст
     */
    public String getString(String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim();
            if (text.isEmpty()) {
                System.out.println("Ошибка! Текст не может быть пустым.");
                continue;  // переходим к следующей итерации while
            }

            boolean val = true;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                        (c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я') ||
                        c == 'ё' || c == 'Ё' || c == ' ' || c == '-')) {
                    System.out.println("Ошибка! Введите только текст (буквы и пробелы).");
                    val = false;
                    break;
                }
            }
            if (val) {
                return text;
            }
        }
    }

    /**
     * СОЗДАТЬ СПИСОК ЧИСЕЛ с проверкой на пустоту
     */
    public List<Integer> createIntList(String listName) {
        System.out.println("\n--- Создаем список " + listName + " ---");

        List<Integer> list = new ArrayList<>();
        int size = getInt("Сколько чисел в списке? ");

        if (size <= 0) {
            System.out.println("Список будет пустым.");
            return list;
        }

        for (int i = 0; i < size; i++) {
            int num = getInt("Число " + (i + 1) + ": ");
            list.add(num);
        }

        // Проверка на пустой список после создания
        if (list.isEmpty()) {
            System.out.println("Внимание! Список " + listName + " пустой.");
        }

        System.out.println("Создан: " + ListChange.print(list));
        return list;
    }

    /**
     * СОЗДАТЬ СПИСОК СТРОК с проверкой на пустоту
     */
    public List<String> createStringList(String listName) {
        System.out.println("\n--- Создаем список " + listName + " ---");

        List<String> list = new ArrayList<>();
        int size = getInt("Сколько слов в списке? ");

        if (size <= 0) {
            System.out.println("Список будет пустым.");
            return list;
        }

        for (int i = 0; i < size; i++) {
            String word = getString("Слово " + (i + 1) + ": ");
            list.add(word);
        }

        // Проверка на пустой список
        if (list.isEmpty()) {
            System.out.println("Внимание! Список " + listName + " пустой.");
        }

        System.out.println("Создан: " + ListChange.print(list));
        return list;
    }


    // Создать список чисел
    public List<Integer> createList() {
        List<Integer> list = new ArrayList<>();
        int n = getInt("Сколько чисел ввести? ");

        for (int i = 0; i < n; i++) {
            int num = getInt("Число " + (i+1) + ": ");
            list.add(num);
        }
        return list;
    }


    // Закрыть сканер
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
