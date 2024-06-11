package org.example.bankingservice.application.port.out;

import org.example.bankingservice.adapter.out.external.bank.BankAccount;
import org.example.bankingservice.adapter.out.external.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {

    BankAccount getBankAccountInfo(GetBankAccountRequest bankAccountRequest);
}
