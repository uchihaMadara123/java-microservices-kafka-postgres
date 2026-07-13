package com.netguides.base_domains.base_domains.records;

import lombok.Builder;

@Builder
public record ProductStockResponse(Long productid,
                                   String productName,
                                   Long quantity) {
}
