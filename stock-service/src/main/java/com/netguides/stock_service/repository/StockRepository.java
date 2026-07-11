package com.netguides.stock_service.repository;

import com.netguides.stock_service.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<StockEntity,Long> {

    public StockEntity findByProductName(String productName);
}
