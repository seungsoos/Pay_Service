package org.example.bankingservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.example.bankingservice.application.port.out.RequestFirmBankingPort;
import org.example.bankingservice.domain.RequestFirmBanking;
import org.example.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class RequestFirmBankingPersistenceAdapter implements RequestFirmBankingPort {

    private final RequestFirmBankingRepository requestFirmBankingRepository;

    @Override
    public RequestFirmBankingEntity requestFirmBanking(RequestFirmBanking.FromBankName fromBankName, RequestFirmBanking.FromBankAccountNumber fromBankAccountNumber, RequestFirmBanking.ToBankName toBankName, RequestFirmBanking.ToBankAccountNumber toBankAccountNumber, RequestFirmBanking.MoneyAmount moneyAmount, RequestFirmBanking.FirmBankingStatus firmBankingStatus) {
        return requestFirmBankingRepository.save(
                new RequestFirmBankingEntity(
                        fromBankName.getFromBankName(),
                        fromBankAccountNumber.getFromBankAccountNumber(),
                        toBankName.getToBankName(),
                        toBankAccountNumber.getToBankAccountNumber(),
                        moneyAmount.getMoneyAmount(),
                        firmBankingStatus.getFirmBankingStatus()
                )
        );

    }

}
