/**
 * Класс для отделов
 */
public class Department {
    private String name;
    private Employees  director;
    //
    private Employees[] employees;
    private int count;

    public Department(String name) {
        this.name = name;
        //
        this.employees = new Employees[100];
        this.count = 0;
    }

    public  String getName() {
        return  name;
    }

    public Employees getDirector() {
        return director;
    }

    //
    public  void setDirector(Employees director) {
        this.director = director;
    }
    //
    public void addEmployee(Employees employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
        }
    }
    //
    public String getAllEmployeesList() {
        if (count == 0) {
            return "В отделе нет сотрудников";
        }

        String res = "Сотрудники отдела " + name + ":\n";
        for (int i = 0; i < count; i++) {
            Employees emp = employees[i];
            if (emp == director) {
                res += emp.getName() + " (начальник)\n";
            } else {
                res += emp.getName() + "\n";
            }
        }
        return res;
    }
    //
    public int getEmployeeCount() {
        return count;
    }
}
