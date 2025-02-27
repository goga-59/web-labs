package ru.goga59.onlineshop.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.goga59.onlineshop.storage.model.OrderModel;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
}
