package com.chris.hexagonal.adapters.in.consumer;

import com.chris.hexagonal.adapters.in.Mapper.CustomerMessageMapper;
import com.chris.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.chris.hexagonal.application.core.domain.Customer;
import com.chris.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReciveValidateCpdConsumer {
    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "chris")
    public void recive(CustomerMessage customerMessage) {
        Customer customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
