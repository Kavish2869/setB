package com.capgemini.takehome.services;
import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.exceptions.ProductNotAvailable;
import com.capgemini.takehome.exceptions.productCodeShouldBeOfFourDigits;
import com.capgemini.takehome.exceptions.quantityShouldGreaterThanZero;

public interface IProductService{
	Product getProductDetails(int productCode,int quantity)throws ProductNotAvailable, quantityShouldGreaterThanZero, productCodeShouldBeOfFourDigits;

	void showDetails(Product product,int quantity);

}
