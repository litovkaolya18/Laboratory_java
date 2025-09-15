import java.util.Scanner;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        int number;
        while (true) {
            System.out.print("\n " + "\nЗдравствуй! Выбери одно из заданий:\n");
            System.out.print("1 - Метод для получения дробной части числа\n" +
                    "2 - Метод преобразование символа в число по коду ASCII\n" +
                    "3 - Метод возвращения 'true' если число двухзначное\n" +
                    "4 - Метод возвращения 'true' если num в диапазоне между a и b\n" +
                    "5 - Метод возвращения 'true' если три числа равны\n" +
                    "6 - Метод возвращения модуля числа \n" +
                    "7 - Метод возвращения 'true' если число делится или на 3 или 5\n" +
                    "8 - Метод возвращает наибольшее число из трёх предложенных\n" +
                    "9 - Метод возвращает сумму чисел x и y\n" +
                    "10 - Метод возвращающий строку, обозначающая день недели, где 1 - это понедельник и так далее..\n" +
                    "11 - Метод возвращает строку, где записанны все числа от 0 до x\n" +
                    "12 - Метод возвращает строку, где записанны четные числа от 0 до x\n" +
                    "13 - Метод возвращает количество знаков в числе x\n" +
                    "14 - Метод выводит квадрат из символов '*' размера x на x\n" +
                    "15 - Метод выводит треугольник из символов '*' с высотой x, и совпадает с номером строки\n" +
                    "в ряду, выровненный по правому краю\n" +
                    "16 - Метод возвращающий индекс первого вхождения числа x в массив arr\n");
            System.out.print("Введите номер задания: ");
            Scanner scanner = new Scanner(System.in);
            Metod metod = new Metod();
            number = scanner.nextInt();

            switch (number) {
                case 1: {
                    double x = metod.foolTest();
                    double fractional_part = metod.fraction(x);
                    System.out.printf("Дробная часть числа: %f%n", fractional_part);
                    break;
                }
                case 2: {
                    char x;
                    System.out.print("Введите символ x от 0 до 9: ");
                    x = scanner.next().charAt(0);
                    int Num = metod.charToNum(x);
                    System.out.print("Символ " + x + " преобразован в число: " + Num + " по таблице ASCII");
                    break;
                }
                case 3: {
                    int x;
                    System.out.print("Введите любое число x: ");
                    x = scanner.nextInt();
                    boolean is2Digit = metod.is2Digits(x);
                    System.out.print(is2Digit);
                    break;
                }
                case 4: {
                    int a, b, num;
                    System.out.print("Введите число для 'а' для диапазона: ");
                    a = scanner.nextInt();
                    System.out.print("Введите число для 'b' для диапазона: ");
                    b = scanner.nextInt();
                    System.out.print("Введите число для 'num': ");
                    num = scanner.nextInt();
                    boolean ranges = metod.isInRange(a, b, num);
                    System.out.print(ranges);
                    break;
                }
                case 5: {
                    int a, b, c;
                    System.out.print("Введите числa 'а b c' (с пробелом и без запятых): ");
                    a = scanner.nextInt();
                    b = scanner.nextInt();
                    c = scanner.nextInt();
                    boolean equality = metod.isEqual(a, b, c);
                    System.out.print(equality);
                    break;
                }
                case 6: {
                    int x;
                    System.out.print("Введите число x: ");
                    x = scanner.nextInt();
                    int module = metod.abs(x);
                    System.out.print(module);
                    break;
                }
                case 7:{
                    int x;
                    System.out.print("Введите число x: ");
                    x = scanner.nextInt();
                    boolean num35 = metod.is35(x);
                    System.out.print(num35);
                    break;
                }
                case 8: {
                    int x, y, z;
                    System.out.print("Введите числa 'x y z' (с пробелом и без запятых): ");
                    x = scanner.nextInt();
                    y = scanner.nextInt();
                    z = scanner.nextInt();
                    int maximum = metod.max3(x, y, z);
                    System.out.print(maximum + "\n");
                    break;
                }
                case 9: {
                    int x, y;
                    System.out.print("Введите число x: ");
                    x = scanner.nextInt();
                    System.out.print("Введите число y: ");
                    y = scanner.nextInt();
                    int resultSum = metod.sum2(x,y);
                    System.out.print("Если сумма чисел в диапазоне от 10 до 19 включительно, то ответ = 20\n");
                    System.out.print("Сумма ваших числе равна = " + resultSum);
                    break;
                }
                case 10: {
                    int x;
                    System.out.print("Введите число от 1 до 7 чтоб узнать день недели: ");
                    x = scanner.nextInt();
                    String week = metod.day(x);
                    System.out.print(week);
                    break;
                }
                case 11: {
                    int x;
                    System.out.print("Введите число x: ");
                    x = scanner.nextInt();
                    String res = metod.listNums(x);
                    System.out.print("Числа от 0 до "+ x + " : " + res);
                    break;
                }
                case 12: {
                    int x;
                    System.out.print("Введите число x: ");
                    x = scanner.nextInt();
                    String chNum = metod.chet(x);
                    System.out.print("Чётные числа от о до " + x + " : " + chNum);
                    break;
                }
                case 13: {
                    int x;
                    System.out.print("Введите число x: ");
                    x = scanner.nextInt();
                    int count = metod.numLen(x);
                    System.out.print("Количество знаков в числе " + x + " : " + count);
                    break;
                }
                case 14: {
                    int x;
                    System.out.print("Введите число x: ");
                    x = scanner.nextInt();
                    System.out.println("Квадрат размером " + x + " на " + x + ":");
                    metod.square(x);
                    break;
                }
                case 15: {
                    int x;
                    System.out.print("Введите число x: ");
                    x = scanner.nextInt();
                    metod.rightTriangle(x);
                    break;
                }
                case 16:{
                    int x, n;
                    System.out.print("Введите размер массива: ");
                    n = scanner.nextInt();
                    int[] arr = new int[n];
                    System.out.println("Введите " + n + " элементов массива через пробел: ");

                    for (int i = 0; i < n; i++) {
                        arr[i] = scanner.nextInt();
                    }

                    System.out.println("Введите число x для поиска: ");
                    x = scanner.nextInt();
                    int array = metod.findFirst(arr, x);

                    if (array != -1) {
                        System.out.print("Первое вхождение числа " + x + " найдено на позиции: " + array + " (отсчёт с нуля)\n");
                    } else {
                        System.out.print("Число " + x + " не найдено в массиве\n");
                    }
                    break;
                }
            }
        }
    }
}
