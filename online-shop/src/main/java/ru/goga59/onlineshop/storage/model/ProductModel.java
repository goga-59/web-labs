package ru.goga59.onlineshop.storage.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity @Table(name = "product")
public final class ProductModel {

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

    public ProductModel(String title, String description, String image, String price) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
    }

}
