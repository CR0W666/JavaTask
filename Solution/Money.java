package Solution;

import Solution.Bank.Currency;
import java.math.BigDecimal;

public class Money {

    private BigDecimal amount;
    public Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // Getter and Setter methods for amount and currency
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    // Method to convert the amount to a different currency
    public Money convertToCurrency(Currency targetCurrency) {
        if (currency.equals(targetCurrency)) {
            return this; // Same currency, no conversion needed
        }

        BigDecimal sourceToTargetRate = Bank.getRateOf(currency).get(targetCurrency);
        return new Money(amount.multiply(sourceToTargetRate), targetCurrency);
    }

    public int compareAmount(Money other) {
        if (this.currency.equals(other.currency)) {
            return this.amount.compareTo(other.amount);
        } else {
            BigDecimal convertedAmount = this.convertToCurrency(other.currency).getAmount();
            return convertedAmount.compareTo(other.amount);
        }
    }
}