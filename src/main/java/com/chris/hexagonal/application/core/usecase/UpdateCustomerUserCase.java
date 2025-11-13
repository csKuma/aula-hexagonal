package com.chris.hexagonal.application.core.usecase;

import com.chris.hexagonal.application.core.domain.Address;
import com.chris.hexagonal.application.core.domain.Customer;
import com.chris.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.chris.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.chris.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.chris.hexagonal.application.ports.out.UpdateCustomerOutPutPort;

public class UpdateCustomerUserCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;
    private final UpdateCustomerOutPutPort updateCustomerOutPutPort;

    public UpdateCustomerUserCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                  FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
                                  UpdateCustomerOutPutPort updateCustomerOutPutPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.updateCustomerOutPutPort = updateCustomerOutPutPort;
    }


    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        Address address = findAddressByZipCodeOutPutPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutPutPort.update(customer);
    }
}
