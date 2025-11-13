package com.chris.hexagonal.config.usercase;

import com.chris.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.chris.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {
    @Bean
    public FindCustomerByIdUserCase findCustomerByIdUserCase(FindCustomerByIdAdapter findAddressByZipCodeAdapter) {
        return new FindCustomerByIdUserCase(findAddressByZipCodeAdapter);
    }
}
