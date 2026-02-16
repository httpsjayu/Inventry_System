package in.jay.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.jay.entity.Product;
import in.jay.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
	Product savedProduct = service.saveProduct(product);
	return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<Product> updatedProduct(@RequestBody Product product,Integer id){
		Product updatedProduct = service.updateProduct(product, id);
		
		return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> products = service.getAllProducts();
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity deleteProduct(@PathVariable("id") Integer id){
		 service.deleteProduct(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
