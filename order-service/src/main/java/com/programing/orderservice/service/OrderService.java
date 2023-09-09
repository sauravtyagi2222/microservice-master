package com.programing.orderservice.service;

import com.programing.orderservice.dto.InventoryResponse;
import com.programing.orderservice.dto.OrderLineItemRequest;
import com.programing.orderservice.dto.OrderRequest;
import com.programing.orderservice.model.Order;
import com.programing.orderservice.model.OrderLineItem;
import com.programing.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNUmber(UUID.randomUUID().toString());
        List<OrderLineItem> orderLineItems = orderRequest.getOrderLineItemRequests()
                .stream().map(this::mapToProduct).toList();
        order.setOrderLineItems((orderLineItems));

        List<String> skuCodes = order.getOrderLineItems().stream().map(OrderLineItem::getSkuCode).toList();
        //call inventory service to check the inventory

        InventoryResponse[] inventoryResponses = webClient.get()
                .uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
        log.info("Check Stock {} ",inventoryResponses);
        boolean result=Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
        log.info("Check Stock result {} ",result);
        if (result) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later !!");
        }
    }

    private OrderLineItem mapToProduct(OrderLineItemRequest orderLineItemRequest) {
        return OrderLineItem.builder()
                .id(orderLineItemRequest.getId())
                .price(orderLineItemRequest.getPrice())
                .skuCode(orderLineItemRequest.getSkuCode())
                .quantity(orderLineItemRequest.getQuantity())
                .build();
    }
}
