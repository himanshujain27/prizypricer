package com.prizypricer.service;

import java.util.List;

/**
 * @author Himanshu
 *
 */
public interface AbstractService<T, ID> {

	public T findById(ID id);

	public List<T> findAll();

	public T save(T entity);

	public void delete(T entity);

}