package ru.goga59.onlineshop.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.goga59.onlineshop.storage.model.ProductModel;
import ru.goga59.onlineshop.storage.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository catalogRepository;

    public List<ProductModel> getAllTanks() {
        return catalogRepository.findAll();
    }

    public void addTank(ProductModel tankCard) {
        catalogRepository.save(tankCard);
    }

}
