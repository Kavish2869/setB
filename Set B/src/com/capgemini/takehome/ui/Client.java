package com.capgemini.takehome.ui;
import java.util.Scanner;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.exceptions.ProductNotAvailable;
import com.capgemini.takehome.exceptions.productCodeShouldBeOfFourDigits;
import com.capgemini.takehome.exceptions.quantityShouldGreaterThanZero;
import com.capgemini.takehome.services.IProductService;
import com.capgemini.takehome.services.ProductService;

public class Client {

	public static void main(String[] args) throws ProductNotAvailable, quantityShouldGreaterThanZero, productCodeShouldBeOfFourDigits
	{
		Scanner sc = new Scanner(System.in);
		IProductService service = new ProductService();
		while(true) {
			System.out.println("----Welcome----");
			System.out.println("1) Generate Bill by entering Product Code and quantity");
			System.out.println("2) Exit");
			int choice = sc.nextInt();
			switch(choice) 
			{
			case 1: System.out.print("Enter the product code: ");
			int productCode = sc.nextInt();
			System.out.print("Enter the quantity: ");
			int quantity = sc.nextInt();

			try {
				Product product = service.getProductDetails(productCode,quantity);
				service.showDetails(product,quantity);
			}
			catch(quantityShouldGreaterThanZero e) {
				System.out.println(e.getMessage());
			}
			catch(productCodeShouldBeOfFourDigits e) {
				System.out.println(e.getMessage());
			}
			catch(ProductNotAvailable e) {
				System.out.println(e.getMessage());
			}

			break;
			case 2: System.exit(0); 
			break;
			default:
			}

		}
	}
}
