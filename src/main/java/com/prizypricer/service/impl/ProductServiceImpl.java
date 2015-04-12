package com.prizypricer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prizypricer.dao.ProductDao;
import com.prizypricer.model.entity.Product;
import com.prizypricer.service.ProductService;

/**
 * @author Himanshu
 *
 */

@Service("productService")
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product findById(Long id) {
		return productDao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Product save(Product entity) {
		return productDao.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Product entity) {
		productDao.delete(entity);
	}

	@Override
	public Product findByBarcode(String barcode) {
		return productDao.findByBarcode(barcode) ;
	}

}
