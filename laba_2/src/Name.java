import java.util.Scanner;
/**
 * Класс Name представляет сущность 'Имя' с фамилией, именем и отчеством
 * Не заданные параметры не учитываются при приведении к текстовому виду
 */
public class Name {
    /**
     * Свойства
     */
    private String lastName;
    private String firstName;
    private String patronymic;

    /**
     * Конструктор по умолчанию
     * для ввода данных с клавиатуры
     */
    public Name() {
        Scanner scanner = new Scanner(System.in);
        Check validator = new Check(scanner);

        while (true) {
            System.out.print("Введите фамилию: ");
            this.lastName = scanner.nextLine().trim();
            if (this.lastName.isEmpty() || validator.checkLetters(this.lastName)) {
                break;
            } else {
                System.out.println("Error: фамилия должна содержать только буквы");
            }
        }

        while (true) {
            System.out.print("Введите имя: ");
            this.firstName = scanner.nextLine().trim();
            if (this.firstName.isEmpty() || validator.checkLetters(this.firstName)) {
                break;
            } else {
                System.out.println("Error: имя должна содержать только буквы");
            }
        }

        while (true) {
            System.out.print("Введите отчество: ");
            this.patronymic = scanner.nextLine().trim();
            if (this.patronymic.isEmpty() || validator.checkLetters(this.patronymic)) {
                break;
            } else {
                System.out.println("Error: отчество должна содержать только буквы");
            }
        }
    }
    /**
     * Конструктор с параметрами
     * для готовых имен
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

    /**
     * Преобразует имя к строковому виду.
     * @return строка в формате 'Фамилия Имя Отчество'
     */
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
