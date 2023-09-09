package com.programing.productservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product_tb")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private Long price;
}
