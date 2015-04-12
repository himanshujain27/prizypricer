/**
 * 
 */
package com.prizypricer.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prizypricer.dao.ProductCategoryDao;
import com.prizypricer.model.entity.ProductCategory;
import com.prizypricer.repository.ProductCategoryRepository;

/**
 * @author Himanshu
 *
 */
@Repository
public class ProductCategoryDaoImpl implements ProductCategoryDao{

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Override
	public ProductCategory findById(Long id) {
		return productCategoryRepository.findOne(id);
	}

	@Override
	public List<ProductCategory> findAll() {
		return productCategoryRepository.findAll();
	}

	@Override
	public ProductCategory save(ProductCategory entity) {
		return productCategoryRepository.save(entity);
	}

	
	@Override
	public void delete(ProductCategory entity) {
		productCategoryRepository.delete(entity);
	}

}
