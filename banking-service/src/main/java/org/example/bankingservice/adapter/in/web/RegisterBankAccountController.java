package org.example.bankingservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.bankingservice.application.port.in.RegisterBankAccountCommand;
import org.example.bankingservice.application.port.in.RegisterBankAccountUseCase;
import org.example.bankingservice.domain.RegisteredBankAccount;
import org.example.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping("/banking/account/register")
    public RegisteredBankAccount registerMemberShip(@RequestBody RegisterBankAccountRequest request) {
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(request.getMembershipId())
                .bankName(request.getBankName())
                .bankAccountNumber(request.getBankAccountNumber())
                .linkStatusIsValid(request.isValid())
                .build();
        RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);

        if (registeredBankAccount == null) {
            //TODO 에러 핸들링 필요
            return null;
        }
        return registeredBankAccount;
    }
}
