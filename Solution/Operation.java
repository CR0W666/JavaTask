package Solution;

public class Operation {

    public static Money add(Money a, Money b) {
        if (!a.currency.equals(b.getCurrency())) {

            double convertedAmount = a.getAmount() + b.convertToCurrency(a.getCurrency());
            return new Money(a.getAmount() + convertedAmount, a.getCurrency());
        } else {
            return new Money(a.getAmount() + b.getAmount(), a.getCurrency());
        }
    }

    public static Money subtract(Money a, Money b) {
        if (!a.getCurrency().equals(b.getCurrency())) {

            double convertedAmount = a.getAmount() - b.convertToCurrency(a.getCurrency());
            return new Money(a.getAmount() - convertedAmount, a.getCurrency());
        } else {
            return new Money(a.getAmount() - b.getAmount(), a.getCurrency());
        }
    }

    public static Money multiply(Money a, double multiplier) {
        return new Money(a.getAmount() * multiplier, a.getCurrency());
    }

    public Money divide(Money a, double divisor) {

        if (divisor != 0) {
            return new Money(a.getAmount() / divisor, a.getCurrency());
        } else {
            throw new ArithmeticException("Error: Division by zero");
        }
    }

    public static Money round(Money a, double precision) {
        double roundedAmount = Math.round(a.getAmount() * precision) / precision;
        return new Money(roundedAmount, a.getCurrency());
    }
}
