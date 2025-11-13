package com.chris.hexagonal.config.usercase;

import com.chris.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.chris.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.chris.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import com.chris.hexagonal.application.core.usecase.UpdateCustomerUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCutomerConfig {

    @Bean
    public UpdateCustomerUserCase updateCustomerUserCase(FindCustomerByIdUserCase findCustomerByIdUserCase,
                                                        FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                        UpdateCustomerAdapter updateCustomerAdapter) {

        return new UpdateCustomerUserCase(findCustomerByIdUserCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}
