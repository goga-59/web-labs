package ru.goga59.onlineshop.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.goga59.onlineshop.api.service.OrderService;
import ru.goga59.onlineshop.api.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/orders")
public class AdminOrderController {

    private final OrderService orderService;
    private final ProductService productService;

    @GetMapping
    public String toAdminPage(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("content", "fragments/admin/admin_order");
        return "admin_page";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "redirect:/admin/orders";
    }

    @PostMapping("/update")
    public String updateOrder(
            @RequestParam Long id,
            @RequestParam String customerName,
            @RequestParam String birthDate,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String nickname,
            @RequestParam String paymentMethod,
            @RequestParam String comment,
            @RequestParam String product,
            @RequestParam Integer quantity,
            @RequestParam String totalPrice
    ) {
        orderService.updateOrder(id, customerName, birthDate, email, phone, nickname, paymentMethod, comment, product, quantity, totalPrice);
        return "redirect:/admin/orders";
    }

}
