

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.prizypricer.model.entity.IdealPriceFormula;
import com.prizypricer.model.entity.Product;
import com.prizypricer.model.entity.ProductCategory;
import com.prizypricer.model.entity.ProductLog;
import com.prizypricer.service.IdealPriceFormulaService;
import com.prizypricer.service.ProductCategoryService;
import com.prizypricer.service.ProductLogService;
import com.prizypricer.service.ProductService;

/**
 * @author Himanshu
 *
 */
@ContextConfiguration
public class ApplicationContext extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private ProductLogService productLogService;
	
	@Autowired
	private IdealPriceFormulaService formulaService;
	
	
	//To test add product functionality
	 @Test
	 public void testCase1() {
		 boolean add=false;
	    System.out.println("----Test Case 1-----");
	    System.out.println("----To test add product functionality-----");
	    Product product=new Product();
	    product.setBarcode("Test123234");
	    ProductCategory productCategory=productCategoryService.findById(1l);
	    product.setProductCategory(productCategory);
	    product.setDescription("testing..");
	    product.setProductname("Test1");
	    product=productService.save(product);
	    if(product!=null){
	    	System.out.println("Product Test1 added successfully");
	    	add=true;
	    }
	    assertEquals(true,add);
	 }
	 
	 
	 //To test add product price functionality
	 @Test
	 public void testCase2() {
		 boolean add=false;
	    System.out.println("----Test Case 2-----");
	    System.out.println("----To test add product price functionality-----");
	    List<Product> productList=productService.findAll();
	    Product product=productList.get(productList.size()-1);
	    ProductLog productLog=new ProductLog();
	    productLog.setPrice(12.00);
	    productLog.setProduct(product);
	    productLog=productLogService.save(productLog);
	    if(productLog!=null){
	    	System.out.println("Product "+product.getProductname()+" price added successfully");
	    	add=true;
	    }
	    assertEquals(true,add);
	 }
	 	 
	 
	 //To test ideal price,high price,low price,average price calculation
	 @Test
	 public void testCase3() {
		 boolean add=false;
	    System.out.println("----Test Case 3-----");
	    System.out.println("----To test ideal price,high price,low price,average price calculation-----");
	    List<Product> productList=productService.findAll();
	    Product product=productList.get(0);
	    double priceTotal=0.0;
		for(ProductLog productLogTemp:product.getProductLogs()){
				priceTotal+=productLogTemp.getPrice();
		}
		product.setAvgPrice((priceTotal/product.getProductLogs().size()));
		
		//calculation for ideal price
		List<ProductLog> productLogs=product.getProductLogs();
		List<IdealPriceFormula> idealPriceFormulas=formulaService.findAll();
		IdealPriceFormula idealPriceFormula=null;
		if(idealPriceFormulas.isEmpty()){
			idealPriceFormula=new IdealPriceFormula();
		}else{
			idealPriceFormula=idealPriceFormulas.get(0);
		}
		List<ProductLog> sortedList=new ArrayList<ProductLog>(productLogs);
		if(productLogs.size()>(idealPriceFormula.getRhighest()+idealPriceFormula.getRlowest())){
			Collections.sort(productLogs, new Comparator<ProductLog>() 
                {
				public int compare(ProductLog o1, ProductLog o2) {
						if(o1.getPrice() < o2.getPrice()){
                            return 1;
                        } else {
                            return -1;
                        }
					}
                 }	
			);
			product.setHighPrice(sortedList.get(sortedList.size()-1).getPrice());
			product.setLowPrice(sortedList.get(0).getPrice());
			for(int i=0;i<idealPriceFormula.getRhighest();i++){
				sortedList.remove(sortedList.size()-1);
			}
			for(int i=0;i<idealPriceFormula.getRlowest();i++){
					sortedList.remove(0);	
			}
			priceTotal=0.0;
			for(ProductLog productLogSort:sortedList){
				priceTotal+=productLogSort.getPrice();
			}
			double avgIdalPrice=priceTotal/sortedList.size();
			product.setIdealPrice((avgIdalPrice)+(avgIdalPrice*idealPriceFormula.getAddition()/100));
			}else{
				product.setIdealPrice(product.getAvgPrice()+(product.getAvgPrice()*idealPriceFormula.getAddition()/100));
			}
			product=productService.save(product);
			if(product!=null){
				System.out.println("Product "+product.getProductname()+ "highest Price: "+product.getHighPrice());
				System.out.println("Product "+product.getProductname()+ "lowest Price: "+product.getLowPrice());
				System.out.println("Product "+product.getProductname()+ "average Price: "+product.getAvgPrice());
				System.out.println("Product "+product.getProductname()+ "ideal price: "+product.getIdealPrice());
				add=true;
			}
			assertEquals(true,add);
	 }
	 
	 //To test product list
	 @Test
	 public void testCase4() {
		 boolean add=false;
	    System.out.println("----Test Case 4-----");
	    System.out.println("----To test product list-----");
	    List<Product> productList=productService.findAll();
	     if(productList!=null && (!productList.isEmpty())){
	    	System.out.println("There are total "+productList.size()+" products available"); 
	    	add=true;
	    }
	    assertEquals(true,add);
	 }
	
}
