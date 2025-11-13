package com.chris.hexagonal.application.ports.out;

public interface SendCpfValidationOutPutPort {

    void send(String cpf);
}
