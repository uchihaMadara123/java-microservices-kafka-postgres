package com.netguides.stock_service.utils;

import com.netguides.base_domains.base_domains.records.CreateStockRequest;
import com.netguides.base_domains.base_domains.records.CreateStockResponse;
import com.netguides.base_domains.base_domains.records.ProductStockResponse;
import com.netguides.stock_service.entity.StockEntity;

public class StockUtils {

    public static StockEntity convertToStockEntity(CreateStockRequest request){
        return StockEntity.builder().productId(request.productId())
                .productName(request.productName())
                .availableQuantity(request.availableQuantity())
                .reservedQuantity(request.reservedQuantity())
                .build();
    }

    public static CreateStockResponse convertToStockResponse(StockEntity entity){
        return CreateStockResponse.builder().
                productId(entity.getProductId()).
                productName(entity.getProductName()).
                availableQuantity(entity.getAvailableQuantity()).
                reservedQuantity(entity.getReservedQuantity()).
                build();
    }

    public static ProductStockResponse convertToProductStockResponse(StockEntity entity){
        return ProductStockResponse.builder().
                productid(entity.getProductId()).
                productName(entity.getProductName()).
                quantity(entity.getAvailableQuantity()).
                build();
    }
}
