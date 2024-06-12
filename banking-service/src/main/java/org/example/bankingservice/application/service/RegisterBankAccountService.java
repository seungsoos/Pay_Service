package org.example.bankingservice.application.service;

import lombok.RequiredArgsConstructor;
import org.example.bankingservice.adapter.out.external.bank.BankAccount;
import org.example.bankingservice.adapter.out.external.bank.GetBankAccountRequest;
import org.example.bankingservice.adapter.out.persistence.RegisterdBankAccountEntity;
import org.example.bankingservice.adapter.out.persistence.RegisterdBankAccountMapper;
import org.example.bankingservice.application.port.in.RegisterBankAccountCommand;
import org.example.bankingservice.application.port.in.RegisterBankAccountUseCase;
import org.example.bankingservice.application.port.out.RegisterBankAccountPort;
import org.example.bankingservice.application.port.out.RequestBankAccountInfoPort;
import org.example.bankingservice.domain.RegisteredBankAccount;
import org.example.common.UseCase;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;
    private final RegisterdBankAccountMapper registerdBankAccountMapper;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        //command.getMembershipId
        // 정상 회원 여부를 Membership-service 에 요청확인해야함.

        // 1. 등록된 계좌인지 확인
        BankAccount bankAccountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
        boolean accountIsValid = bankAccountInfo.isValid();

        // 유효한 계좌로 정보 저장
        if (accountIsValid) {
            RegisterdBankAccountEntity registerdBankAccount = registerBankAccountPort.createRegisterdBankAccount(
                    new RegisteredBankAccount.RegisteredBankAccountId(command.getBankAccountNumber()),
                    new RegisteredBankAccount.MembershipId(command.getMembershipId()),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkStatusIsValid(command.isLinkStatusIsValid())
            );

            return registerdBankAccountMapper.mapToDomainEntity(registerdBankAccount);
        } else {
            return null;
        }

    }
}
