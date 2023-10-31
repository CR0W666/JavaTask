package Solution;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import Solution.Bank.Currency;

public class Wallet {
    private Map<Currency, Money> moneyMap;

    public Wallet() {
        moneyMap = new HashMap<>();
    }

    public void addAll(Money[] money) {
        for (Money e : money) {
            addMoney(e);
        }
    }

    public void addCurrency(Currency currency, BigDecimal amount) {
        addMoney(new Money(amount, currency));
    }

    public void addMoney(Money newMoney) {
        Currency moneyCurrency = newMoney.getCurrency();

        if (moneyMap.containsKey(moneyCurrency)) {
            // If the currency already exists, add the new amount to the existing currency
            Money existingMoney = moneyMap.get(moneyCurrency);
            moneyMap.replace(moneyCurrency, Operation.add(existingMoney, newMoney));
        } else {
            // If the currency doesn't exist, add a new entry
            moneyMap.put(moneyCurrency, newMoney);
        }
    }

    public void spendCurrency(Currency currency, BigDecimal amount) {
        spendMoney(new Money(amount, currency));
    }

    public void spendMoney(Money newMoney) {
        Currency moneyCurrency = newMoney.getCurrency();

        if (moneyMap.containsKey(moneyCurrency)) {

            Money existingMoney = moneyMap.get(moneyCurrency);
            Money newValue = Operation.subtract(existingMoney, newMoney);

            if (newValue.getAmount().compareTo(BigDecimal.ZERO) > 0) {
                moneyMap.replace(moneyCurrency, newValue);
            } else {
                System.out.println("Insufficient funds in " + moneyCurrency);
            }
        } else {
            System.out.println("No funds available in " + moneyCurrency);
        }
    }

    public Money getTotalInCurrency(Currency currency) {
        Money total = new Money(BigDecimal.valueOf(0), currency);
        for (Money money : moneyMap.values()) {
            total = Operation.add(total, money.convertToCurrency(currency));
        }
        return total;
    }

}
