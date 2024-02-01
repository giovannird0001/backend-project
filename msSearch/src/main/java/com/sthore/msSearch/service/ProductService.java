package com.sthore.msSearch.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sthore.msSearch.models.Product;
import com.sthore.msSearch.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
       public void saveSampleProducts(List<Product> sampleProducts) {
        for (Product product : sampleProducts) {
            // Puedes realizar cualquier lógica de negocio aquí antes de guardar el producto
            productRepository.save(product);
        }
    }
     public List<Product> searchProducts(String keyword) {
        // Realizar la lógica de búsqueda en la base de datos
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream()
                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}