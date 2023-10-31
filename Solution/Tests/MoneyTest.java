package Solution.Tests;

import Solution.Bank.Currency;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void testConvertToSameCurrency() {
        Money money = new Money(100, Currency.USD);
        double convertedAmount = money.convertToCurrency(Currency.USD);
        assertEquals(100, convertedAmount, 0.001);
    }

    @Test
    public void testConvertToDifferentCurrency() {
        Money money = new Money(100, Currency.USD);
        double convertedAmount = money.convertToCurrency(Currency.EUR);
        // Mock conversion rate from USD to EUR for testing
        double expectedAmount = 100 * Bank.getRateOf(Currency.USD).get(Currency.EUR);
        assertEquals(expectedAmount, convertedAmount, 0.001);
    }

    @Test
    public void testCompareAmountSameCurrency() {
        Money money1 = new Money(100, Currency.USD);
        Money money2 = new Money(150, Currency.USD);
        int result = money1.compareAmount(money2);
        assertEquals(-1, result);
    }

    @Test
    public void testCompareAmountDifferentCurrency() {
        Money money1 = new Money(100, Currency.USD);
        Money money2 = new Money(26, Currency.EUR); // Assuming 1 USD = 0.26 EUR
        int result = money1.compareAmount(money2);
        assertEquals(0, result);
    }
}
