package com.chris.hexagonal.adapters.in.controller;

import com.chris.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.chris.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.chris.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.chris.hexagonal.application.core.domain.Customer;
import com.chris.hexagonal.application.ports.in.DeleteCustomerByIdInputPot;
import com.chris.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.chris.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.chris.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;
    @Autowired
    private DeleteCustomerByIdInputPot deleteCustomerByIdInputPot;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id, @RequestBody @Valid CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteCustomerByIdInputPot.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
