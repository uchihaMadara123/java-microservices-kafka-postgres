package com.netguides.stock_service.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock_transactions",
        schema = "stock_db_schema")
public class StockTransactionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "transaction_type")
    private String transactionType;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
