/**
 * 
 */
package com.prizypricer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prizypricer.dao.ProductLogDao;
import com.prizypricer.model.entity.ProductLog;
import com.prizypricer.service.ProductLogService;

/**
 * @author Himanshu
 *
 */

@Service("productLogService")
@Transactional(readOnly = true)
public class ProductLogServiceImpl implements ProductLogService {

	@Autowired
	private ProductLogDao productLogDao;
	
	@Override
	public ProductLog findById(Long id) {
		return productLogDao.findById(id);
	}

	
	@Override
	public List<ProductLog> findAll() {
		return productLogDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public ProductLog save(ProductLog entity) {
		return productLogDao.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(ProductLog entity) {
		productLogDao.delete(entity);
	}

}
