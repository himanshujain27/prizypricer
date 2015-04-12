/**
 * 
 */
package com.prizypricer.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prizypricer.dao.ProductDao;
import com.prizypricer.model.entity.Product;
import com.prizypricer.repository.ProductRepository;

/**
 * @author Himanshu
 *
 */
@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product findById(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product save(Product entity) {
		return productRepository.save(entity);
	}

	@Override
	public void delete(Product entity) {
		productRepository.delete(entity);
	}

	@Override
	public Product findByBarcode(String barcode) {
		return productRepository.findByBarcode(barcode);
	}

}
