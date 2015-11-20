package com.rg.entity;

import com.rg.entity.Money;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Expense
 *
 */
@Entity
public class Expense extends Money implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expenseId;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Type type;

	public Expense() {
		super();
	}

	public int getExpenseId() {
		return this.expenseId;
	}

	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
