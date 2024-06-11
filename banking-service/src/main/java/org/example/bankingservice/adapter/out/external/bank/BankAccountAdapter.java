package org.example.bankingservice.adapter.out.external.bank;

import lombok.RequiredArgsConstructor;
import org.example.bankingservice.adapter.out.persistence.RegisterdBankAccountRepository;
import org.example.bankingservice.application.port.out.RequestBankAccountInfoPort;
import org.example.common.ExternalSystemAdapter;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    private final RegisterdBankAccountRepository registerdBankAccountRepository;

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest bankAccountRequest) {
        return new BankAccount(bankAccountRequest.getBankName(), bankAccountRequest.getBankAccountNumber(), true);
    }
}
