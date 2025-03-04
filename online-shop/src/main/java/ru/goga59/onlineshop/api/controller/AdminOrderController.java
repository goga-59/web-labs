package ru.goga59.onlineshop.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
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
        return "admin_order";
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
            @RequestParam String tankNick,
            @RequestParam String paymentMethod,
            @RequestParam String comment,
            @RequestParam String product,
            @RequestParam Integer quantity
    ) {
        orderService.updateOrder(id, customerName, birthDate, email, phone, tankNick, paymentMethod, comment, product, quantity);
        return "redirect:/admin/orders";
    }

}
