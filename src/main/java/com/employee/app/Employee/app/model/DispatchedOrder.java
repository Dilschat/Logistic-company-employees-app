package com.employee.app.Employee.app.model;

import java.math.BigDecimal;
import java.time.Duration;

public class DispatchedOrder extends Order {
    private Duration durationOfDelivering;
    private BigDecimal profitValue;
    private String profitCurrency;
    private String clientFeedback;
    private String controlOperatorFeedback;

    public DispatchedOrder(){}

    public DispatchedOrder(Duration durationOfDelivering, BigDecimal profitValue, String profitCurrency, String clientFeedback) {
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

    public String getProfitCurrency() {
        return profitCurrency;
    }

    public void setProfitCurrency(String profitCurrency) {
        this.profitCurrency = profitCurrency;
    }

    public String getClientFeedback() {
        return clientFeedback;
    }

    public void setClientFeedback(String clientFeedback) {
        this.clientFeedback = clientFeedback;
    }

    public String getControlOperatorFeedback() {
        return controlOperatorFeedback;
    }

    public void setControlOperatorFeedback(String controlOperatorFeedback) {
        this.controlOperatorFeedback = controlOperatorFeedback;
    }
}
