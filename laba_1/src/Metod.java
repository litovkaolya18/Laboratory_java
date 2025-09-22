import java.util.Scanner;
public class Metod {
    /**
     * Метод для получения дробной части.
     *
     * @param x вещественное число
     * @return дробная часть числа
     */
    public double fraction(double x) { //номер 1.1
        double fractional_part = x - (int)x;
        return fractional_part;
    }

    /**
     * Метод перевода символа цифры в число по таблице ASCII.
     *
     * @param x символ цифры
     * @return числовое значение символа
     */
    public int charToNum(char x) { //номер 1.3
        if ((x >= '0') & (x <= '9')) {
            return x - '0'; //преобразует символ в число
        } else {
            System.out.print("Error: x не входит в диапазон от 0 до 9");
            return -1;
        }
    }

    /**
     * Метод определения двухзначного числа.
     *
     * @param x проверяемое число
     * @return true если число двухзначное, иначе false
     */
    public boolean is2Digits(int x) { //номер 1.5
        System.out.print("Число является двухзначным?\n");
        boolean twoDidits;
        if (((x >= 10) & (x <= 99)) || ((x <= -10) & (x >= -99))) {
           twoDidits = true;
        }
        else{
           twoDidits = false;
        }
        return twoDidits;
    }

    /**
     * Метод определения вхождения числа num в диапазон между a и b.
     *
     * @param a начало диапазона
     * @param b конец диапазона
     * @param num проверяемое число
     * @return true если число входит в диапазон, иначе false
     */
    public boolean isInRange(int a, int b, int num) { //номер 1.7
        boolean ranges;
        int range1, range2;

        if (a < b) {
            range1 = a;
            range2 = b;
        } else {
            range1 = b;
            range2 = a;
        }

        if ((num >= range1) & (num <= range2)){
            System.out.print("Данное число num входит в диапазон\n");
            ranges = true;
        } else if ((num == range1) & (num == range2)) {
            System.out.print("Данное число num входит в диапазон, но являются его началом и концом, так как числа а и b совпадают\n");
            ranges = true;
        } else {
            System.out.print("Данное число num не входит в диапазон\n");
            ranges = false;
        }
        return ranges;
    }

    /**
     * Метод возвращения 'true' если три числа равны.
     *
     * @param a первое число
     * @param b второе число
     * @param c третье число
     * @return true если все числа равны, иначе false
     */
    public boolean isEqual(int a, int b, int c) { //номер 1.9
        boolean equality;
        if ((a == b) & (b == c)) {
            System.out.print("Все числа равны\n");
            equality = true;
        } else {
            System.out.print("Числа не равны\n");
            equality = false;
        }
        return equality;
    }

    /**
     * Метод возвращения модуля числа x.
     *
     * @param x число
     * @return модуль числа
     */
    public int abs(int x) { //номер 2.1
        int module;
        if (x >= 0) {
            module = x;
        } else {
            module = -x;
        }
        System.out.print("Модуль числа x: ");
        return module;
    }

    /**
     * Метод возвращения 'true' если число делится или на 3, или 5.
     *
     * @param x проверяемое число
     * @return true если число делится на 3 или 5 (но не на оба одновременно), иначе false
     */
    public boolean is35(int x) { //номер 2.3
        boolean num35;
        if ((x % 3 == 0) & (x % 5 == 0)) {
            num35 = false;
            System.out.print("Число делится и на 3 и на 5\n");
        } else if (x % 3 == 0 | x % 5 == 0) {
            num35 = true;
            System.out.print("Число делится или на 3 или на 5\n");
        } else {
            num35 = false;
            System.out.print("Число не делится ни на 3 и ни на 5\n");
        }
        return num35;
    }

    /**
     * Метод возвращает наибольшее число из трех.
     *
     * @param x первое число
     * @param y второе число
     * @param z третье число
     * @return наибольшее число
     */
    public int max3(int x, int y, int z) { //номер 2.5
        int maximum = x;
        if (y > maximum) {
            maximum = y;
        }
        if (z > maximum){
            maximum = z;
        }
        return  maximum;
    }

    /**
     * Метод возвращает сумму чисел с особым условием.
     *
     * @param x первое число
     * @param y второе число
     * @return сумму чисел или 20, если сумма в диапазоне [10, 19]
     */
    public int sum2(int x, int y) { //номер 2.7
        int sum = x + y;
        if ((sum >= 10) & (sum <=19)) {
             sum = 20;
        } else {
            sum = x + y;
        }
        return sum;
    }

    /**
     * Метод возвращает строку, обозначающую день недели.
     *
     * @param x номер дня (1-7)
     * @return название дня недели или сообщение об ошибке
     */
    public String day(int x) { //номер 2.9
        switch (x) {
            case 1 :
                return "Понедельник";
            case 2 :
                return "Вторник";
            case 3 :
                return "Среда";
            case 4 :
                return "Четверг";
            case 5 :
                return "Пятница";
            case 6 :
                return "Суббота";
            case 7 :
                return "Воскресенье";
            default:
                return "Не правильно: 'это не день недели'";
        }
    }

    /**
     * Метод возвращает строку с числами от 0 до x.
     *
     * @param x верхняя граница
     * @return строка с числами через пробел
     */
    public String listNums (int x) { //номер 3.1
        String res = "";
        if (x > 0) {
            for (int i = 0; i <= x; i++) {
                res += i + " ";
            }
        } else {
            for (int i = 0; i >= x; i--) {
                res += i + " ";
            }
        }
        return res;
    }

    /**
     * Метод возвращает строку с четными числами от 0 до x.
     *
     * @param x верхняя граница
     * @return строка с четными числами через пробел
     */
    public String chet (int x) { //номер 3.3
        String chNum = "";
        if (x > 0) {
            for (int i = 0; i <= x; i += 2) {
                chNum += i + " ";
            }
        } else {
            for (int i = 0; i >= x; i -= 2) {
                 chNum += i + " ";
             }
        }
        return chNum;
    }

    /**
     * Метод возвращает количество знаков в числе.
     *
     * @param x целое число
     * @return количество знаков в числе
     */
    public int numLen(long x) { //номер 3.5
        int count = 1;
        while (x / 10 != 0) {
            x /= 10;
            count++;
        }
        return count;
    }

    /**
     * Метод выводит на экран квадрат из символов '*' размером x на x.
     *
     * @param x размер квадрата (количество символов в ряду и высоте)
     */
    public void square(int x) { //номер 3.7
        if (x <= 0) {
            System.out.println("Размер должен быть положительным числом");
            return;
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Метод выводит на экран треугольник из символов '*' с высотой x, выровненный по правому краю.
     *
     * @param x высота треугольника
     */
    public void rightTriangle(int x) { //номер 3.9
        if (x <= 0) {
            System.out.println("Размер должен быть положительным числом");
            return;
        }

        for (int i = 1; i <= x; i++) { //для строк
            for (int j = 0; j < x - i; j++) { //x-i для доп пробелов
                System.out.print(" ");
            }
            for (int t = 0; t < i; t++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * Метод возвращающий индекс первого вхождения числа x в массив arr.
     * Если число не входит в массив - возвращается -1.
     *
     * @param arr массив, в котором осуществляется поиск
     * @param x число, которое нужно найти в массиве
     * @return индекс первого вхождения числа x или -1, если число не найдено
     */
    public int findFirst(int[] arr, int x) { //номер 4.1
        System.out.print("Полученный массив: [");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print( arr[i] + " ");
        }
        System.out.print("]\n");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) { //ищем заданный элемент
                return i;
            }
        }
        return -1;

    }

    /**
     * Метод возвращает наибольшее по модулю (то есть без учета знака) значение массива arr
     *
     * @param arr массив, в котором осуществляется поиск
     * @return наибольшее по модулю значение из массива
     */
    public int maxAbs (int[] arr) { //номер 4.3
        int maxAbsValue = arr[0];

        System.out.print("Полученный массив: [");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print( arr[i] + " ");
            int current = arr[i];

            int currentAbs;
            if (current < 0) {
                currentAbs = -current;
            } else {
                currentAbs = current;
            }
            // Вычисляем модуль текущего максимального
            int maxAbs;
            if (maxAbsValue < 0) {
                maxAbs = -maxAbsValue;
            } else {
                maxAbs = maxAbsValue;
            }

            // Сравниваем модули
            if (currentAbs > maxAbs) {
                maxAbsValue = current;
            } else if (currentAbs == maxAbs) {
                // При равных модулях выбираем отрицательное значение
                if (current < 0) {
                    maxAbsValue = current;
                }
            }
        }
        System.out.print("]\n");

        return maxAbsValue;
    }

    /**
     * Добавление массива в массив
     *
     *
     */
    public int[] add (int[] arr, int[] ins, int pos) { //номер 4.5
        System.out.print("Полученный массив Arr: [");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]\n");

        System.out.print("Полученный массив Ins: [");
        for (int i = 0; i < ins.length; i++)
        {
            System.out.print(ins[i] + " ");
        }
        System.out.print("]\n");

        int[] res = new int[arr.length + ins.length];
        System.out.println("Соединения массивов с позиции pos " + pos);

        //копируем элемент до позиции вставки
        for (int i = 0; i < pos; i++){
            res[i] = arr[i];
        }

        //вставляем элемент из ins
        for (int i = 0; i < ins.length; i++) {
            res[pos + i] = ins[i];
        }

        //копируем оставшееся из arr
        for (int i = pos; i < arr.length; i++) {
            res[ins.length + i] = arr[i];
        }
        return res;
    }
}
