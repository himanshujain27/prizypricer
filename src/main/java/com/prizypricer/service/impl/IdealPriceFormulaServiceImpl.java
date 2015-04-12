package com.prizypricer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prizypricer.dao.IdealPriceFormulaDao;
import com.prizypricer.model.entity.IdealPriceFormula;
import com.prizypricer.service.IdealPriceFormulaService;

/**
 * @author Himanshu
 *
 */

@Service("idealPriceFormula")
@Transactional(readOnly = true)
public class IdealPriceFormulaServiceImpl implements IdealPriceFormulaService {

	@Autowired
	private IdealPriceFormulaDao idealPriceFormulaDao;
	
	@Override
	public IdealPriceFormula findById(Long id) {
		return idealPriceFormulaDao.findById(id);
	}

	@Override
	public List<IdealPriceFormula> findAll() {
		return idealPriceFormulaDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public IdealPriceFormula save(IdealPriceFormula entity) {
		return idealPriceFormulaDao.save(entity);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void delete(IdealPriceFormula entity) {
		idealPriceFormulaDao.delete(entity);
	}

}
