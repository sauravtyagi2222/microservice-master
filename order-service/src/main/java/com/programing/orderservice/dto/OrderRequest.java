package com.programing.orderservice.dto;

import com.programing.orderservice.model.OrderLineItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemRequest> orderLineItemRequests;
}
