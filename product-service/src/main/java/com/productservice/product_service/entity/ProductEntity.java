package com.productservice.product_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products",
schema = "product_schema")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name")
    private String productName ;

    @Column(name = "description")
    private String description ;

    @Column(name = "category")
    private String category ;

    @Column(name = "brand")
    private String brand ;

    @Column(name = "price")
    private BigDecimal price ;

    @Column(name = "status")
    private String status ;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt ;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt ;

}
