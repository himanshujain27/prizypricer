
package com.prizypricer.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private ProductLogService productLogService;
	
	@Autowired
	private IdealPriceFormulaService formulaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getWelcomePage(Model model) {
		return "index";
	}

	@RequestMapping(value = "/productlist", method = RequestMethod.GET)
	public String productList(Model model) {
		List<Product> productList = productService.findAll();
		model.addAttribute("productList", productList);
		List<ProductCategory> productCategories=productCategoryService.findAll();
		model.addAttribute("productCategories", productCategories);
		if (productList == null || productList.isEmpty())
			model.addAttribute("showMessage", "No product added yet!");
		return "productlist";
	}
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.GET)
	public String addproduct(Model model) {
		Product product=new Product();
		List<ProductCategory> productCategories=productCategoryService.findAll();
		model.addAttribute("productCategories", productCategories);
		model.addAttribute("product",product);
		return "addproduct";
	}
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String addproduct(@ModelAttribute("product") Product product,
			RedirectAttributes redir, HttpServletRequest req) {
		ProductCategory productCategory=productCategoryService.findById(product.getProductCategory().getId());
		product.setProductCategory(productCategory);
		productService.save(product);
		return "redirect:/productlist";
	}
	
	@RequestMapping(value = "/addproductprice", method = RequestMethod.POST)
	public @ResponseBody String addproductprice(Model model, @RequestParam String price,@RequestParam long productid,
			RedirectAttributes redir, HttpServletRequest req) {
		ProductLog productLog=new ProductLog();
		if(price=="" || price ==null){
			price="0";
		}
		Product product=productService.findById(productid);
		productLog.setPrice(Double.parseDouble(price));
		productLog.setProduct(product);
		productLogService.save(productLog);
		if(product.getLowPrice()==0.0 || productLog.getPrice()<product.getLowPrice()){
			product.setLowPrice(productLog.getPrice());
		}
		if(product.getHighPrice()==0.0 || productLog.getPrice()>product.getHighPrice()){
			product.setLowPrice(productLog.getPrice());
		}
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
			List<ProductLog> sortedList=new ArrayList<ProductLog>(productLogs);
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
		productService.save(product);
		return "redirect:/productlist";
	}
	
	
	@RequestMapping(value = "/adminproductlist", method = RequestMethod.GET)
	public String adminProductList(Model model) {
		List<Product> productList = productService.findAll();
		model.addAttribute("productList", productList);
		List<ProductCategory> productCategories=productCategoryService.findAll();
		model.addAttribute("productCategories", productCategories);
		if (productList == null || productList.isEmpty())
			model.addAttribute("showMessage", "No product added yet!");
		return "adminproductlist";
	}

	@RequestMapping(value = "/getIdealPriceFormula", method = RequestMethod.GET)
	public String getIdealPriceFormula(Model model) {
		List<IdealPriceFormula> idealPriceFormulas=formulaService.findAll();
		IdealPriceFormula idealPriceFormula=null;
		if(idealPriceFormulas.isEmpty()){
			idealPriceFormula=new IdealPriceFormula();
		}else{
			idealPriceFormula=idealPriceFormulas.get(0);
		}
		model.addAttribute("idealPriceFormula", idealPriceFormula);
		return "formula";
	}

	
	@RequestMapping(value = "/setIdealPriceFormula", method = RequestMethod.GET)
	public String setIdealPriceFormula(Model model) {
		List<IdealPriceFormula> idealPriceFormulas=formulaService.findAll();
		IdealPriceFormula idealPriceFormula=null;
		if(idealPriceFormulas.isEmpty()){
			idealPriceFormula=new IdealPriceFormula();
		}else{
			idealPriceFormula=idealPriceFormulas.get(0);
		}
		model.addAttribute("idealPriceFormula", idealPriceFormula);	
		return "editformula";
	}
	
	@RequestMapping(value = "/setIdealPriceFormula", method = RequestMethod.POST)
	public String setIdealPriceFormula(@ModelAttribute("idealPriceFormula") IdealPriceFormula idealPriceFormula,RedirectAttributes redir, HttpServletRequest req) {
		formulaService.save(idealPriceFormula);
		return "redirect:/getIdealPriceFormula";
	}

	@RequestMapping(value = "/productdetail/{id}", method = RequestMethod.GET)
	public String getProductDetails(Model model,@PathVariable("id") Long productid) {
		Product product=productService.findById(productid);
		model.addAttribute("product", product);
		return "productdetail";
	}
	
	@RequestMapping(value = "/checkbarcode", method = RequestMethod.GET)
	public @ResponseBody
	String checkBarCode(@RequestParam("barcode") String barcode, HttpServletResponse res) {
		Product product=productService.findByBarcode(barcode);
		if(product!=null){
			return "failed";
		}
		return "success";
	}

}

