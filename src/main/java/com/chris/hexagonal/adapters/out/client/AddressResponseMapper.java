package com.chris.hexagonal.adapters.out.client;

import com.chris.hexagonal.adapters.out.client.response.AddressResponse;
import com.chris.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddres(AddressResponse addressResponse);

}
