package ru.goga59.onlineshop.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.goga59.onlineshop.storage.model.OrderModel;
import ru.goga59.onlineshop.storage.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderModel createOrder(
            String customerName, String email, String phone, String tankNick,
            String paymentMethod, String comment, List<String> products, List<Integer> quantities
    ) {
        OrderModel order = new OrderModel(customerName, email, phone, tankNick, paymentMethod, comment, products, quantities);
        return orderRepository.save(order);
    }

}
