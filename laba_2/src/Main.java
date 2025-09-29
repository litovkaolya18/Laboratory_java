import java.util.Scanner;
import java.lang.*;
import java.text.DecimalFormat;
/**
 * Главный класс Main - лабораторная номер 2
 */
public class Main {
    public static void main(String[] args) {
        int number;

        while (true) {
            System.out.print("\n" + "Здравствуй! Выбери одно из заданий:\n");
            System.out.print("1 - Создание ФИО\n" +
                    "2 - Создание Времени\n" +
                    "3 - Создание Сотрудников и их отделов\n");
            System.out.print("Введите номер задания: ");
            Scanner scanner = new Scanner(System.in);
            number = scanner.nextInt();

            switch (number) {
                case 1: {
                    System.out.println("\nПримеры из условия задачи");
                    Name num1 = new Name(null, "Клеопатра", null);
                    Name num2 = new Name("Пушкин", "Александр", "Сергеевич");
                    Name num3 = new Name("Маяковский", "Владимир", null);

                    System.out.println("1. " + num1.toString());
                    System.out.println("2. " + num2.toString());
                    System.out.println("3. " + num3.toString() + "\n");

                    int count;
                    System.out.print("Введите число сколько ФИО вы хотите создать: ");
                    count = scanner.nextInt();
                    count = Check.getCheckNum(count);

                    String allNames = "";
                    for (int i = 0 ; i < count; i++) {
                        System.out.print("Создание " + (i+1) + " ФИО\n");
                        Name name = new Name();
                        allNames += (i+1) + ". " + name.toString() + "\n";
                    }
                    System.out.print("Создано: \n");
                    System.out.print(allNames);
                    break;
                }
                case 2: {
                    System.out.println("\nПримеры из условия задачи");
                    Time time1 = new Time(10);
                    Time time2 = new Time(10000);
                    Time time3 = new Time(100000);
                    Time time4 = new Time(91800);

                    System.out.println("10 секунд: " + time1.toString());
                    System.out.println("10000 секунд: " + time2.toString());
                    System.out.println("100000 секунд: " + time3.toString());
                    System.out.println("91800 секунд: " + time4.toString());


                    Time time5 = new Time(2,3,5);
                    System.out.print("2 часа, 3 минуты, 5 секунд: " + time5.toString());

                    System.out.println("\nСпособы создания времени:");
                    System.out.println("1 - из секунд");
                    System.out.println("2 - из часов, минут, секунд");
                    System.out.print("Выберете цифру: ");
                    int choice = scanner.nextInt();

                    if (choice == 1) {
                        int user;
                        System.out.print("Введите количество секунд: ");
                        user = scanner.nextInt();
                        user = Check.getCheckNum(user);
                        Time userTime = new Time(user);
                        System.out.print(userTime.toString() + "\n");
                    } else if (choice == 2) {
                        System.out.print("Введите часы: ");
                        int hours = scanner.nextInt();
                        System.out.print("Введите минуты: ");
                        int minutes = scanner.nextInt();
                        System.out.print("Введите секунды: ");
                        int seconds = scanner.nextInt();

                        Time userTime = new Time(hours, minutes, seconds);
                        System.out.println(userTime.toString());
                    } else {
                        System.out.println("Неверный выбор!");
                    }
                    break;

                }
                case 3: {
                    System.out.println("\nПримеры из условия задачи");
                    Department department = new Department("IT");

                    Employees employees1 = new Employees("Петров", department);
                    Employees employees2 = new Employees("Козлов", department);
                    Employees employees3 = new Employees("Сидоров", department);

                    department.setDirector(employees2);

                    System.out.print(employees1.toString() + "\n");
                    System.out.print(employees2.toString() + "\n");
                    System.out.print(employees3.toString() + "\n");

                    System.out.print("\nИмея ссылку на сотрудника, можем узнать список всех сотрудников " +
                            "отдела\n");
                    System.out.print(employees1.getDepartmentEmployees());


                    scanner.nextLine(); // очистка буфера
                    String departmentName;
                    System.out.print("Введите название отдела: ");
                    departmentName = scanner.nextLine();
                    Department userDep = new Department(departmentName);

                    int count;
                    System.out.print("\nСколько сотрудников вы хотите создать: ");
                    count = scanner.nextInt();
                    count = Check.getCheckNum(count);
                    scanner.nextLine();

                    //создание сотрудников
                    Employees[] userEmp = new Employees[count];
                    for (int i = 0; i < count; i++) {
                        System.out.print("Сотрудник " + (i + 1) + ": ");
                        userEmp[i] = new Employees(userDep);
                    }

                    //создание начальника
                    System.out.print("Введите номер начальника от 1 до " + count + ": ");
                    int indexDep = scanner.nextInt();
                    while (indexDep < 1 || indexDep > count) {
                        System.out.print("Неверно. Введите номер от 1 до " + count + ": ");
                        indexDep = scanner.nextInt();
                    }

                    userDep.setDirector(userEmp[indexDep - 1]);

                    System.out.println("\nПолный список сотрудников: ");
                    for (int i = 0; i < count; i++) {
                        System.out.println(userEmp[i].toString());
                    }

                    //
                    System.out.print("Введите номер сотрудника, чтобы узнать список его отдела: ");
                    int viewIndex = scanner.nextInt();
                    while (viewIndex < 1 || viewIndex > count) {
                        System.out.print("Неверно. Введите номер от 1 до " + count + ": ");
                        viewIndex = scanner.nextInt();
                    }

                    System.out.println("\nСписок сотрудников отдела через " + userEmp[viewIndex - 1].getName() + ":");
                    System.out.println(userEmp[viewIndex - 1].getDepartmentEmployees());
                    break;
                }
                default:
                    System.out.print("Такого номера в списке нет\n");
                    break;
            }
        }
    }
}