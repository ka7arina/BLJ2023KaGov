package ch.noseryoung.gradletask.domain.product;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @Column(name = "price", nullable = false, unique = true)
    private double price;

    public Product(int productId, String description, double price) {
        this.productId = productId;
        this.description = description;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
