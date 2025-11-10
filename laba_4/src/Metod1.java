import java.util.ArrayList;
import java.util.List;

/**
 * Класс для обработки списков
 */
public class Metod1 {
    /**
     * Метод для преобразования списка с помощью функции
     */
    public static <T, P> List<P> process(List<T> inputList, Function<T,P> function) {
        if (inputList == null ||  inputList.isEmpty()) {
            return new ArrayList<>();
        }

        List<P> result = new ArrayList<>();
        for (T element : inputList) {
            result.add(function.apply(element));
        }
        return result;
    }
}
