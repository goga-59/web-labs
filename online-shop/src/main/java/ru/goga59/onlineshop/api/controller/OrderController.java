package ru.goga59.onlineshop.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.goga59.onlineshop.api.service.OrderService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/submit/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public String submitOrder(
            Model model,
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
        orderService.createOrder(customerName, birthDate, email, phone, nickname, paymentMethod, comment, product, quantity, totalPrice);
        model.addAttribute("content", "fragments/main/success");
        return "main_page";
    }

}
