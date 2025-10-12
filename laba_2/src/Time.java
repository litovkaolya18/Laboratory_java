import java.util.Scanner;

/**
 * Класс Time представляет сущность 'Время' в 24-часовом формате.
 * Время описывается числом секунд, прошедшим с начала суток.
 */
public class Time {

    /**
     * Свойства: количество секунд с начала суток.
     */
    private int seconds;

    /**
     * Конструктор для ввода данных с клавиатуры.
     */
    public Time() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество секунд: ");
        this.seconds = scanner.nextInt();
    }

    /**
     * Конструктор для создания времени из секунд.
     *
     * @param seconds количество секунд с начала суток
     */
    public Time(int seconds) {
        this.seconds = seconds;
    }

    /**
     * Конструктор для создания времени из часов, минут и секунд.
     *
     * @param hours часы
     * @param minutes минуты
     * @param seconds секунды
     */
    public Time(int hours, int minutes, int seconds) {
        this.seconds = hours * 3600 + minutes * 60 + seconds;
    }

    public int getSeconds() {
        return seconds;
    }


    /**
     * Возвращает текущий час (0-23)
     */
    public int getHours() {
        int totalSeconds = seconds % (24 * 3600);
        return totalSeconds / 3600;
    }

    /**
     * Возвращает минуты с начала текущего часа (0-59)
     */
    public int getMinutes() {
        int totalSeconds = seconds % (24 * 3600);
        int remainingSeconds = totalSeconds % 3600;
        return remainingSeconds / 60;
    }

    /**
     * Возвращает секунды с начала текущей минуты (0-59)
     */
    public int getSecondsFromMinute() {
        int totalSeconds = seconds % (24 * 3600);
        return totalSeconds % 60;
    }

    /**
     * Преобразует время в текстовую форму формата "ЧЧ:ММ:СС".
     * Если время превышает 24 часа, отображается время с начала последних суток.
     *
     * @return строковое представление времени
     */
    @Override
    public String toString() {
        int hours = getHours();
        int minutes = getMinutes();
        int seconds = getSecondsFromMinute();

       String res = hours + ":";

       if (minutes < 10) {
           res = res + "0" + minutes + ":";
       } else {
           res = res + minutes + ":";
       }

       if (seconds < 10) {
           res = res + "0" + seconds;
       } else {
           res = res + seconds;
       }
        return res;
    }
}
