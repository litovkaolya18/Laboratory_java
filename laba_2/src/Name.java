import java.util.Scanner;
/**
 * Класс Name представляет сущность 'Имя' с фамилией, именем и отчеством
 *
 * Не заданные параметры не учитываются при приведении к текстовому виду
 */
public class Name {
    Scanner scanner = new Scanner(System.in);
    /**
     * Свойства
     */
    private String lastName;
    private String firstName;
    private String patronymic;

    /**
     * Конструктор для ввода данных с клавиатуры
     */
    public Name() {
        System.out.print("Введите фамилию: ");
        this.lastName = scanner.nextLine();

        System.out.print("Введите имя: ");
        this.firstName = scanner.nextLine();

        System.out.print("Введите отчество: ");
        this.patronymic = scanner.nextLine();
    }
    /**
     * Конструктор для готовых имен
     *
     * @param lastName фамилия
     * @param firstName имя
     * @param patronymic отчество
     */
    public Name(String lastName, String firstName, String patronymic) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getPatronymic() {
        return patronymic;
    }

    //метод
    @Override
    public String toString() {
        String res = "";

        if (lastName != null && lastName.length() > 0) {
            res = lastName;
        }

        if (firstName != null && firstName.length() > 0) {
            if (res.length() > 0) {
                res = res + " " + firstName;
            } else {
                res = firstName;
            }
        }

        if (patronymic != null && patronymic.length() > 0) {
            if (res.length() > 0) {
                res= res + " " + patronymic;
            } else {
                res = patronymic;
            }
        }
        return res;
    }
}
