package com.rg.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Income
 *
 */
@Entity
public class Income extends Money implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int incomeId;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Type type;

	public Income() {
		super();
	}

	@Override
	public String toString() {
		return "Income [incomeId=" + incomeId + ", type=" + type + ", getAmount()=" + getAmount() + ", getCurrency()=" + getCurrency()
				+ ", getExchangeRate()=" + getExchangeRate() + "]";
	}

	public int getIncomeId() {
		return this.incomeId;
	}

	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
