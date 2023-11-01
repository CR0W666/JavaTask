import Solution.*;
import Solution.Bank.Currency;
import static Solution.Bank.getRateOf;

import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigDecimal;

public class MoneyTest {

    @Test
    public void testConvertToSameCurrency() {
        Money money = new Money(BigDecimal.valueOf(100), Currency.USD);
        Money convertedMoney = money.convertToCurrency(Currency.USD);
        assertEquals(money.getAmount(), convertedMoney.getAmount());
        assertEquals(money.getCurrency(), convertedMoney.getCurrency());
    }

    @Test
    public void testConvertToDifferentCurrency() {
        Money money = new Money(BigDecimal.valueOf(100), Currency.USD);
        Money convertedMoney = money.convertToCurrency(Currency.EUR);
        // Mock conversion rate from USD to EUR for testing
        BigDecimal conversionRate = getRateOf(Currency.USD).get(Currency.EUR); // For example
        BigDecimal expectedAmount = money.getAmount().multiply(conversionRate);
        assertEquals(expectedAmount, convertedMoney.getAmount());
        assertEquals(Currency.EUR, convertedMoney.getCurrency());
    }

    @Test
    public void testCompareAmountSameCurrency() {
        Money money1 = new Money(BigDecimal.valueOf(100), Currency.USD);
        Money money2 = new Money(BigDecimal.valueOf(150), Currency.USD);
        int result = money1.compareAmount(money2);
        assertTrue(result < 0);
    }

    @Test
    public void testCompareAmountDifferentCurrency() {
        Money money1 = new Money(BigDecimal.valueOf(100), Currency.USD);
        Money money2 = money1.convertToCurrency(Currency.EUR); // Assuming 1 USD = 0.8 EUR
        int result = money1.compareAmount(money2);
        assertTrue(result == 0);
    }
}
