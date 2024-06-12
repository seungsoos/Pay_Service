package org.example.bankingservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.bankingservice.application.port.in.FirmBankingRequestCommand;
import org.example.bankingservice.application.port.in.RequestFirmBankingUseCase;
import org.example.bankingservice.domain.RequestFirmBanking;
import org.example.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {

    private final RequestFirmBankingUseCase requestFirmBankingUseCase;

    @PostMapping("/firm/banking")
    public RequestFirmBanking registerMemberShip(@RequestBody RequestFirmBankingRequest request) {
        FirmBankingRequestCommand command = FirmBankingRequestCommand.builder()
                .fromBankName(request.getFromBankName())
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .moneyAmount(request.getMoneyAmount())
                .build();
        RequestFirmBanking firmBankingRequest = requestFirmBankingUseCase.requestFirmBanking(command);


        return firmBankingRequest;
    }
}
