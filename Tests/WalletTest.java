package Tests;

import Solution.Bank.Currency;
import Solution.Money;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class WalletTest {

    private Wallet wallet;

    @Before
    public void setUp() {
        wallet = new Wallet();
    }

    @Test
    public void testAddAll() {
        Money[] moneyArray = {
                new Money(BigDecimal.valueOf(100), Currency.USD),
                new Money(BigDecimal.valueOf(50), Currency.EUR)
        };
        wallet.addAll(moneyArray);
        assertEquals(BigDecimal.valueOf(100), wallet.getTotalInCurrency(Currency.USD).getAmount());
        assertEquals(BigDecimal.valueOf(50), wallet.getTotalInCurrency(Currency.EUR).getAmount());
    }

    @Test
    public void testAddCurrency() {
        wallet.addCurrency(Currency.USD, BigDecimal.valueOf(200));
        assertEquals(BigDecimal.valueOf(200), wallet.getTotalInCurrency(Currency.USD).getAmount());
    }

    @Test
    public void testSpendCurrency() {
        wallet.addCurrency(Currency.USD, BigDecimal.valueOf(200));
        wallet.spendCurrency(Currency.USD, BigDecimal.valueOf(150));
        assertEquals(BigDecimal.valueOf(50), wallet.getTotalInCurrency(Currency.USD).getAmount());
    }

    @Test
    public void testSpendMoney() {
        wallet.addCurrency(Currency.USD, BigDecimal.valueOf(200));
        wallet.spendMoney(new Money(BigDecimal.valueOf(150), Currency.USD));
        assertEquals(BigDecimal.valueOf(50), wallet.getTotalInCurrency(Currency.USD).getAmount());
    }

    @Test
    public void testGetTotalInCurrency() {
        wallet.addCurrency(Currency.USD, BigDecimal.valueOf(100));
        wallet.addCurrency(Currency.EUR, BigDecimal.valueOf(50));
        Money totalUSD = wallet.getTotalInCurrency(Currency.USD);
        Money totalEUR = wallet.getTotalInCurrency(Currency.EUR);

        assertEquals(BigDecimal.valueOf(100), totalUSD.getAmount());
        assertEquals(BigDecimal.valueOf(50), totalEUR.getAmount());
    }
}
