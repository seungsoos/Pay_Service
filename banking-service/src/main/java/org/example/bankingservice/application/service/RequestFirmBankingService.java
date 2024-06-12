package org.example.bankingservice.application.service;

import lombok.RequiredArgsConstructor;
import org.example.bankingservice.adapter.out.external.bank.ExternalFirmBankingRequest;
import org.example.bankingservice.adapter.out.external.bank.FirmBankingResult;
import org.example.bankingservice.adapter.out.persistence.RequestFirmBankingEntity;
import org.example.bankingservice.adapter.out.persistence.RequestFirmBankingMapper;
import org.example.bankingservice.application.port.in.FirmBankingRequestCommand;
import org.example.bankingservice.application.port.in.RequestFirmBankingUseCase;
import org.example.bankingservice.application.port.out.RequestExternalFirmBankingPort;
import org.example.bankingservice.application.port.out.RequestFirmBankingPort;
import org.example.bankingservice.domain.RequestFirmBanking;
import org.example.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@UseCase
@Transactional
@RequiredArgsConstructor
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

    private final RequestFirmBankingPort requestFirmBankingPort;
    private final RequestExternalFirmBankingPort requestExternalFirmBankingPort;
    private final RequestFirmBankingMapper requestFirmBankingMapper;

    @Override
    public RequestFirmBanking requestFirmBanking(FirmBankingRequestCommand command) {

        // 요청에 대해 정보를 먼저 저장
        RequestFirmBankingEntity requestFirmBankingEntity = requestFirmBankingPort.requestFirmBanking(
                new RequestFirmBanking.FromBankName(command.getFromBankName()),
                new RequestFirmBanking.FromBankAccountNumber(command.getFromBankAccountNumber()),
                new RequestFirmBanking.ToBankName(command.getToBankName()),
                new RequestFirmBanking.ToBankAccountNumber(command.getToBankAccountNumber()),
                new RequestFirmBanking.MoneyAmount(command.getMoneyAmount()),
                new RequestFirmBanking.FirmBankingStatus(0)
        );

        // 외부은행 펌뱅킹 요청 결과 반환
        FirmBankingResult result = requestExternalFirmBankingPort.requestExternalFirmBaning(
                new ExternalFirmBankingRequest(
                        command.getFromBankName(),
                        command.getFromBankAccountNumber(),
                        command.getToBankName(),
                        command.getToBankAccountNumber())
        );
        UUID uuid = UUID.randomUUID();
        requestFirmBankingEntity.setUuid(uuid.toString());
        // 성공
        if (result.getResultCode() == 0) {
            requestFirmBankingEntity.setFirmBankingStatus(1);
        } else {
            // 실패
            requestFirmBankingEntity.setFirmBankingStatus(2);
        }

        return requestFirmBankingMapper.mapToDomainEntity(requestFirmBankingEntity, uuid);
    }
}
