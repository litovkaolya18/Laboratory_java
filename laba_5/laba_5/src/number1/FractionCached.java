package number1;

/**
 * Класс с кешированием
 */
public class FractionCached implements FractionInterface {
    private final Fraction fraction;
    private Double cached; //Кешированное вещественное значение

    public FractionCached(Fraction fraction) {
        this.fraction = fraction;
    }

    @Override
    public double getRealValue() {
        if (cached == null) {
            cached = fraction.getRealValue();
        }
        return cached;
    }

    // Установка числителя с сбросом кэша
    @Override
    public void setNumerator(int numerator) {
        fraction.setNumerator(numerator);
        cached = null; // сброс кэша
    }

    // Установка знаменателя с сбросом кэша
    @Override
    public void setDenominator(int denominator) {
        fraction.setDenominator(denominator);
        cached = null; // сброс кэша
    }

    // Установка дроби с сбросом кэша
    public void setFraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    @Override
    public String toString() {
        return fraction.toString();
    }
}
