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
        model.addAttribute("content", "fragments/main/news");
        return "main_page";
    }

    @GetMapping("/info")
    public String toInfoPage(Model model) {
        model.addAttribute("content", "fragments/main/info");
        return "main_page";
    }

    @GetMapping("/contacts")
    public String toContactsPage(Model model) {
        model.addAttribute("content", "fragments/main/contacts");
        return "main_page";
    }

    @GetMapping("/catalog")
    public String toCatalogPage(Model model) {
        List<ProductModel> products = tankCardService.getAllProducts();
        model.addAttribute("productList", products);
        model.addAttribute("content", "fragments/main/catalog");
        return "main_page";
    }

    @GetMapping("/login")
    public String toLoginPage() {
        return "login_page";
    }

    @GetMapping("/admin")
    public String toAdminPage(Model model) {
        model.addAttribute("content", "fragments/admin/admin_main");
        return "admin_page";
    }

}
