package com.chris.hexagonal.application.ports.out;

import com.chris.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutPutPort {

    Address find(String zipCode);
}
