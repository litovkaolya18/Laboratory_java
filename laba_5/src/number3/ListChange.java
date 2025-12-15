package number3;
import java.util.ArrayList;
import java.util.List;


public class ListChange {
    /**
     * Меняет первое вхождение одного списка в другом
     */
    public static <T> List<T> change(List<T> L, List<T> L1, List<T> L2) {
        // Если что-то пустое - ничего не делаем
        if (L1.isEmpty() || L.size() < L1.size())
            return new ArrayList<>(L);

        // Ищем L1 в L
        for (int i = 0; i <= L.size() - L1.size(); i++) {
            boolean found = true;

            // Проверяем все элементы
            for (int j = 0; j < L1.size(); j++) {
                if (!L.get(i + j).equals(L1.get(j))) {
                    found = false;
                    break;
                }
            }

            // Если нашли - меняем
            if (found) {
                List<T> result = new ArrayList<>();

                // Добавляем часть до
                result.addAll(L.subList(0, i));
                // Добавляем новый список
                result.addAll(L2);
                // Добавляем часть после
                result.addAll(L.subList(i + L1.size(), L.size()));

                return result;
            }
        }

        // Если не нашли - возвращаем копию
        return new ArrayList<>(L);
    }


    /**
     * Печатает список красиво
     */
    public static <T> String print(List<T> list) {
        if (list == null) return "null";
        if (list.isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
