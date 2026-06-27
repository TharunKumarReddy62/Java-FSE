package Ex07_FinancialForecasting;

public class FinancialForecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double currentValue,
                                              double growthRate,
                                              int years) {

        // Base Case
        if (years == 0) {
            return currentValue;
        }

        // Recursive Case
        return calculateFutureValue(currentValue, growthRate, years - 1)
                * (1 + growthRate);
    }
}
