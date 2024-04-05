package ch.noseryoung.gradletask.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductWeb {

    private final ProductService productService;

    @Autowired
    public ProductWeb(ProductService productService) {
        this.productService = productService;
    }

    // Endpoint to fetch all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // Endpoint to fetch a single product by ID
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Additional endpoints for adding, updating, and deleting products can be added here.
}

