package com.netguides.base_domains.base_domains.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    @NotBlank(message = "Order Name is required")
    private String orderName;

    @NotBlank(message = "Customer Name Name is required")
    private String customerName;

    @NotBlank(message = "Product Name Name is required")
    private String productName;

    @NotNull(message = "Status is required")
    private String status;

    @NotNull(message = "Quantity is required")
    private Integer quantity;

    @NotNull(message = "Price is required")
    private Double price;
}
