package com.sthore.msOperador.models;




import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, columnDefinition = "DECIMAL(19,4)")
    private Double price;

    @Column(length = 200)
    private String description;

    @Column(nullable = false, length = 200)
    private String imageUrl;
/* 
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt; */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Objects.isNull(name)) {
            name="";
        } 
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if (Objects.isNull(price)) {
            price=0.00;
        } 
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (Objects.isNull(description)) {
            description="";
        } 
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
          if (Objects.isNull(imageUrl)) {
            imageUrl="";
        } 
        this.imageUrl = imageUrl;
    }

   /*  public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
 */
    // Constructor, getters y setters según sea necesario

   /*  public static List<Product> getSampleProducts() {
        List<Product> productList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            Product product = new Product();
            product.setName("Producto " + i);
            product.setPrice(10.0 * i);  // Precios variados para ejemplo
            product.setDescription("Descripción del producto " + i);
            product.setImageUrl("url_imagen_" + i);

            productList.add(product);
        }

        return productList;
    } */
}
