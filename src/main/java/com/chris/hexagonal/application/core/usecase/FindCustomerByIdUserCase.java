package com.chris.hexagonal.application.core.usecase;

import com.chris.hexagonal.application.core.domain.Customer;
import com.chris.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.chris.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;

public class FindCustomerByIdUserCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutPutPort findCustomerByIdOutPutPort;

    public FindCustomerByIdUserCase(FindCustomerByIdOutPutPort findCustomerByIdOutPutPort) {
        this.findCustomerByIdOutPutPort = findCustomerByIdOutPutPort;
    }

    @Override
    public Customer find(String id) {

        return findCustomerByIdOutPutPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
