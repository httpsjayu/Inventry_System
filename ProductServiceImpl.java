package in.jay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jay.entity.Product;
import in.jay.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo repo;
	
	@Override
	public Product saveProduct(Product product) {
		Product savedProduct = repo.save(product);
		return savedProduct;
	}

	@Override
	public Product updateProduct(Product product,Integer id) {

	    Product products = repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Product not found"));

	    product.setProductName(products.getProductName());
	    product.setStatus(products.getStatus());

	    return repo.save(products);
	}


	@Override
	public List<Product> getAllProducts() {
	
		List<Product> allProducts = repo.findAll();
		
		return allProducts;
	}

	@Override
	public void deleteProduct(Integer id) {
	
		 repo.deleteById(id);
		
	
	}

	
	
	

}
