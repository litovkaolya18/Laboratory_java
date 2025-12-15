package number6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Класс для очереди с проверкой на равные соседние элементы по кругу
 */
public class QueueCircular {
    private Queue<Integer> queue;

    /**
     *  Конструктор по умолчанию
     */
    public QueueCircular() {
        this.queue = new LinkedList<>();
    }


    // Метод, который сразу выводит результат
    public void checkAndPrint() {
        if (queue.size() < 2) {
            System.out.println("Ошибка: нужно минимум 2 элемента!");
            return;
        }

        Integer[] arr = queue.toArray(new Integer[0]);
        boolean found = false;

        // Проверяем обычные соседи
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].equals(arr[i + 1])) {
                System.out.println("Элемент " + arr[i] +
                        " на позиции " + i +
                        " равен элементу на позиции " + (i + 1));
                found = true;
            }
        }

        // Проверяем круг (последний с первым)
        if (arr[arr.length - 1].equals(arr[0])) {
            System.out.println("Последний элемент " + arr[arr.length - 1] +
                    " равен первому элементу " + arr[0]);
            found = true;
        }

        if (!found) {
            System.out.println("ВЫВОД: В очереди НЕТ элемента, равного следующему");
        }
    }


    // Добавить элемент
    public void add(int value) {
        queue.add(value);
    }


    public int size() {
        return queue.size();
    }


    @Override
    public String toString() {
        if (queue.isEmpty()) {
            return "Очередь пуста";
        }
        return "Очередь: " + queue.toString();
    }
}
