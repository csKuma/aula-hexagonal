package com.chris.hexagonal.adapters.out;

import com.chris.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.chris.hexagonal.adapters.out.repository.CustomerRepository;
import com.chris.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.chris.hexagonal.application.core.domain.Customer;
import com.chris.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
