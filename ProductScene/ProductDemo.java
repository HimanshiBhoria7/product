package com;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ProductDemo {
	ProductService productService = new ProductService();

	
//Retrieve Students Info
@GetMapping("/studentdata")
public Products getDummyProduct() {
    Products s = new Products();
	s.setName("Himanshi");
	s.setBrand("Nike");
	return s;	
}

//Get by Id

@GetMapping("/personinforid/{id}")
public Products getDummyProductById(@PathVariable("id") Integer id) {
Products s = new Products();// creating java object

s.setId(id);
s.setName("Himanshi");
s.setBrand("Nike");
return s;
}

// add the person information POst

@PostMapping(value = "/insertpersondetails")
public Products insertDummyProduct(@RequestBody Products product) {
return productService.addProduct(product); //calling the service
}


//update person info
@PutMapping("/update")
public Products updateproductInfo(@RequestBody Products product) {
return productService.updateProduct(product);

}
//get list
@GetMapping("/getlist")
public List<Products> getDummyProductList() {
List<Products> listOfProduct = productService.getAllProductlist();
return listOfProduct;
}

//delete the data
@DeleteMapping("/delete/{id}")
public List<Products> deleteProductById(@PathVariable Integer id) {
new ProductService().deleteProduct(id);
return new ProductService().getAllProductlist();
}

}



