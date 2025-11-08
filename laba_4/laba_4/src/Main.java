import java.util.Objects;
import java.util.Scanner;
import java.lang.*;
/**
* Главный класс Main - лабораторная номер 4
*/

public class Main {
    public static void main(String[] args) {
        int number;
        Check check = new Check();

        while (true) {
            System.out.print("\n" + "Здравствуй! Выбери одно из заданий:\n");
            System.out.print("1 - Обобщенная коробка\n" +
                    "2 - Без null\n" +
                    "3 - Начало отсчета\n");
            Scanner scanner = new Scanner(System.in);
            number = check.getInt("Введите номер задания: ");
            boolean running = true;


            switch (number) {
                case 1: {
                    while (running) {
                        System.out.println("\n---Обобщенная коробка---");
                        System.out.println("1 - Пример из задания");
                        System.out.println("2 - Создание своей коробки");
                        System.out.println("0 - Выход");

                        int choice = check.getInt("Выберите действие: ");
                        switch (choice) {
                            case 1: {
                                System.out.println("Создаем коробку которая может хранить число 3");

                                Box<Integer> numBox = new Box<>();
                                // Показываем, что коробка сначала пустая
                                System.out.println("Cоздана: " + numBox);
                                System.out.println("Коробка заполнена? " + numBox.full());

                                try {
                                    numBox.putObject(3);
                                    System.out.println("Создана: " + numBox);
                                } catch (IllegalStateException e) {
                                    System.out.println("Ошибка: " + e.getMessage());
                                }

                                // Показываем, что коробка теперь заполнена
                                System.out.println("Коробка заполнена? " + numBox.full());

                                System.out.println("Пытаемся положить еще один объект в коробку - число 5");
                                // Пытаемся положить еще один объект (должно вызвать исключение)
                                try {
                                    numBox.putObject(5); // пытаемся положить второе число
                                    System.out.println("Положили еще число: " + numBox);
                                } catch (IllegalStateException e) {
                                    System.out.println("Ошибка при попытке положить второй объект: " + e.getMessage());
                                }

                                processBox(numBox); //передача коробки в метод
                                break;
                            }
                            case 2: {
                                System.out.println("\n1 - Коробка для строк");
                                System.out.println("2 - Коробка для целых чисел");
                                System.out.println("3 - Коробка для дробных чисел");

                                int typeChoice = check.getInt("Выберете тип коробки: ");

                                if (typeChoice == 1) {
                                    Box<String> userBox = new Box<>();
                                    String object = check.getString("Введите текст для коробки: ");
                                    userBox.putObject(object);
                                    System.out.println("Ваша коробка: " + userBox);

                                    //показываем извлечение
                                    if (userBox.full()) {
                                        String extracted = userBox.takeFilling();
                                        System.out.println("Извлекли: " + extracted);
                                        System.out.println("Коробка теперь: " + userBox);
                                    }
                                } else if (typeChoice == 2) {
                                    Box<Integer> userBox = new Box<>();
                                    int object = check.getInt("Введите целое число для коробки: ");
                                    userBox.putObject(object);
                                    System.out.println("Ваша коробка: " + userBox);

                                    // Показываем извлечение
                                    if (userBox.full()) {
                                        Integer extracted = userBox.takeFilling();
                                        System.out.println("Извлекли: " + extracted);
                                        System.out.println("Коробка теперь: " + userBox);
                                    }
                                } else if (typeChoice == 3) {
                                    Box<Double> userBox = new Box<>();
                                    double object = check.getDouble("Введите дробное число для коробки: ");
                                    userBox.putObject(object);
                                    System.out.println("Ваша коробка: " + userBox);

                                    // Показываем извлечение
                                    if (userBox.full()) {
                                        Double extracted = userBox.takeFilling();
                                        System.out.println("Извлекли: " + extracted);
                                        System.out.println("Коробка теперь: " + userBox);
                                    }
                                } else {
                                    System.out.print("Неверный выбор");
                                }
                                break;
                            }
                            case 0: {
                                running = false;
                                System.out.println("Программа завершена.");
                                break;
                            }
                            default: {
                                System.out.println("Неверный выбор! Попробуйте снова.");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    Box<Point> pointBox = new Box<>();
                    Box<Object> point1Box = new Box<>();
                    Box.putPoint(pointBox);
                    Box.putPoint(point1Box);
                    break;
                }
            }
        }
    }
    // Метод для демонстрации передачи коробки (как в задании)
    private static void processBox (Box < Integer > box) {
        if (box.full()) {
            Integer value = box.takeFilling();
            System.out.println("\nИзвлекли значение: " + value);
            System.out.println("Выводим на экран: " + value);
            System.out.println("Коробка после извлечения: " + box);
        }
    }
}