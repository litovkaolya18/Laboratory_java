import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GasStation {

    // Метод для чтения файла (как в вашем Text классе)
    private String[][] readFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            int N = scanner.nextInt();
            scanner.nextLine();
            String[][] data = new String[N][];

            for (int i = 0; i < N; i++) {
                String line = scanner.nextLine();
                data[i] = line.split(" ");
            }

            scanner.close();
            return data;

        } catch (FileNotFoundException e) {
            System.out.println("Файл " + filename + " не найден!");
            return null;
        }
    }

    // Основной метод анализа
    public void analyze() {
        System.out.println("Анализ данных АЗС: ");

        String[][] data = readFile("AZS.txt");
        if (data == null) {
            return;
        }

        int min92 = 10000, count92 = 0;
        int min95 = 10000, count95 = 0;
        int min98 = 10000, count98 = 0;

        for (int i = 0; i < data.length; i++) {
            String mark = data[i][2];
            int price = Integer.parseInt(data[i][3]);

            // Проверка диапазона цен (опционально)
            if (price < 1000 || price > 3000) {
                System.out.println("Предупреждение: цена вне диапазона: " + price);
                continue;
            }

            if (mark.equals("92")) {
                if (price < min92) {
                    min92 = price;
                    count92 = 1;
                } else if (price == min92) {
                    count92++;
                }
            }
            else if (mark.equals("95")) {
                if (price < min95) {
                    min95 = price;
                    count95 = 1;
                } else if (price == min95) {
                    count95++;
                }
            }
            else if (mark.equals("98")) {
                if (price < min98) {
                    min98 = price;
                    count98 = 1;
                } else if (price == min98) {
                    count98++;
                }
            }
        }

        if (min92 == 10000) count92 = 0;
        if (min95 == 10000) count95 = 0;
        if (min98 == 10000) count98 = 0;

        System.out.println("\nКоличество АЗС с минимальной ценой:");
        System.out.println(count92 + " " + count95 + " " + count98);
    }

    @Override
    public String toString() {
        return "GasStation{filename='AZS.txt'}";
    }
}