package com.capgemini.takehome.services;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.dao.IProductDAO;
import com.capgemini.takehome.dao.ProductDAO;
import com.capgemini.takehome.exceptions.ProductNotAvailable;
import com.capgemini.takehome.exceptions.productCodeShouldBeOfFourDigits;
import com.capgemini.takehome.exceptions.quantityShouldGreaterThanZero;

public class ProductService implements IProductService {

	IProductDAO productdao = new ProductDAO();
	Product product;
	@Override
	public Product getProductDetails(int productCode, int quantity)throws ProductNotAvailable, quantityShouldGreaterThanZero, productCodeShouldBeOfFourDigits {
		int count = 0;
		int temp = productCode;
		while(temp!=0) {
			temp=temp/10;
			count+=1;
		}	
		if(quantity > 0) {
			if(count==4) {
				product = productdao.getProductDetails(productCode);
				if(product == null) {throw new ProductNotAvailable("Sorry! The Product Code "+productCode+" Is not available."); }
				
				return product;
			}
			else {
				throw new productCodeShouldBeOfFourDigits("[ Code Should be of length 4 ]");
			}
		}
		else {
			throw new quantityShouldGreaterThanZero("[ Please Enter Quantity Greater than zero ]");
		}
	}
	@Override
	public void showDetails(Product product, int quantity) {
		System.out.println("Product Name:         "+product.getProductName());
		System.out.println("Product Category:     "+product.getProductCategory());
		//System.out.println("Product Description:  "+product);
		System.out.println("Product Price(Rs):    "+product.getProductPrice());
		System.out.println("Quantity:             "+quantity);
		System.out.println("Line Total:           "+product.getProductPrice()*quantity);

		
	}
}

