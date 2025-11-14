package com.chris.hexagonal.adapters.in.Mapper;

import com.chris.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.chris.hexagonal.application.core.domain.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-14T15:15:00-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class CustomerMessageMapperImpl implements CustomerMessageMapper {

    @Override
    public Customer toCustomer(CustomerMessage customerMessage) {
        if ( customerMessage == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerMessage.getId() );
        customer.setName( customerMessage.getName() );
        customer.setCpf( customerMessage.getCpf() );

        return customer;
    }
}
