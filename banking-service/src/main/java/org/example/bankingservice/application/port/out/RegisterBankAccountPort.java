package org.example.bankingservice.application.port.out;

import org.example.bankingservice.adapter.out.persistence.RegisterdBankAccountEntity;
import org.example.bankingservice.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisterdBankAccountEntity createRegisterdBankAccount(
            RegisteredBankAccount.RegisteredBankAccountId registeredBankAccountId,
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkStatusIsValid linkStatusIsValid);
}
