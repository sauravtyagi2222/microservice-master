package com.programing.orderservice.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;
}
