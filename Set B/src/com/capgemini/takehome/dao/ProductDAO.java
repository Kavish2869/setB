package com.capgemini.takehome.dao;
import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.util.CollectionUtil;

public class ProductDAO implements IProductDAO{
	@Override
	public Product getProductDetails(int productCode) {
		Product product = CollectionUtil.products.get(productCode); 
		return product;
	}

}
