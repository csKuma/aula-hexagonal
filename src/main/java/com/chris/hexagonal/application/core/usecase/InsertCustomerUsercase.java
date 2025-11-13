package com.chris.hexagonal.application.core.usecase;

import com.chris.hexagonal.application.core.domain.Customer;
import com.chris.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.chris.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import com.chris.hexagonal.application.ports.out.InsertCustomerOutPutPort;
import com.chris.hexagonal.application.ports.out.SendCpfValidationOutPutPort;

public class InsertCustomerUsercase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort;
    private final InsertCustomerOutPutPort insertCustomerOutPutPort;
    private final SendCpfValidationOutPutPort sendCpfValidationOutPutPort;

    public InsertCustomerUsercase(FindAddressByZipCodeOutPutPort findAddressByZipCodeOutPutPort,
                                  InsertCustomerOutPutPort insertCustomerOutPutPort,
                                  SendCpfValidationOutPutPort sendCpfValidationOutPutPort) {
        this.findAddressByZipCodeOutPutPort = findAddressByZipCodeOutPutPort;
        this.insertCustomerOutPutPort = insertCustomerOutPutPort;
        this.sendCpfValidationOutPutPort = sendCpfValidationOutPutPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutPutPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutPutPort.insert(customer);
        sendCpfValidationOutPutPort.send(customer.getCpf());
    }
}
