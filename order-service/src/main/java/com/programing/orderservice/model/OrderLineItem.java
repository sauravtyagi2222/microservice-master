package com.programing.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="order_line_item_tb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
