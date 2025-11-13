package com.chris.hexagonal.adapters.in.controller.mapper;

import com.chris.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.chris.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.chris.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "Spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "idValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);


    CustomerResponse toCustomerResponse(Customer customer);
}
