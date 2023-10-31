package Solution;

import java.math.BigDecimal;

import Solution.Bank.Currency;

public class Main {
    public static void main(String args[]) {

        Money czk = new Money(BigDecimal.valueOf(2000), Currency.CZK);
        Money eur = new Money(BigDecimal.valueOf(100), Currency.EUR);
        Money usd = new Money(BigDecimal.valueOf(50), Currency.USD);

        Wallet wallet = new Wallet();
        wallet.addAll(new Money[] { czk, eur, usd });

        Money totalInCZK = wallet.getTotalInCurrency(Currency.CZK);
        Money totalInEUR = wallet.getTotalInCurrency(Currency.EUR);
        Money totalInUSD = wallet.getTotalInCurrency(Currency.USD);
        System.out.println("total in CZK: " + totalInCZK.getAmount());
        System.out.println("total in EUR: " + totalInEUR.getAmount());
        System.out.println("total in USD: " + totalInUSD.getAmount());
    }
}
