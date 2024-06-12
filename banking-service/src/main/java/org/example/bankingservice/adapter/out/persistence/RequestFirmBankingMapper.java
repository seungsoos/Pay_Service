package org.example.bankingservice.adapter.out.persistence;

import org.example.bankingservice.domain.RequestFirmBanking;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RequestFirmBankingMapper {

    public RequestFirmBanking mapToDomainEntity(RequestFirmBankingEntity requestFirmBankingEntity, UUID uuid) {
        return RequestFirmBanking.generateFirmBankingRequest(
                new RequestFirmBanking.FirmBankingRequestId(requestFirmBankingEntity.getRequestFirmBankingId()+""),
                new RequestFirmBanking.FromBankName(requestFirmBankingEntity.getFromBankName()),
                new RequestFirmBanking.FromBankAccountNumber(requestFirmBankingEntity.getFromBankAccountNumber()),
                new RequestFirmBanking.ToBankName(requestFirmBankingEntity.getToBankName()),
                new RequestFirmBanking.ToBankAccountNumber(requestFirmBankingEntity.getToBankAccountNumber()),
                new RequestFirmBanking.MoneyAmount(requestFirmBankingEntity.getMoneyAmount()),
                new RequestFirmBanking.FirmBankingStatus(requestFirmBankingEntity.getFirmBankingStatus()),
                uuid
        );
    }

}
