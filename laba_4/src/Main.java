import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;//
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
                    "2 - Начало отсчета\n" +
                    "3 - Функция\n" +
                    "0 - Выход\n");
            number = check.getInt("Введите номер задания: ");
            boolean running = true;


            switch (number) {
                case 1: {
                    while (running) {
                        System.out.println("\n---Обобщенная коробка---\n" +
                                "1 - Пример из задания\n" +
                                "2 - Создание своей коробки\n" +
                                "0 - Выход\n");

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
                                System.out.println("\n1 - Коробка для строк\n" +
                                        "2 - Коробка для целых чисел\n" +
                                        "3 - Коробка для дробных чисел\n");

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
                    System.out.println("\n---Начало отсчета---\n");
                    Box<Point> pointBox = new Box<>();
                    Box<Object> point1Box = new Box<>();
                    Box.putPoint(pointBox);
                    Box.putPoint(point1Box);
                    break;
                }
                case 3: {
                    System.out.println("\n---Функция---");
                    System.out.println("1 - Пример из задания\n" +
                            "2 - Введение своих данных");
                    int choice = check.getInt("Выберите действие: ");
                    switch (choice) {
                        case 1: {
                            List<String> string1 = Arrays.asList("qwerty", "asdfg", "zx");
                            System.out.println("\nИсходный список: " + string1);
                            List<Integer> string2 = Metod1.process(string1, value -> value.length());
                            System.out.println("Длина строки: " + string2);

                            List<Integer> num1 = Arrays.asList(1,-3,7);
                            System.out.println("\nИсходные числа: " + num1);
                            List<Integer> num2 = Metod1.process(num1, value -> Math.abs(value));
                            System.out.println("Противоположное число(абсолютные): " + num2);

                            List<int[]> arrays = Arrays.asList(
                                    new int[]{2, 7, 9},
                                    new int[]{-6, -3, -1},
                                    new int[]{4, 10, 8}
                            );
                            System.out.println("\nИсходные массивы: ");
                            for (int[] arr : arrays) {
                                System.out.print(Arrays.toString(arr) + " ");
                            }
                            System.out.println();
                            List<Integer> maxValues = Metod1.process(arrays, value -> Check.findMax(value));
                            System.out.println("Максимальные числа из трёх массивов: " + maxValues);
                            break;
                        }
                        case 2: {
                            System.out.println("\n1 - Строки в длины\n" +
                                    "2 - Противоположное число(абсолютные)\n" +
                                    "3 - Максимальные числа из введённых массивов\n" +
                                    "0 - Выход");
                            int choice1 = check.getInt("Выберите действие: ");
                            switch (choice1) {
                                case 1: {
                                    int count = check.getInt("Сколько строк ввести?: ");
                                    count = Check.getCheckNum(count);

                                    List<String> userStrings = new ArrayList<>();
                                    for (int i = 0; i < count; i++) {
                                        String str = check.getString("Введите строку " + (i + 1) + ": ");
                                        userStrings.add(str);
                                    }
                                    System.out.println("Исходный список: " + userStrings);

                                    List<Integer> userLengths = Metod1.process(userStrings,
                                            value -> value.length());
                                    System.out.println("Длины строк: " + userLengths);
                                    break;
                                }
                                case 2: {
                                    int count = check.getInt("Сколько чисел ввести?: ");
                                    count = Check.getCheckNum(count);
                                    List<Integer> userNumbers = new ArrayList<>();
                                    for (int i = 0; i < count; i++) {
                                        int num = check.getInt("Введите число " + (i + 1) + ": ");
                                        userNumbers.add(num);
                                    }
                                    System.out.println("Исходный список: " + userNumbers);
                                    List<Integer> squares = Metod1.process(userNumbers, value -> Math.abs(value));
                                    System.out.println("Противоположное число(абсолютные):" + squares);
                                    break;
                                }
                                case 3: {
                                    // Дополнительно: ввод массивов от пользователя
                                    System.out.print("Сколько массивов создать: ");
                                    int arrayCount = check.getInt("");

                                    List<int[]> userArrays = new ArrayList<>();
                                    for (int i = 0; i < arrayCount; i++) {
                                        System.out.print("Сколько чисел в массиве " + (i+1) + ": ");
                                        int size = check.getInt("");
                                        int[] arr = new int[size];
                                        for (int j = 0; j < size; j++) {
                                            arr[j] = check.getInt("Число " + (j+1) + ": ");
                                        }
                                        userArrays.add(arr);
                                    }

                                    List<Integer> userMaxValues = Metod1.process(userArrays, value -> Check.findMax(value));
                                    System.out.println("Максимумы пользовательских массивов: " + userMaxValues);
                                    break;
                                }
                                default: {
                                    System.out.println("Неверный выбор!");
                                }
                            }
                            break;
                        }
                        default: {
                            System.out.println("Неверный выбор!");
                        }
                    }
                    break;

                }
                case 4: {
//                    System.out.println("\n---Фильтр---");
//                    System.out.println("1 - Пример из задания\n" +
//                            "2 - Введение своих данных");
//                    int choice = check.getInt("Выберите действие: ");
//                    case 1: {
//                        List<String> strings1 = Arrays.asList("qwerty", "asdfg", "zx");
//                        System.out.println("\nИсходный список строк: " + strings1);
//                        List<String> strings2 = Filter.filter(strings1,
//                                value -> value.length() >= 3);
//                        System.out.println("Строки длиной >= 3 символов: " + strings2);
//
//
//                        List<Integer> num1 = Arrays.asList(1, -3, 7);
//                        System.out.println("\nИсходный список чисел: " + num1);
//                        List<Integer> numb2 = Filter.filter(num1,
//                                value -> value > 0);
//                        System.out.println("Положительные числа: " + numb2);
//
//
//                        List<int[]> arrays = Arrays.asList(
//                                new int[]{-1, -2, -3},
//                                new int[]{-5, 2, -1},
//                                new int[]{-7, -8, -9}
//                        );
//                        System.out.print("\nИсходные массивы: ");
//                        for (int[] arr : arrays) {
//                            System.out.print(Arrays.toString(arr) + " ");
//                        }
//                        System.out.println();
//
//                        List<int[]> negativeArrays = Filter.filter(arrays, value ->
//                        {
//                                    for (int num : value) {
//                                        if (num > 0) return false;
//                                    }
//                                    return true;
//                                });
//
//                        System.out.print("Массивы без положительных элементов: ");
//                        for (int[] arr : negativeArrays) {
//                            System.out.print(Arrays.toString(arr) + " ");
//                        }
//                        System.out.println();
//                        break;
//                    }

                }
                case 0: {
                    System.out.println("Программа завершена.");
                    return;
                }
                default: {
                    System.out.println("Неверный выбор!");
                }
            }
        }
    }
    // Метод для демонстрации передачи коробки (задание 1)
    private static void processBox (Box < Integer > box) {
        if (box.full()) {
            Integer value = box.takeFilling();
            System.out.println("\nИзвлекли значение: " + value);
            System.out.println("Выводим на экран: " + value);
            System.out.println("Коробка после извлечения: " + box);
        }
    }
}
