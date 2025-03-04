package ru.goga59.onlineshop.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.goga59.onlineshop.api.service.OrderService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/submit/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public String submitOrder(
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
        orderService.createOrder(customerName, birthDate, email, phone, tankNick, paymentMethod, comment, product, quantity);
        return "success";
    }

}
