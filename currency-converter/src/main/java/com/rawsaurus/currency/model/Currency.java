package com.rawsaurus.currency.model;

public class Currency {

    private String currencyType;
    private Double value;

    Currency(){

    }

    Currency(String type, Double value){
        this.currencyType=type;
        this.value=value;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
