package com.chris.hexagonal.adapters.out.repository.mapper;

import com.chris.hexagonal.adapters.out.repository.CustomerRepository;
import com.chris.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.chris.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity entity);
}
