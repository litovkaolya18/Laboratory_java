/**
 * Функциональный интерфейс для сокращения (свёртки) значений
 */
@FunctionalInterface
public interface Reduction<T> {
    /**
     * Свести два значения к одному
     */
    T reduce(T accumulator, T current);
}