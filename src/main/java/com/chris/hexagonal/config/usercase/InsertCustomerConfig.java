package com.chris.hexagonal.config.usercase;

import com.chris.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.chris.hexagonal.adapters.out.InsertCustomerAdapter;
import com.chris.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.chris.hexagonal.application.core.usecase.InsertCustomerUsercase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
    @Bean
    public InsertCustomerUsercase insertCustomerUsercase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                         InsertCustomerAdapter insertCustomerAdapter,
                                                         SendCpfValidationAdapter sendCpfValidationAdapter) {
        return new InsertCustomerUsercase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}
