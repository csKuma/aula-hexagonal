package com.chris.hexagonal.application.ports.in;

import com.chris.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {
    void update(Customer customer, String zipCode);
}
