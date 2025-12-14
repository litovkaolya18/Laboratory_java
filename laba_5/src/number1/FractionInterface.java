package number1;

/**
 * Интерфейс для работы с дробью
 */
public interface FractionInterface {
    //получение вещественного значения
    double  getRealValue();

    // установка числителя
    void setNumerator(int numerator);

    // установка знаменателя
    void setDenominator(int denominator);
}
