package Tests;

import Solution.Bank;
import Solution.Bank.Currency;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BankTest {

    @Test
    public void testGetExchangeRates() {
        Map<Currency, Map<Currency, BigDecimal>> exchangeRates = Bank.getExchangeRates();
        assertNotNull(exchangeRates);
        assertEquals(3, exchangeRates.size()); // Ensure there are rates for all three currencies
    }

    @Test
    public void testGetRateOf() {
        Map<Currency, BigDecimal> czkRates = Bank.getRateOf(Currency.CZK);
        Map<Currency, BigDecimal> eurRates = Bank.getRateOf(Currency.EUR);
        Map<Currency, BigDecimal> usdRates = Bank.getRateOf(Currency.USD);

        assertNotNull(czkRates);
        assertNotNull(eurRates);
        assertNotNull(usdRates);

        assertEquals(BigDecimal.ONE, czkRates.get(Currency.CZK));
        assertEquals(BigDecimal.valueOf(0.0384), czkRates.get(Currency.EUR));
        assertEquals(BigDecimal.valueOf(0.0416), czkRates.get(Currency.USD));

        assertEquals(BigDecimal.valueOf(26), eurRates.get(Currency.CZK));
        assertEquals(BigDecimal.ONE, eurRates.get(Currency.EUR));
        assertEquals(BigDecimal.valueOf(1.0833), eurRates.get(Currency.USD));

        assertEquals(BigDecimal.valueOf(24), usdRates.get(Currency.CZK));
        assertEquals(BigDecimal.valueOf(0.9231), usdRates.get(Currency.EUR));
        assertEquals(BigDecimal.ONE, usdRates.get(Currency.USD));
    }
}
