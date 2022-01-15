package objects;


import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.gson.Gson;

import utils.UtilsFile;

public class ListOfProducts {

	private Product[] productsList;


	public void createListOfProducts() { 
		UtilsFile productsListJsonFile = new UtilsFile("/src/test/resources/Data/products.json");
		String productJson = null;
		try {
			productJson = productsListJsonFile.inputStreamToString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		productsList = gson.fromJson(productJson, Product[].class);  
	}

	public Product getProduct(int index) {
		return productsList[index];
	}

}
