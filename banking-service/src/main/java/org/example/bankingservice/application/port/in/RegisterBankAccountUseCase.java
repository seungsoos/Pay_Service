package org.example.bankingservice.application.port.in;

import org.example.bankingservice.domain.RegisteredBankAccount;


public interface RegisterBankAccountUseCase {

    RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
