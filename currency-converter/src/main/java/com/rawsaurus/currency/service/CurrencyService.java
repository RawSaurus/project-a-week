package com.rawsaurus.currency.service;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;

public class CurrencyService {


    public String convertValue(String currencyFrom, String currencyTo, String value){

        MonetaryAmount currency1 = Monetary.getDefaultAmountFactory().setCurrency(currencyFrom).setNumber(Integer.valueOf(value)).create();
        CurrencyConversion conversion = MonetaryConversions.getConversion(currencyTo);

        MonetaryAmount returnValue = currency1.with(conversion);


        return returnValue.toString().substring(4);
    }

}
