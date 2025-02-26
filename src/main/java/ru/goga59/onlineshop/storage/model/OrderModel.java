package ru.goga59.onlineshop.storage.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity @Table(name = "orders")
public class OrderModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String nickname;
    private String paymentMethod;
    private String comment;

    @ElementCollection
    private List<String> products;

    @ElementCollection
    private List<Integer> quantities;

    public OrderModel(String customerName, String email, String phone, String tankNick, String paymentMethod, String comment, List<String> products, List<Integer> quantities) {
        this.name = customerName;
        this.email = email;
        this.phone = phone;
        this.nickname = tankNick;
        this.paymentMethod = paymentMethod;
        this.comment = comment;
        this.products = products;
        this.quantities = quantities;
    }
}
