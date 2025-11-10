/**
 * Функциональный интерфейс для преобразования значений
 */
@FunctionalInterface
public interface Function<T, P> {
    /**
     * Применить функцию к значению
     */
    P apply(T value);
}
