/**
 * Обобщённая коробка для хранения 1-го объекта
 * @param <T> тип хранимого объекта
 */
public class Box<T> {
    private T filling; //наполнение коробки

    /**
     * Конструктор пустой коробки
     */
    public Box() {
        this.filling = null;
    }

    /**
     * Положить объект в коробку
     * @param object объект для хранения
     */
    public void putObject(T object) {
        if (filling != null) {
            throw new IllegalStateException("Коробка уже занята, в ней есть объект");
        }
        filling = object;
    }

    /**
     * Взять объект из коробки
     * @return хранимый объект
     */
    public T takeFilling(){
        if (filling == null) {
            throw new IllegalStateException("Коробка пуста");
        }
        T object = filling;
        filling = null; //очищаем коробку (обновляем ссылку)
        return object;
    }

    /**
     * Полна ли коробка
     */
    public boolean full() {
        return filling != null;
    }


    /**
     * Метод для задания "Начало отсчета"
     * Кладет в коробку трехмерную точку с произвольными значениями
     * Работает с коробкой любого типа, который может хранить Point
     */
    public static void putPoint(Box<? super Point> box) {
        // Создаем точку с произвольными значениями
        Point point = new Point(Math.random()*10, Math.random()*10, Math.random()*10);
        box.putObject(point);

        System.out.print("Точка в коробке: " + point.toString() + "\n");
    }

    @Override
    public String toString() {
        if (filling == null) {
            return "Коробка - пустая";
        } else {
            return "Коробка - " + filling.toString();
        }
    }

}
