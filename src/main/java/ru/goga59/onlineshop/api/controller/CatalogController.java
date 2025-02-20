package ru.goga59.onlineshop.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.goga59.onlineshop.api.service.TankCardService;
import ru.goga59.onlineshop.storage.model.TankCardModel;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CatalogController {

    private final TankCardService tankCardService;

    @GetMapping("/catalog")
    public String toCatalogPage(Model model) {
        List<TankCardModel> tankCards = tankCardService.getAllTanks();
        model.addAttribute("tankCards", tankCards);
        return "catalog";
    }

}
