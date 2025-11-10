package com.chris.hexagonal.application.core.usecase;

import com.chris.hexagonal.application.core.domain.Customer;
import com.chris.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.chris.hexagonal.application.ports.out.InsertCustomerOutPutPort;

public class InsertCustomerUsercase {

    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;
    private final InsertCustomerOutPutPort insertCustomerOutPutPort;

    public InsertCustomerUsercase(FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
                                  InsertCustomerOutPutPort insertCustomerOutPutPort) {
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.insertCustomerOutPutPort = insertCustomerOutPutPort;
    }

    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutPutPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutPutPort.insert(customer);
    }
}
