/**
 * 
 */
package com.prizypricer.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prizypricer.dao.IdealPriceFormulaDao;
import com.prizypricer.model.entity.IdealPriceFormula;
import com.prizypricer.repository.IdealPriceFormulaRepository;

/**
 * @author Himanshu
 *
 */
@Repository
public class IdealPriceFormulaDaoImpl implements IdealPriceFormulaDao{

	@Autowired
	private IdealPriceFormulaRepository idealPriceFormulaRepository;
	
	@Override
	public IdealPriceFormula findById(Long id) {
		return idealPriceFormulaRepository.findOne(id);
	}

	@Override
	public List<IdealPriceFormula> findAll() {
		return idealPriceFormulaRepository.findAll();
	}

	@Override
	public IdealPriceFormula save(IdealPriceFormula entity) {
		return idealPriceFormulaRepository.save(entity);
	}

	@Override
	public void delete(IdealPriceFormula entity) {
		idealPriceFormulaRepository.delete(entity);
	}

}
