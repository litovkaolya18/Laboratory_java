package number2;

/**
 * Класс Кот
 */
public class Cat implements Meowable {
    private String nameCat;

    /**
     * Конструктор кота с именем
     */
    public Cat(String nameCat) {
        this.nameCat = nameCat;
    }

    /**
     * Получить имя кота
     */
    public String getName() {
        return nameCat;
    }



    /**
     * Метод мяуканья (реализация интерфейса)
     */
    @Override
    public void meow() {
        System.out.println(nameCat + ": мяу!");
    }

    /**
     * Текстовое представление кота
     */
    @Override
    public String toString() {
        return "кот: " + nameCat;
    }
}
