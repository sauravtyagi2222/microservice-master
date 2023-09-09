package com.programing.inventoryservice;

import com.programing.inventoryservice.model.Inventory;
import com.programing.inventoryservice.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone_13");
            inventory.setQuantity(100);

            Inventory inventory1 = new Inventory();
            inventory1.setQuantity(0);
            inventory1.setSkuCode("iphone_13_red");

            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory);
            log.info("load inventory data {} ", inventory);
            log.info("load inventory1 data {} ", inventory1);
        };
    }
}
