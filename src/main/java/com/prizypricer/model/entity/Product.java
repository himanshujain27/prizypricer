
package com.prizypricer.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Himanshu
 *
 */

@Entity
@Table(name = "product")
public class Product extends BaseEntity{

	private static final long serialVersionUID = 689046393247002331L;

	@Column(name = "productname", nullable = false, length = 55)
	private String productname;
	
	@Column(name = "description", nullable = false, length = 55)
	private String description;
	
	@Column(name = "barcode", nullable = false, length = 55, unique = true)
	private String barcode;

	@Column(name = "avg_price", nullable = false, length = 55)
	private double avgPrice;
	
	@Column(name = "low_price", nullable = false, length = 55)
	private double lowPrice;
	
	@Column(name = "high_price", nullable = false, length = 55)
	private double highPrice;
	
	@Column(name = "ideal_price", nullable = false, length = 55)
	private double idealPrice;
	
	public double getIdealPrice() {
		return idealPrice;
	}

	public void setIdealPrice(double idealPrice) {
		this.idealPrice = idealPrice;
	}

	@ManyToOne
	@JoinColumn(name = "cat_id")
	private ProductCategory productCategory;

	@OneToMany(mappedBy = "product")
	private List<ProductLog> productLogs;
	
	public List<ProductLog> getProductLogs() {
		return productLogs;
	}

	public void setProductLogs(List<ProductLog> productLogs) {
		this.productLogs = productLogs;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}

	
}
