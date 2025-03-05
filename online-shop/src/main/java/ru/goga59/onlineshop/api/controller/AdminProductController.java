package ru.goga59.onlineshop.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.goga59.onlineshop.api.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class AdminProductController {

    private final ProductService productService;

    @GetMapping
    public String toAdminPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("content", "fragments/admin/admin_product");
        return "admin_page";
    }

    @PostMapping("/create")
    public String createProduct(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String image,
            @RequestParam String price
    ) {
        productService.createProduct(title, description, image, price);
        return "redirect:/admin/products";
    }

    @PostMapping("/update")
    public String updateProduct(
            @RequestParam long id,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String image,
            @RequestParam String price
    ) {
        productService.updateProduct(id, title, description, image, price);
        return "redirect:/admin/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/products";
    }

}
