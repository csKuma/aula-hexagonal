package com.chris.hexagonal.config.usercase;

import com.chris.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.chris.hexagonal.application.core.usecase.DeleteCustomerByIdByIdUserCase;
import com.chris.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdByIdUserCase deleteCustomerByIdByIdUserCase(FindCustomerByIdUserCase findCustomerByIdUserCase,
                                                                         DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
        return new DeleteCustomerByIdByIdUserCase(findCustomerByIdUserCase, deleteCustomerByIdAdapter);
    }
}
