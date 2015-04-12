package com.prizypricer.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prizypricer.dao.ProductLogDao;
import com.prizypricer.model.entity.ProductLog;
import com.prizypricer.repository.ProductLogRepository;

/**
 * @author Himanshu
 *
 */
@Repository
public class ProductLogDaoImpl implements ProductLogDao {

	@Autowired
	private ProductLogRepository  productLogRepository;
	
	@Override
	public ProductLog findById(Long id) {
		return productLogRepository.findOne(id);
	}

	@Override
	public List<ProductLog> findAll() {
		return productLogRepository.findAll();
	}

	@Override
	public ProductLog save(ProductLog entity) {
		return productLogRepository.save(entity);
	}

	@Override
	public void delete(ProductLog entity) {
		productLogRepository.delete(entity);
	}

}
