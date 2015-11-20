package com.rg.entity;

import java.io.Serializable;
import java.util.Currency;
import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Money implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double amount;
	private Currency currency;
	private Double exchangeRate;
	private Date createdOn = new Date();

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = Currency.getInstance(currency);
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
