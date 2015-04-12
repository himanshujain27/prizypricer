/**
 * 
 */
package com.prizypricer.dao;

import com.prizypricer.model.entity.Product;

/**
 * @author Himanshu
 *
 */
public interface ProductDao extends AbstractDao<Product, Long>{

	Product findByBarcode(String barcode);

}
