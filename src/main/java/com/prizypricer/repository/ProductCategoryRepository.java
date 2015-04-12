/**
 * 
 */
package com.prizypricer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prizypricer.model.entity.ProductCategory;

/**
 * @author Himanshu
 *
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{

}
