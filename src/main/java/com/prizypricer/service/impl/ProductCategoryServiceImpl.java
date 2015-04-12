/**
 * 
 */
package com.prizypricer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prizypricer.dao.ProductCategoryDao;
import com.prizypricer.model.entity.ProductCategory;
import com.prizypricer.service.ProductCategoryService;

/**
 * @author Himanshu
 *
 */

@Service("productCategoryService")
@Transactional(readOnly = true)
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	@Override
	public ProductCategory findById(Long id) {
		return productCategoryDao.findById(id);
	}

	
	@Override
	public List<ProductCategory> findAll() {
		return productCategoryDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public ProductCategory save(ProductCategory entity) {
		return productCategoryDao.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(ProductCategory entity) {
		productCategoryDao.delete(entity);
	}

}
