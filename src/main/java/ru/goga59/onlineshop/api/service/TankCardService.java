package ru.goga59.onlineshop.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.goga59.onlineshop.storage.model.TankCardModel;
import ru.goga59.onlineshop.storage.repository.TankCardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TankCardService {

    private final TankCardRepository catalogRepository;

    public List<TankCardModel> getAllTanks() {
        return catalogRepository.findAll();
    }

    public void addTank(TankCardModel tankCard) {
        catalogRepository.save(tankCard);
    }

}
