package ru.goga59.onlineshop.storage.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import java.time.LocalDate;
import java.util.List;

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

    public OrderModel(String customerName, String birthDate, String email, String phone, String tankNick, String paymentMethod, String comment, String product, Integer quantity) {
        this.name = customerName;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.nickname = tankNick;
        this.paymentMethod = paymentMethod;
        this.comment = comment;
        this.product = product;
        this.quantity = quantity;
    }
}
