package com.capgemini.takehome.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.exceptions.ProductNotAvailable;
import com.capgemini.takehome.exceptions.productCodeShouldBeOfFourDigits;
import com.capgemini.takehome.exceptions.quantityShouldGreaterThanZero;
import com.capgemini.takehome.services.IProductService;
import com.capgemini.takehome.services.ProductService;
import com.capgemini.takehome.util.CollectionUtil;


public class BillingTestClass {
	Product product = new Product();
	private static IProductService service;

	@BeforeClass
	public static void setUpTestEnv() {
		service = new ProductService();
	}

	@Before
	public void setUpTestData() {		
		CollectionUtil.products.put(product.getProductId(), product);
	}

	@Test(expected = ProductNotAvailable.class)
	public void getProductDetailsForInvalidProductCode()throws ProductNotAvailable, quantityShouldGreaterThanZero, productCodeShouldBeOfFourDigits{
		service.getProductDetails(1232,2);
	}

	@Test
	public void getProductDetailsForvalidProductCode()throws ProductNotAvailable, quantityShouldGreaterThanZero, productCodeShouldBeOfFourDigits{
		Product expectedProduct = new Product(1001, "iPhone", "Electronics", 35000);
		Product actualProduct = service.getProductDetails(1001,2);
		Assert.assertEquals(expectedProduct, actualProduct);
	}

	@After
	public void tearDownTestData() {

	}

	@AfterClass
	public static void tearDownTestEnv() {
		service = null;
	}

}
