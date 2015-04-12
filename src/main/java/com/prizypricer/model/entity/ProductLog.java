package com.prizypricer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Himanshu
 *
 */
@Entity
@Table(name = "product_log")
public class ProductLog extends BaseEntity{

	private static final long serialVersionUID = -7845706671357095658L;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "price", nullable = false, length = 55)
	private double price;
}
