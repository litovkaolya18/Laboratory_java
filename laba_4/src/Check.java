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

    public double Coordinate(String coordinateName) {
        double n;
        while (true) {
            System.out.print("Введите координату " + coordinateName + ": ");
            if (scanner.hasNextDouble()) {
                n = scanner.nextDouble();
                scanner.nextLine();
                return n;
            } else {
                System.out.println("Ошибка! Пожалуйста введите число: ");
                scanner.nextLine();
            }
        }
    }















    /**
     * Получить ответ да/нет
     * @param message сообщение для пользователя
     * @return true если да, false если нет
     */
    public boolean getYesNo(String message) {
        while (true) {
            System.out.print(message + " (да/нет): ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("да") || answer.equals("д")) {
                return true;
            } else if (answer.equals("нет") || answer.equals("н")) {
                return false;
            } else {
                System.out.println("Ошибка! Введите 'да' или 'нет'.");
            }
        }
    }


//    /**
//     * Проверяет, что строка содержит только буквы (включая английские)
//     * @param input строка для проверки
//     * @return true если строка содержит только буквы или пустая, иначе false
//     */
//    public boolean checkLetters(String input) {
//        if (input == null) {
//            System.out.println("Ошибка! Текст не может быть пустым");
//        }
//
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
//                    (c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я') ||
//                    c == 'ё' || c == 'Ё' || c == ' ' || c == '-')) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /**
//     * Проверяет, что число является положительным.
//     *
//     * @param num число для проверки
//     * @return положительное число
//     */
//    public static int getCheckNum(int num) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (num < 1) {
//            System.out.print("Введите положительное число: ");
//            num = scanner.nextInt();
//        }
//        return num;
//    }
//
//
//
//
//    /**
//     * Проверяет, что строка содержит только цифры
//     * @param input строка для проверки
//     * @return true если строка содержит только цифры, иначе false
//     */
//    public boolean checkNum(String input) {
//        if (input == null || input.isEmpty()) {
//            return false;
//        }
//
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            if (!(c >= '0' && c <= '9')) {
//                return false;
//            }
//        }
//        return true;
//    }

//    /**
//     * Метод для ввода чисел и проверки цифр
//     * @param val сообщение для пользователя
//     * @return проверенное число
//     */
//    public int getNumInput(String val) {
//        while (true) {
//            System.out.print(val);
//            String input = scanner.nextLine().trim();
//            if (checkNum(input)) {
//                return Integer.parseInt(input);
//            } else {
//                System.out.println("Ошибка: введите только цифры!");
//            }
//        }
//    }
//
//
//    /**
//     * Универсальный метод для ввода букв с сообщением.
//
//     * @param prompt сообщение для пользователя
//     * @param allowEmpty разрешить пустые значения
//     * @return проверенная строка
//     */
//    public String getLettersInput(String prompt, boolean allowEmpty) {
//        while (true) {
//            System.out.print(prompt);
//            String input = scanner.nextLine().trim();
//            if ((allowEmpty && input.isEmpty()) || checkLetters(input)) {
//                return input;
//            } else {
//                System.out.println("Ошибка: должно содержать только буквы!");
//            }
//        }
//    }




    public static boolean CheckStr(String var0) {
        int var1 = 0;

        for(int var2 = 0; var2 < var0.length(); ++var2) {
            if (Character.isDigit(var0.charAt(var2))) {
                ++var1;
            }
        }

        return var1 == 0;
    }

    public static String CheckString(String var0) {
        boolean var1 = CheckStr(var0);

        while(!var1) {
            System.out.print("Ошибка ввода! Повторите ещё раз: ");
            Scanner var2 = new Scanner(System.in);
            var0 = var2.next();
            var1 = CheckStr(var0);
            var2.nextLine();
        }

        return var0;
    }
}
