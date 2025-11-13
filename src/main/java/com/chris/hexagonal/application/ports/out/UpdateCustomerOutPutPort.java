package com.chris.hexagonal.application.ports.out;

import com.chris.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutPutPort {

    void update(Customer customer);
}
