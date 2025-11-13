package com.chris.hexagonal.application.ports.out;

import com.chris.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutPutPort {

    Optional<Customer> find(String id);
}
