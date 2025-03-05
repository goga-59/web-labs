package ru.goga59.onlineshop.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.goga59.onlineshop.storage.model.ProductModel;
import ru.goga59.onlineshop.storage.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll(Sort.by(Sort.Order.asc("id")));
    }

    public void createProduct(String title, String description, String image, String price) {
        productRepository.save(new ProductModel(title, description, image, price));
    }

    public void updateProduct(long id, String title, String description, String image, String price) {
        ProductModel product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Товар не найден: "+ id));

        product.setTitle(title);
        product.setDescription(description);
        product.setImage(image);
        product.setPrice(price);
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

}
