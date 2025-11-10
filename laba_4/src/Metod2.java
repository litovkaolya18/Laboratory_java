import java.util.ArrayList;
import java.util.List;

/**
 * Класс для фильтрации списков
 */
public class Metod2 {
    /**
     * Метод для фильтрации списка с помощью условия
     */
    public static <T> List<T> filter(List<T> inputList, Filter<T> filter) {
        if(inputList == null || inputList.isEmpty()) {
            return new ArrayList<>();
        }

        List<T> result = new ArrayList<>();
        for (T element : inputList) {
            if (filter.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
