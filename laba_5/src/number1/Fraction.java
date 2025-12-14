package number1;

public class Fraction implements FractionInterface {
    private int numerator;     // Числитель
    private int denominator;    // Знаменатель

    /**
     * Конструктор для проверки входных данных
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть = 0");
        }

        //Обработка отрицательных значений
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Конструктор по умолчания
     */
    public Fraction() {
        this(0,1);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }


    // Получение вещественного значения (реализация интерфейса)
    @Override
    public double getRealValue() {
        return (double) numerator / denominator;
    }

    // Установка числителя (реализация интерфейса)
    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    // Установка знаменателя (реализация интерфейса)
    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0.");
        }

        // Обработка отрицательных значений
        if (denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -denominator;
        } else {
            this.denominator = denominator;
        }
    }

    // Установка числителя и знаменателя
    public void setFraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }


    // Строковое представление
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Fraction)) return false;
        Fraction other = (Fraction) obj;

        return this.numerator == other.numerator && this.denominator == other.denominator;
    }
}

