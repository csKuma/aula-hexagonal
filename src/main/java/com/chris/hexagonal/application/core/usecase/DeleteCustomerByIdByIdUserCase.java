package com.chris.hexagonal.application.core.usecase;

import com.chris.hexagonal.application.ports.in.DeleteCustomerByIdInputPot;
import com.chris.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.chris.hexagonal.application.ports.out.DeleteCustomerByIdOutPutPort;

public class DeleteCustomerByIdByIdUserCase implements DeleteCustomerByIdInputPot {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutPutPort deleteCustomerByIdOutPutPort;

    public DeleteCustomerByIdByIdUserCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                          DeleteCustomerByIdOutPutPort deleteCustomerByIdOutPutPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutPutPort = deleteCustomerByIdOutPutPort;
    }


    @Override
    public void delete(String id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutPutPort.delete(id);
    }


}
