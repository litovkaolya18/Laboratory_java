package number2;

/**
 * Класс, который принимает мяукающих объектов и вызывает мяуканье у каждого
 */
public class MeowCounter {
    public static int allMeow(Meowable m, int n) {
        System.out.println("Начинаем мяуканье " + n + " раз...");
        for (int i = 0; i < n; i++) {
            m.meow();
        }
        return n;
    }

    /**
     * Для массива котов
     */
    public static int allMeow(Meowable[] meowables, int n) {
        System.out.println("Начинаем мяуканье для " + meowables.length + " котов...");
        int total = 0;

        for (Meowable m : meowables) {
            for (int i = 0; i < n; i++) {
                m.meow();
                total++;
            }
        }

        return total; // Возвращаем общее количество мяуканий
    }
}

