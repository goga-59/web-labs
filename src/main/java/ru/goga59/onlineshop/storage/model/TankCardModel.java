package ru.goga59.onlineshop.storage.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity @Table(name = "tank_card")
public final class TankCardModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String price;

}
