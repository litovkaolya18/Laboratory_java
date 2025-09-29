import java.util.Scanner;

public class Check {
    /**
     * Проверяет, что число является положительным.
     *
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
}
