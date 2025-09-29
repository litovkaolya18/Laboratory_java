import java.util.Scanner;

/**
 * Класс для сотрудников
 */
public class Employees {
    Scanner scanner = new Scanner(System.in);
    private String name; //отдел
    private Department department; // начальник

    public Employees(String name, Department department) {
        this.name = name;
        this.department = department;
        //
        department.addEmployee(this);
    }

    // Конструктор для ввода с клавиатуры
    public Employees(Department department) {
        this.name = scanner.nextLine();
        this.department = department;
        //
        department.addEmployee(this);
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    //
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
