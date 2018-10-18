package com.employee.app.Employee.app.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Currency;

public class DispatchedOrder extends Order {
    private Duration durationOfDelivering;
    private BigDecimal profitValue;
    private Currency profitCurrency;
    private String clientFeedback;

    public DispatchedOrder(){};

    public DispatchedOrder(Duration durationOfDelivering, BigDecimal profitValue, Currency profitCurrency, String clientFeedback) {
        super();
        this.durationOfDelivering = durationOfDelivering;
        this.profitValue = profitValue;
        this.profitCurrency = profitCurrency;
        this.clientFeedback = clientFeedback;
    }

    public Duration getDurationOfDelivering() {
        return durationOfDelivering;
    }

    public void setDurationOfDelivering(Duration durationOfDelivering) {
        this.durationOfDelivering = durationOfDelivering;
    }

    public BigDecimal getProfitValue() {
        return profitValue;
    }

    public void setProfitValue(BigDecimal profitValue) {
        this.profitValue = profitValue;
    }

    public Currency getProfitCurrency() {
        return profitCurrency;
    }

    public void setProfitCurrency(Currency profitCurrency) {
        this.profitCurrency = profitCurrency;
    }

    public String getClientFeedback() {
        return clientFeedback;
    }

    public void setClientFeedback(String clientFeedback) {
        this.clientFeedback = clientFeedback;
    }
}
