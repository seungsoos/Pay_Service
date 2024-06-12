package org.example.bankingservice.application.port.out;

import org.example.bankingservice.adapter.out.external.bank.ExternalFirmBankingRequest;
import org.example.bankingservice.adapter.out.external.bank.FirmBankingResult;

public interface RequestExternalFirmBankingPort {

    FirmBankingResult requestExternalFirmBaning(ExternalFirmBankingRequest externalFirmBankingRequest);
}
