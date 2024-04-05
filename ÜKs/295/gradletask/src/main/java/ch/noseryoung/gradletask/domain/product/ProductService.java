package ch.noseryoung.gradletask.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Method to add or update a product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Method to fetch all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to fetch a single product by ID
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    // Method to delete a product
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
