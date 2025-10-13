import java.util.Scanner;

/**
 * Класс Employee представляет сущность сотрудника.
 * Сотрудник описывается именем и отделом, в котором работает
 */
public class Employees {
    /*  Имя сотрудника */
    private final String name;
    /* Отдел, в котором работает */
    private final Department department;

    /**
     * Конструктор для создания сотрудника с готовыми данными
     *
     * @param name имя сотрудника
     * @param department отдел сотрудника
     */
    public Employees(String name, Department department) {
        this.name = name;
        this.department = department;
        // автоматически добавляем сотрудника в отдел
        department.addEmployee(this);
    }

    /**
     * Конструктор для ввода имени сотрудника с клавиатуры.
     *
     * @param department отдел сотрудника
     */
    public Employees(Department department) {
        Scanner scanner = new Scanner(System.in);
        Check validator = new Check();

        while (true) {
            System.out.print("Введите имя сотрудника: ");
            String inputName = scanner.nextLine().trim();
            if (inputName.isEmpty() || validator.checkLetters(inputName)) {
                this.name = inputName;
                break;
            } else {
                System.out.println("Error: имя должно содержать только буквы!");
            }
        }
        this.department = department;
        //
        department.addEmployee(this);
    }

    public String getName() {
        return name;
    }

    /**
     * Возвращает список всех сотрудников отдела.
     */
    public String getDepartmentEmployees() {
        return department.getAllEmployeesList();
    }

    /**
     * Преобразует сотрудника к текстовой форме.
     */
    @Override
    public String toString() {
        if (department.getDirector() == this) {
            return name + " начальник отдела " + department.getName();
        } else {
            return name + " работает в отделе " + department.getName() +
                    ", начальник которого " + department.getDirector().getName();
        }
    }
}
