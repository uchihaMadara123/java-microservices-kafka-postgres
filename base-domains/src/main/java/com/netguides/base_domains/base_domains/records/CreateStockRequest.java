package com.netguides.base_domains.base_domains.records;

import lombok.Builder;

@Builder
public record CreateStockRequest(Long productId,
                                 String productName,
                                 Long availableQuantity,
                                 Long reservedQuantity
) {
}
