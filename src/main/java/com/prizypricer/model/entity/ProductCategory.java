/**
 * 
 */
package com.prizypricer.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Himanshu
 *
 */
@Entity
@Table(name = "product_cat")
public class ProductCategory extends BaseEntity{

	private static final long serialVersionUID = 6492531809190568128L;

	@Column(name = "category", nullable = false, length = 55)
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
