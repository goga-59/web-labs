package ru.goga59.onlineshop.storage.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity @Table(name = "orders")
public class OrderModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String birthDate;

    private String email;

    private String phone;

    private String nickname;

    @Column(name = "payment_method")
    private String paymentMethod;

    private String comment;

    private String product;

    private Integer quantity;

    @Column(name = "total_price")
    private String totalPrice;

    public OrderModel(
            String customerName, String birthDate, String email, String phone, String nickname,
            String paymentMethod, String comment, String product, Integer quantity, String totalPrice
    ) {
        this.name = customerName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.nickname = nickname;
        this.paymentMethod = paymentMethod;
        this.comment = comment;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
