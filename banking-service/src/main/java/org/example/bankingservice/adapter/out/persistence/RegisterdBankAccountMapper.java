package org.example.bankingservice.adapter.out.persistence;

import org.example.bankingservice.domain.RegisteredBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisterdBankAccountMapper {

    public RegisteredBankAccount mapToDomainEntity(RegisterdBankAccountEntity registerdBankAccountEntity) {
        return RegisteredBankAccount.generateRegisterBankAccount(
                new RegisteredBankAccount.RegisteredBankAccountId(registerdBankAccountEntity.getRegisteredBankAccountId()+""),
                new RegisteredBankAccount.MembershipId(registerdBankAccountEntity.getMembershipId()),
                new RegisteredBankAccount.BankName(registerdBankAccountEntity.getBankName()),
                new RegisteredBankAccount.BankAccountNumber(registerdBankAccountEntity.getBankAccountNumber()),
                new RegisteredBankAccount.LinkStatusIsValid(registerdBankAccountEntity.isLinkStatusIsValid())
        );
    }

}
