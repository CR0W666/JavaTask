package Solution;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    public enum Currency {
        CZK, USD, EUR
    };

    public static Map<Currency, Map<Currency, BigDecimal>> exchangeRates = new HashMap<>();

    static {
        final BigDecimal ONE = BigDecimal.ONE;

        Map<Currency, BigDecimal> czkRates = new HashMap<>();
        czkRates.put(Currency.CZK, ONE);
        System.out.println(1 / 26);
        czkRates.put(Currency.EUR, BigDecimal.valueOf(0.0384));
        czkRates.put(Currency.USD, BigDecimal.valueOf(0.0416));

        Map<Currency, BigDecimal> eurRates = new HashMap<>();
        eurRates.put(Currency.CZK, BigDecimal.valueOf(26));
        eurRates.put(Currency.EUR, ONE);
        eurRates.put(Currency.USD, BigDecimal.valueOf(1.0833));

        Map<Currency, BigDecimal> usdRates = new HashMap<>();
        usdRates.put(Currency.CZK, BigDecimal.valueOf(24));
        usdRates.put(Currency.EUR, BigDecimal.valueOf(0.9231));
        usdRates.put(Currency.USD, ONE);

        exchangeRates.put(Currency.CZK, czkRates);
        exchangeRates.put(Currency.EUR, eurRates);
        exchangeRates.put(Currency.USD, usdRates);
    }

    public static Map<Currency, Map<Currency, BigDecimal>> getExchangeRates() {
        return exchangeRates;
    }

    public static Map<Currency, BigDecimal> getRateOf(Currency currency) {
        return exchangeRates.get(currency);
    }
}