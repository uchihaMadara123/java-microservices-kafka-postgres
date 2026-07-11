package com.netguides.stock_service.repository;

import com.netguides.stock_service.entity.OrderHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepository extends JpaRepository<OrderHistoryEntity,Long> {

}
