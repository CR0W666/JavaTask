package Solution;

import Solution.Bank.Currency;

public class Money {

    private double amount;
    // private Map<Currency, Double> exchangeRates;
    public Currency currency;

    public Money(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
        // this.exchangeRates = exchangeRates;
    }

    // Getter and Setter methods for amount and currency
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    // public void setExchangeRate(Currency currency, double rate) {
    // exchangeRates.put(currency, rate);
    // }

    // public double getRate(Currency currency) {
    // return exchangeRates.get(currency);
    // }

    // public Map<Currency, Double> getRates() {
    // return exchangeRates;
    // }

    // Method to convert the amount to a different currency
    public double convertToCurrency(Currency targetCurrency) {
        if (currency.equals(targetCurrency)) {
            return amount; // Same currency, no conversion needed
        }

        double sourceToTargetRate = Bank.getRateOf(currency).get(targetCurrency);
        return amount * sourceToTargetRate;
    }

    public int compareAmount(Money other) {
        if (this.currency.equals(other.currency)) {
            return Double.compare(this.amount, other.amount);
        } else {
            return Double.compare(this.amount, other.convertToCurrency(this.currency));
        }
    }

}