package com.chris.hexagonal.adapters.in.controller.mapper;

import com.chris.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.chris.hexagonal.adapters.in.controller.response.AddressResponse;
import com.chris.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.chris.hexagonal.application.core.domain.Address;
import com.chris.hexagonal.application.core.domain.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-14T15:18:35-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerRequest customerRequest) {
        if ( customerRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerRequest.getName() );
        customer.setCpf( customerRequest.getCpf() );

        return customer;
    }

    @Override
    public CustomerResponse toCustomerResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setName( customer.getName() );
        customerResponse.setAddress( addressToAddressResponse( customer.getAddress() ) );
        customerResponse.setCpf( customer.getCpf() );
        customerResponse.setIdValidCpf( customer.getIdValidCpf() );

        return customerResponse;
    }

    protected AddressResponse addressToAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setStreet( address.getStreet() );
        addressResponse.setCity( address.getCity() );
        addressResponse.setState( address.getState() );

        return addressResponse;
    }
}
