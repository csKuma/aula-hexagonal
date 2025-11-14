package com.chris.hexagonal.adapters.out.repository.mapper;

import com.chris.hexagonal.adapters.out.repository.entity.AddressEntity;
import com.chris.hexagonal.adapters.out.repository.entity.CustomerEntity;
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
public class CustomerEntityMapperImpl implements CustomerEntityMapper {

    @Override
    public CustomerEntity toCustomerEntity(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setId( customer.getId() );
        customerEntity.setName( customer.getName() );
        customerEntity.setAddress( addressToAddressEntity( customer.getAddress() ) );
        customerEntity.setCpf( customer.getCpf() );
        customerEntity.setIdValidCpf( customer.getIdValidCpf() );

        return customerEntity;
    }

    @Override
    public Customer toCustomer(CustomerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( entity.getId() );
        customer.setName( entity.getName() );
        customer.setAddress( addressEntityToAddress( entity.getAddress() ) );
        customer.setCpf( entity.getCpf() );
        customer.setIdValidCpf( entity.getIdValidCpf() );

        return customer;
    }

    protected AddressEntity addressToAddressEntity(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setStreet( address.getStreet() );
        addressEntity.setCity( address.getCity() );
        addressEntity.setState( address.getState() );

        return addressEntity;
    }

    protected Address addressEntityToAddress(AddressEntity addressEntity) {
        if ( addressEntity == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreet( addressEntity.getStreet() );
        address.setCity( addressEntity.getCity() );
        address.setState( addressEntity.getState() );

        return address;
    }
}
