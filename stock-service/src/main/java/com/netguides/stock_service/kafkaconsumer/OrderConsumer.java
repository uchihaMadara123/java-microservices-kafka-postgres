package com.netguides.stock_service.kafkaconsumer;

import com.netguides.base_domains.base_domains.dto.OrderEvent;
import com.netguides.stock_service.repository.OrderHistoryRepository;
import com.netguides.stock_service.service.OrderHistoryService;
import com.netguides.stock_service.service.StockProcessingService;
import com.netguides.stock_service.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private final StockProcessingService stockProcessingServiceService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    public OrderConsumer(StockProcessingService stockProcessingServiceService) {
        this.stockProcessingServiceService = stockProcessingServiceService;
    }

    @KafkaListener(topics= "${spring.kafka.topic.name}"
            , groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event){
        LOGGER.info("Order event => {}", event.toString());
        stockProcessingServiceService.process(event.getOrder());
    }
}
