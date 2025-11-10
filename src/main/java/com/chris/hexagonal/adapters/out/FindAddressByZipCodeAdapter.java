package com.chris.hexagonal.adapters.out;

import com.chris.hexagonal.adapters.out.client.AddressResponseMapper;
import com.chris.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.chris.hexagonal.application.core.domain.Address;
import com.chris.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutPutPort {
    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddres(addressResponse);
    }
}
