import number1.Fraction;
import number1.FractionCached;
import number2.Cat;
import number2.MeowCounter;
import number2.Meowable;
import number3.ListChange;

import java.lang.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Главный класс Main - лабораторная номер 5
 */
public class Main {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        Check check = new Check();

        while (true) {
            System.out.print("\n" + "Здравствуй! Выбери одно из заданий:\n");
            System.out.print("1 - Шаблоны. Класс Дробь\n" +
                    "2 - Структурные шаблоны. Количество мяуканий\n" +
                    "3 - Список. Замена списков\n" +
                    "4 - Функция\n" +
                    "5 - Фильтр\n" +
                    "6 - Сокращение\n" +
                    "0 - Выход\n");
            number = check.getInt("Введите номер задания: ");

            switch (number) {
                case 1: {
                    System.out.println("\nРабота с дробями ");

                    //Первая Дробь
                    System.out.println("Введите первую дробь:");
                    Fraction f1 = Check.inputFraction(scanner);
                    System.out.println("Первая дробь: " + f1);
                    System.out.println("Вещественное значение: " + f1.getRealValue());

                    //Вторая Дробь
                    System.out.println("\nВведите вторую дробь:");
                    Fraction f2 = Check.inputFraction(scanner);
                    System.out.println("Вторая дробь: " + f2);
                    System.out.println("Вещественное значение: " + f2.getRealValue());

                    //Сравнение
                    System.out.println("\nДроби равны? " + f1.equals(f2));

                    //Кэширование
                    System.out.print("\nКэширование");
                    FractionCached cached = new FractionCached(f1);
                    System.out.println("\nКэш 1 (первый вызов): " + cached.getRealValue());
                    System.out.println("Кэш 2 (второй вызов): " + cached.getRealValue());

                    // Изменяем дробь через кэш
                    System.out.print("\nИзменение дроби");
                    System.out.println("\nИзменяем дробь на 6/-10:");
                    cached.setFraction(6, -10);
                    System.out.println("Новая дробь (через кэш): " + cached);
                    System.out.println("Кэш пересчитан: " + cached.getRealValue());
                    break;
                }
                case 2: {
                    System.out.println("\nКоличество мяуканий");
                    String catName = check.getString("Введите имя коту: ");
                    Meowable cat = new Cat(catName);

                    int meow = check.getInt("Сколько раз должен мяукнуть кот? -  ");

                    int meowCount = MeowCounter.allMeow(cat, meow);
                    System.out.println("Кот " + catName + " мяукал " +  meowCount + " раз");
                    break;
                }
                case 3: {
                    System.out.println("\nВыберите тип списков:\n");
                    System.out.println("1. Списки чисел\n" +
                            "2. Списки строк\n" +
                            "0. Вернуться в меню\n");
                    int listType = check.getInt("Ваш выбор: ");

                    if (listType == 0) {
                        break;
                    }

                    switch (listType) {
                        case 1: {
                            System.out.println("Список чисел");
                            System.out.println("\nСоздаем основной список L");
                            List<Integer> L = check.createIntList("L");

                            System.out.println("\nСоздаем список L1 (что ищем)");
                            List<Integer> L1 = check.createIntList("L1");

                            System.out.println("\nСписок L2 (на что меняем)");
                            List<Integer> L2 = check.createIntList("L2");

                            System.out.println("\nВаши списки:");
                            System.out.println("L:  " + ListChange.print(L));
                            System.out.println("L1: " + ListChange.print(L1));
                            System.out.println("L2: " + ListChange.print(L2));

                            List<Integer> result = ListChange.change(L, L1, L2);

                            if (result.equals(L)) {
                                System.out.println("\nРезультат: L1 не найден в L");
                                System.out.println("L остался: " + ListChange.print(L));
                            } else {
                                System.out.println("\nРезультат: замена выполнена!");
                                System.out.println("Было: " + ListChange.print(L));
                                System.out.println("Стало: " + ListChange.print(result));
                            }
                            break;
                        }
                        case 2: {
                            List<String> L = check.createStringList("L");
                            List<String> L1 = check.createStringList("L1");
                            List<String> L2 = check.createStringList("L2");

                            System.out.println("\nВаши списки:");
                            System.out.println("L:  " + ListChange.print(L));
                            System.out.println("L1: " + ListChange.print(L1));
                            System.out.println("L2: " + ListChange.print(L2));

                            List<String> result = ListChange.change(L, L1, L2);

                            if (result.equals(L)) {
                                System.out.println("\nРезультат: L1 не найден в L");
                                System.out.println("L остался: " + ListChange.print(L));
                            } else {
                                System.out.println("\nРезультат: замена выполнена!");
                                System.out.println("Было: " + ListChange.print(L));
                                System.out.println("Стало: " + ListChange.print(result));
                            }
                            break;
                        }
                    }
                }
                case 0: {
                    System.out.println("Программа завершена.");
                    return;
                }
                default: {
                    System.out.println("Задание с номером " + number + " еще не реализовано");
                }
            }
        }
    }
}
