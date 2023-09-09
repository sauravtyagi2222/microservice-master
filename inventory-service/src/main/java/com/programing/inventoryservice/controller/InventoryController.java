package com.programing.inventoryservice.controller;

import com.programing.inventoryservice.dto.InventoryResponse;
import com.programing.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> findBySkuCode(@RequestParam List<String> skuCode) {
        log.info("Call findBySkuCode() service {} ", skuCode);
        return inventoryService.findBySkuCode(skuCode);
    }
}
