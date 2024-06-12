package org.example.bankingservice.application.port.out;

import org.example.bankingservice.adapter.out.persistence.RegisterdBankAccountEntity;
import org.example.bankingservice.adapter.out.persistence.RequestFirmBankingEntity;
import org.example.bankingservice.domain.RegisteredBankAccount;
import org.example.bankingservice.domain.RequestFirmBanking;

public interface RequestFirmBankingPort {

    RequestFirmBankingEntity requestFirmBanking(
            RequestFirmBanking.FromBankName fromBankName,
            RequestFirmBanking.FromBankAccountNumber fromBankAccountNumber,
            RequestFirmBanking.ToBankName toBankName,
            RequestFirmBanking.ToBankAccountNumber toBankAccountNumber,
            RequestFirmBanking.MoneyAmount moneyAmount,
            RequestFirmBanking.FirmBankingStatus firmBankingStatus
            );
}
