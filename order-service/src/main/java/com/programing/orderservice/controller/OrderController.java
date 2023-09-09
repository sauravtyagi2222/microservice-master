package com.programing.orderservice.controller;

import com.programing.orderservice.dto.OrderRequest;
import com.programing.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        log.info("Call placeOrder service order count is : {} ", orderRequest.getOrderLineItemRequests().size());
        return "Order Successfully Placed";
    }
}
