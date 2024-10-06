package com.rawsaurus;


import junit.framework.Assert;
import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.UnknownCurrencyException;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

import java.io.IOException;

import static junit.framework.Assert.*;

public class TestTest {

    @Test
    public void givenCurrencyCode_whenString_thanExist(){
        CurrencyUnit usd = Monetary.getCurrency("USD");

        assertNotNull(usd);
        assertEquals(usd.getCurrencyCode(), "USD");
        assertEquals(usd.getNumericCode(), 840);
        assertEquals(usd.getDefaultFractionDigits(), 2);
    }

    @Test
    public void givenCurrencyCode_whenNoExist_thanShouldThrowError(){

        Assertions.assertThrows(UnknownCurrencyException.class, () -> Monetary.getCurrency("AAA"));
    }

    @Test
    public void givenAmounts_whenStringified_thenEquals(){

        CurrencyUnit usd = Monetary.getCurrency("USD");
        MonetaryAmount fstAmtUSD = Monetary.getDefaultAmountFactory().setCurrency(usd).setNumber(200).create();
        Money moneyOf = Money.of(20, usd);
        FastMoney fastMoney = FastMoney.of(2.00000, usd);

        assertEquals("USD", usd.getCurrencyCode());
        assertEquals("USD 200", fstAmtUSD.toString());
        assertEquals("USD 20", moneyOf.toString());
        assertEquals("USD 2", fastMoney.toString());
    }

    @Test
    public void givenAmount_whenConversion_thenNotNull(){

        MonetaryAmount oneDollar = Monetary.getDefaultAmountFactory().setCurrency("USD")
                .setNumber(1).create();

        CurrencyConversion conversionEUR = MonetaryConversions.getConversion("EUR");

        MonetaryAmount convertedAmountUSDtoEUR = oneDollar.with(conversionEUR);

        assertEquals("USD 1", oneDollar.toString());
        assertEquals("1", oneDollar.toString().substring(4));
        assertNotNull(convertedAmountUSDtoEUR);
    }

}
