package org.example.bankingservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.example.bankingservice.application.port.out.RegisterBankAccountPort;
import org.example.bankingservice.domain.RegisteredBankAccount;
import org.example.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisterdBankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final RegisterdBankAccountRepository registerdBankAccountRepository;

    @Override
    public RegisterdBankAccountEntity createRegisterdBankAccount(RegisteredBankAccount.RegisteredBankAccountId registeredBankAccountId, RegisteredBankAccount.MembershipId membershipId, RegisteredBankAccount.BankName bankName, RegisteredBankAccount.BankAccountNumber bankAccountNumber, RegisteredBankAccount.LinkStatusIsValid linkStatusIsValid) {
        return registerdBankAccountRepository.save(
                new RegisterdBankAccountEntity(
                        membershipId.getMembershipId(),
                        bankName.getBankName(),
                        bankAccountNumber.getBankAccountNumber(),
                        linkStatusIsValid.isLinkStatusIsValid()
                ));
    }
}
