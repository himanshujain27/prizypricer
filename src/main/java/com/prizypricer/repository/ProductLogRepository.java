/**
 * 
 */
package com.prizypricer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prizypricer.model.entity.ProductLog;

/**
 * @author Himanshu
 *
 */
public interface ProductLogRepository extends JpaRepository<ProductLog, Long>{

}
