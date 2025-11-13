package com.chris.hexagonal.application.ports.in;

import com.chris.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}
