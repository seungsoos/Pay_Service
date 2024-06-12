package org.example.bankingservice.application.port.in;

import org.example.bankingservice.domain.RequestFirmBanking;


public interface RequestFirmBankingUseCase {

    RequestFirmBanking requestFirmBanking(FirmBankingRequestCommand command);
}
