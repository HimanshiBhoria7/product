package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
* It is just a helper class which should be replaced by database implementation.
* It is not very well written class, it is just used for demonstration.
*/
public class ProductService {
	static HashMap<Integer, Products> productIdMap = getProductIdMap(); //map list

	 public ProductService() {
	super();

	 if (productIdMap == null) {
	productIdMap = new HashMap<Integer, Products>();
	// Creating some objects of Person while initializing
	Products indiaPerson = new Products(1, "ram1","puma");
	Products chinaPerson = new Products(2, "ram2","adidas");
	Products nepalPerson = new Products(3, "ram3", "sketcher");
	Products bhutanPerson = new Products(4, "ram4", "code");

	 //adding map list of collections in java
	productIdMap.put(1, indiaPerson);
	productIdMap.put(4, chinaPerson);
	productIdMap.put(2, bhutanPerson);
	productIdMap.put(3, nepalPerson);
	}
	}

	public List<Products> getAllProductlist() {
	List<Products> productlist = new ArrayList<Products>(productIdMap.values());
	return productlist;
	}

	public Products getProduct(int id) {
	Products Product = productIdMap.get(id);
	return Product;
	}

	// add person
	public Products addProduct(Products product) {
	product.setId(getMaxId()+ 1);
	// key , value
	productIdMap.put(product.getId(),product); ///logic class
	return product;
	}
	//update
	public Products updateProduct(Products product) {
	if (product.getId() <= 0)
	return null;
	productIdMap.put(product.getId(), product);
	return product;

	 }
	//delete

	public void deleteProduct(int id) {
		productIdMap.remove(id);
	}
	public static HashMap<Integer, Products> getProductIdMap() {
	return productIdMap;
	}

//	 // Utility method to get max id
	public static int getMaxId() {
	int max = 0;
	for (int id : productIdMap.keySet()) {
	if (max <= id)
	max = id;

	 }
	return max;
	}	
}