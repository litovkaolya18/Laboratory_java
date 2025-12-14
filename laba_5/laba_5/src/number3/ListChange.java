package number3;
import java.util.ArrayList;
import java.util.List;


public class ListChange {
    /**
     * Меняет первое вхождение одного списка в другом
     */
    public static <T> List<T> change(List<T> list, List<T> find, List<T> replace) {
        // Если что-то пустое - ничего не делаем
        if (list == null || find == null || replace == null) return new ArrayList<>(list);
        if (find.isEmpty()) return new ArrayList<>(list);
        if (list.size() < find.size()) return new ArrayList<>(list);

        // Ищем find в list
        for (int i = 0; i <= list.size() - find.size(); i++) {
            boolean found = true;

            // Проверяем все элементы
            for (int j = 0; j < find.size(); j++) {
                if (!list.get(i + j).equals(find.get(j))) {
                    found = false;
                    break;
                }
            }

            // Если нашли - меняем
            if (found) {
                List<T> result = new ArrayList<>();

                // Добавляем часть до
                result.addAll(list.subList(0, i));
                // Добавляем новый список
                result.addAll(replace);
                // Добавляем часть после
                result.addAll(list.subList(i + find.size(), list.size()));

                return result;
            }
        }

        // Если не нашли - возвращаем копию
        return new ArrayList<>(list);
    }


    /**
     * Проверяет есть ли один список в другом
     */
    public static <T> boolean contains(List<T> big, List<T> small) {
        if (big == null || small == null || small.isEmpty()) return false;
        if (big.size() < small.size()) return false;

        for (int i = 0; i <= big.size() - small.size(); i++) {
            boolean found = true;
            for (int j = 0; j < small.size(); j++) {
                if (!big.get(i + j).equals(small.get(j))) {
                    found = false;
                    break;
                }
            }
            if (found) return true;
        }
        return false;
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
