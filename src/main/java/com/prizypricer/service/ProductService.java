/**
 * 
 */
package com.prizypricer.service;

import com.prizypricer.model.entity.Product;

/**
 * @author Himanshu
 *
 */
public interface ProductService extends AbstractService<Product,Long>{

	public Product findByBarcode(String barcode);
}
