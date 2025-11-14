package com.chris.hexagonal.adapters.out.client;

import com.chris.hexagonal.adapters.out.client.response.AddressResponse;
import com.chris.hexagonal.application.core.domain.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-14T15:14:59-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class AddressResponseMapperImpl implements AddressResponseMapper {

    @Override
    public Address toAddres(AddressResponse addressResponse) {
        if ( addressResponse == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreet( addressResponse.getStreet() );
        address.setCity( addressResponse.getCity() );
        address.setState( addressResponse.getState() );

        return address;
    }
}
