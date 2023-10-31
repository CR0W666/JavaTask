package Solution;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Operation {

    public static Money add(Money a, Money b) {
        if (!a.currency.equals(b.getCurrency())) {

            BigDecimal convertedAmount = b.convertToCurrency(a.getCurrency()).getAmount();
            return new Money(a.getAmount().add(convertedAmount), a.getCurrency());
        } else {
            return new Money(a.getAmount().add(b.getAmount()), a.getCurrency());
        }
    }

    public static Money subtract(Money a, Money b) {
        if (!a.getCurrency().equals(b.getCurrency())) {

            BigDecimal convertedAmount = b.convertToCurrency(a.getCurrency()).getAmount();
            return new Money(a.getAmount().subtract(convertedAmount), a.getCurrency());
        } else {
            return new Money(a.getAmount().subtract(b.getAmount()), a.getCurrency());
        }
    }

    public static Money multiply(Money a, BigDecimal multiplier) {
        return new Money(a.getAmount().multiply(multiplier), a.getCurrency());
    }

    public static Money divide(Money a, BigDecimal divisor) {

        if (divisor.compareTo(BigDecimal.ZERO) > 0) {
            return new Money(a.getAmount().divide(divisor, 0, RoundingMode.UNNECESSARY), a.getCurrency());
        } else {
            throw new ArithmeticException("Error: Division by zero");
        }
    }

    public static Money round(Money a) {
        return new Money(a.getAmount().round(MathContext.DECIMAL64), a.getCurrency());
    }
}
