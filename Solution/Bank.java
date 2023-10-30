package Solution;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    public enum Currency {
        CZK, USD, EUR
    };

    public static Map<Currency, Map<Currency, Double>> exchangeRates = new HashMap<>();

    static {

        Map<Currency, Double> czkRates = new HashMap<>();
        czkRates.put(Currency.CZK, 1.0);
        czkRates.put(Currency.EUR, 1 / 26.0);
        czkRates.put(Currency.USD, 1 / 24.0);

        Map<Currency, Double> eurRates = new HashMap<>();
        eurRates.put(Currency.CZK, 26.0);
        eurRates.put(Currency.EUR, 1.0);
        eurRates.put(Currency.USD, 1.0833);

        Map<Currency, Double> usdRates = new HashMap<>();
        usdRates.put(Currency.CZK, 24.0);
        usdRates.put(Currency.EUR, 0.9231);
        usdRates.put(Currency.USD, 1.0);

        exchangeRates.put(Currency.CZK, czkRates);
        exchangeRates.put(Currency.EUR, eurRates);
        exchangeRates.put(Currency.USD, usdRates);
    }

    public static Map<Currency, Map<Currency, Double>> getExchangeRates() {
        return exchangeRates;
    }

    public static Map<Currency, Double> getRateOf(Currency currency) {
        return exchangeRates.get(currency);
    }
}