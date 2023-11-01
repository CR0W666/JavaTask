import Solution.Bank.Currency;
import Solution.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class OperationTest {

    @Test
    public void testAddDifferentCurrencies() {
        Money money1 = new Money(new BigDecimal("100"), Currency.USD);
        Money money2 = new Money(new BigDecimal("85"), Currency.EUR);
        Money result = Operation.add(money1, money2);

        assertEquals(new BigDecimal("192.5"), result.getAmount());
        assertEquals(Currency.USD, result.getCurrency());
    }

    @Test
    public void testAddSameCurrencies() {
        Money money1 = new Money(new BigDecimal("100"), Currency.USD);
        Money money2 = new Money(new BigDecimal("150"), Currency.USD);
        Money result = Operation.add(money1, money2);

        assertEquals(new BigDecimal("250"), result.getAmount());
        assertEquals(Currency.USD, result.getCurrency());
    }

    @Test
    public void testAddSameCurrenciesEdge() {
        Money money1 = new Money(new BigDecimal("0.1"), Currency.USD);
        Money money2 = new Money(new BigDecimal("0.2"), Currency.USD);
        Money result = Operation.add(money1, money2);

        assertEquals(new BigDecimal("0.3"), result.getAmount());
        assertEquals(Currency.USD, result.getCurrency());
    }

    @Test
    public void testSubtractDifferentCurrencies() {
        Money money1 = new Money(new BigDecimal("100"), Currency.USD);
        Money money2USD = new Money(new BigDecimal("50"), Currency.USD);
        Money money2 = money2USD.convertToCurrency(Currency.EUR);
        Money result = Operation.subtract(money1, money2);

        assertEquals(new BigDecimal("50"), result.getAmount());
        assertEquals(Currency.USD, result.getCurrency());
    }

    @Test
    public void testSubtractSameCurrencies() {
        Money money1 = new Money(new BigDecimal("150"), Currency.USD);
        Money money2 = new Money(new BigDecimal("100"), Currency.USD);
        Money result = Operation.subtract(money1, money2);

        assertEquals(new BigDecimal("50"), result.getAmount());
        assertEquals(Currency.USD, result.getCurrency());
    }

    @Test
    public void testMultiply() {
        Money money = new Money(new BigDecimal("100"), Currency.USD);
        BigDecimal multiplier = new BigDecimal("2");
        Money result = Operation.multiply(money, multiplier);

        assertEquals(new BigDecimal("200"), result.getAmount());
        assertEquals(Currency.USD, result.getCurrency());
    }

    @Test
    public void testDivide() {
        Money money = new Money(new BigDecimal("100"), Currency.USD);
        BigDecimal divisor = new BigDecimal("5");
        Money result = Operation.divide(money, divisor);

        assertEquals(new BigDecimal("20"), result.getAmount());
        assertEquals(Currency.USD, result.getCurrency());
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        Money money = new Money(new BigDecimal("100"), Currency.USD);
        BigDecimal divisor = BigDecimal.ZERO;
        Operation.divide(money, divisor);
    }

    @Test
    public void testRound() {
        Money money = new Money(new BigDecimal("100.245"), Currency.USD);
        Money result = Operation.round(money);

        assertEquals(new BigDecimal("100"), result.getAmount());
        assertEquals(Currency.USD, result.getCurrency());
    }
}
