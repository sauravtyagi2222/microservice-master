package com.programing.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "order_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String orderNUmber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItem> orderLineItems;
}
