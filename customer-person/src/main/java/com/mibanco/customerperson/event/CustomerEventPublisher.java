package com.mibanco.customerperson.event;

import com.mibanco.customerperson.dto.CustomerResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void sendCustomerUpdateEvent(CustomerResponseDTO customer) {
        rabbitTemplate.convertAndSend("customerTopicExchange", "customer.update", customer, message -> {
            message.getMessageProperties().setContentType(MessageProperties.CONTENT_TYPE_JSON);
            return message;
        });
    }
}

