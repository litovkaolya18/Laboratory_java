import java.io.*;
import java.util.*;

public class Text {

    public void analyze() {
        try {
            // 1. Читаем файл
            File file = new File("text.txt");
            Scanner scanner = new Scanner(file);

            // 2. Собираем весь текст в одну строку
            String text = "";
            while (scanner.hasNextLine()) {
                text += scanner.nextLine().toLowerCase() + " ";
            }
            scanner.close();

            // 3. Все глухие согласные
            String consonants = "пфктшсхцчщ";

            // 4. Какие согласные есть в тексте
            Set<Character> found = new HashSet<>();
            for (char c : text.toCharArray()) {
                if (consonants.indexOf(c) != -1) {
                    found.add(c);
                }
            }

            // 5. Каких согласных нет
            List<Character> result = new ArrayList<>();
            for (char c : consonants.toCharArray()) {
                if (!found.contains(c)) {
                    result.add(c);
                }
            }

            // 6. Сортируем и выводим
            Collections.sort(result);

            System.out.print("Результат: ");
            for (char c : result) {
                System.out.print(c + " ");
            }
            System.out.print("\n");

        } catch (FileNotFoundException e) {
            System.out.println("Файл text.txt не найден!");
        }
    }
}
