import java.util.ArrayList;
import java.util.List;

/**
 * Класс для операций сокращения над списками
 */
public class Metod3 {
    /**
     * Метод для сокращения списка к одному значению
     */
    public static <T> T reduce(List<T> inputList, T initialVal, Reduction<T> reducer) {
        if (inputList == null || inputList.isEmpty()) {
            return initialVal; // Гарантированно не возвращает null
        }

        T result = initialVal;
        for (T element : inputList) {
            result = reducer.reduce(result, element);
        }
        return result;
    }
}
