import java.util.Scanner;

public class Check {
    private Scanner scanner;

    public Check() {
        this.scanner = new Scanner(System.in);
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
     * Получить число с плавающей точкой с проверкой
     * @param number сообщение для пользователя
     * @return проверенное дробное число
     */
    public double getDouble(String number) {
        while (true) {
            System.out.print(number);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите число.");
            }
        }
    }

    /**
     * Найти максимальное значение в массиве
     */
    public static int findMax(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не может быть пустым");
        }
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }
    /**
     * Проверяет, что число является положительным.
     * @param num число для проверки
     * @return положительное число
     */
    public static int getCheckNum(int num) {
        Scanner scanner = new Scanner(System.in);

        while (num < 1) {
            System.out.print("Введите положительное число: ");
            num = scanner.nextInt();
        }
        return num;
    }

    /**
     * Проверить, что в массиве нет положительных элементов
     */
    public static boolean hasNoPositive(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        for (int num : array) {
            if (num > 0) return false;
        }
        return true;
    }


//    /**
//     * Получить список чисел от пользователя
//     */
//    public List<Integer> getNumberList(String message, int count) {
//        System.out.println(message);
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            int num = getInt("Число " + (i + 1) + ": ");
//            list.add(num);
//        }
//        return list;
//    }

//    public double Coordinate(String coordinateName) {
//        double n;
//        while (true) {
//            System.out.print("Введите координату " + coordinateName + ": ");
//            if (scanner.hasNextDouble()) {
//                n = scanner.nextDouble();
//                scanner.nextLine();
//                return n;
//            } else {
//                System.out.println("Ошибка! Пожалуйста введите число: ");
//                scanner.nextLine();
//            }
//        }
//    }
}
