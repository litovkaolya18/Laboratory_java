/**
 * Хранилище - неизменяемый контейнер для одного объекта
 * Может хранить null, но возвращает альтернативное значение
 */
public class Storage<T> {
    private final T value; // неизменяемое поле
    private final T alternative; // альтернативное значение

    /**
     * Конструктор - объект кладется при создании
     * @param value хранимое значение (может быть null)
     * @param alternative альтернативное значение при null
     */
    public Storage(T value, T alternative) {
        this.value = value;
        this.alternative = alternative;
    }

    /**
     * Вернуть значение (если null - вернуть альтернативу)
     */
    public T getValue() {
        if (value == null) {
            return alternative;
        }
        return value;
    }

    /**
     * Получить оригинальное значение (даже если null)
     */
    public T getOriginalValue() {
        return value;
    }

    /**
     * Проверить, хранится ли null
     */
    public boolean isNull() {
        return value == null;
    }

    /**
     * Получить альтернативное значение
     */
    public T getAlternative() {
        return alternative;
    }

    @Override
    public String toString() {
        if (value == null) {
            return "Хранилище{null -> альтернатива: " + alternative + "}";
        } else {
            return "Хранилище{значение: " + value + "}";
        }
    }
}