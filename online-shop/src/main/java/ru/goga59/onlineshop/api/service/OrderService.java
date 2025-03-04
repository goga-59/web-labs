package ru.goga59.onlineshop.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.goga59.onlineshop.storage.model.OrderModel;
import ru.goga59.onlineshop.storage.repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll(Sort.by(Sort.Order.asc("id")));
    }

    public void createOrder(
            String customerName, String birthDate, String email, String phone, String tankNick,
            String paymentMethod, String comment, String product, Integer quantity
    ) {
        OrderModel order = new OrderModel(customerName, birthDate, email, phone, tankNick, paymentMethod, comment, product, quantity);
        orderRepository.save(order);
    }

    public void updateOrder(
            Long id, String customerName, String birthDate, String email, String phone, String tankNick,
            String paymentMethod, String comment, String product, Integer quantity
    ) {
        OrderModel order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Заказ не найден: "+ id));

        order.setName(customerName);
        order.setBirthDate(birthDate);
        order.setEmail(email);
        order.setPhone(phone);
        order.setNickname(tankNick);
        order.setPaymentMethod(paymentMethod);
        order.setComment(comment);
        order.setProduct(product);
        order.setQuantity(quantity);
        
        orderRepository.save(order);
    }

    public void deleteOrder(long orderId) {
        orderRepository.deleteById(orderId);
    }

}
