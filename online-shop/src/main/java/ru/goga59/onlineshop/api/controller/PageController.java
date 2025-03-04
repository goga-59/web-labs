package ru.goga59.onlineshop.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.goga59.onlineshop.api.service.NewsService;
import ru.goga59.onlineshop.api.service.ProductService;
import ru.goga59.onlineshop.storage.model.NewsModel;
import ru.goga59.onlineshop.storage.model.ProductModel;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PageController {

    private final NewsService newsService;
    private final ProductService tankCardService;

    @GetMapping("/")
    public String toNewsPage(Model model) {
        List<NewsModel> newsList = newsService.getAllNews();
        model.addAttribute("newsList", newsList);
        return "news";
    }

    @GetMapping("/info")
    public String toInfoPage() {
        return "info";
    }

    @GetMapping("/contacts")
    public String toContactsPage() {
        return "contacts";
    }

    @GetMapping("/catalog")
    public String toCatalogPage(Model model) {
        List<ProductModel> tankCards = tankCardService.getAllProducts();
        model.addAttribute("productCards", tankCards);
        return "catalog";
    }

    @GetMapping("/admin")
    public String toAdminPage() {
        return "admin";
    }

}
