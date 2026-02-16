package in.jay.service;

import java.util.List;

import in.jay.entity.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	
	public Product updateProduct(Product product,Integer id);
	
	public List<Product> getAllProducts();
	
	public void deleteProduct(Integer id);

}
