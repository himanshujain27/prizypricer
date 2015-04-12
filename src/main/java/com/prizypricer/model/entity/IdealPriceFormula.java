
package com.prizypricer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Himanshu
 *
 */

@Entity
@Table(name = "ideal_price_formula")
public class IdealPriceFormula extends BaseEntity{

	
	private static final long serialVersionUID = -871693093795319740L;

	@Column(name = "rhighest", nullable = false, length = 55)
	private int rhighest;
	
	@Column(name = "rlowest", nullable = false, length = 55)
	private int rlowest;
	
	@Column(name = "addition", nullable = false, length = 55)
	private int addition;
	
	
	public int getRhighest() {
		return rhighest;
	}

	public void setRhighest(int rhighest) {
		this.rhighest = rhighest;
	}

	public int getRlowest() {
		return rlowest;
	}

	public void setRlowest(int rlowest) {
		this.rlowest = rlowest;
	}

	public int getAddition() {
		return addition;
	}

	public void setAddition(int addition) {
		this.addition = addition;
	}

}
