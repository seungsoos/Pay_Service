package org.example.bankingservice.adapter.out.external.bank;

import lombok.RequiredArgsConstructor;
import org.example.bankingservice.adapter.out.persistence.RegisterdBankAccountRepository;
import org.example.bankingservice.application.port.out.RequestBankAccountInfoPort;
import org.example.bankingservice.application.port.out.RequestExternalFirmBankingPort;
import org.example.common.ExternalSystemAdapter;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort, RequestExternalFirmBankingPort {

    private final RegisterdBankAccountRepository registerdBankAccountRepository;

    @Override
    public BankAccount getBankAccountInfo(GetBankAccountRequest bankAccountRequest) {
        return new BankAccount(bankAccountRequest.getBankName(), bankAccountRequest.getBankAccountNumber(), true);
    }

    @Override
    public FirmBankingResult requestExternalFirmBaning(ExternalFirmBankingRequest externalFirmBankingRequest) {

        // 실제 외부 은행에 http 통신으로 펌뱅킹을 요청하고 결과를 반환받아야한다.
        return new FirmBankingResult(0);
    }
}
