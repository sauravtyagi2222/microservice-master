package com.programing.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequest {
    private int id;
    private String name;
    private String description;
    private Long price;
}
