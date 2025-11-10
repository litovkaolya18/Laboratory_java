/**
 * Функциональный интерфейс для фильтрации значений
 */
@FunctionalInterface
public interface Filter<T> {
    /**
     * Проверить значение по условию
     */
    boolean test(T value);
}
