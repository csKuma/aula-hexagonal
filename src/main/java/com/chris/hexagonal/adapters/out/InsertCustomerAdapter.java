package com.chris.hexagonal.adapters.out;

import com.chris.hexagonal.adapters.out.repository.CustomerRepository;

import com.chris.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.chris.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.chris.hexagonal.application.core.domain.Customer;
import com.chris.hexagonal.application.ports.out.InsertCustomerOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;


    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
