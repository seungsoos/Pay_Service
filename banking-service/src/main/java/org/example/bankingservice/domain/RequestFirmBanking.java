package org.example.bankingservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RequestFirmBanking {

    private String firmBankingRequestId;
    private String fromBankName;
    private String fromBankAccountNumber;
    private String toBankName;
    private String toBankAccountNumber;
    private int moneyAmount;
    private int firmBankingStatus;   // 0 : 요청, 1: 완료, 2 : 실패
    private UUID uuid;

    public static RequestFirmBanking generateFirmBankingRequest(
            RequestFirmBanking.FirmBankingRequestId firmBankingRequestId,
            RequestFirmBanking.FromBankName fromBankName,
            RequestFirmBanking.FromBankAccountNumber fromBankAccountNumber,
            RequestFirmBanking.ToBankName toBankName,
            RequestFirmBanking.ToBankAccountNumber toBankAccountNumber,
            RequestFirmBanking.MoneyAmount moneyAmount,
            RequestFirmBanking.FirmBankingStatus firmBankingStatus,
            UUID uuid
            ) {
        return new RequestFirmBanking(
                firmBankingRequestId.firmBankingRequestId,
                fromBankName.fromBankName,
                fromBankAccountNumber.fromBankAccountNumber,
                toBankName.toBankName,
                toBankAccountNumber.toBankAccountNumber,
                moneyAmount.moneyAmount,
                firmBankingStatus.firmBankingStatus,
                UUID.randomUUID()
        );


    }
    @Value
    public static class FirmBankingRequestId {
        public FirmBankingRequestId(String value) {
            this.firmBankingRequestId = value;
        }
        String firmBankingRequestId ;
    }

    @Value
    public static class FromBankName {
        public FromBankName(String value) {
            this.fromBankName = value;
        }
        String fromBankName ;
    }

    @Value
    public static class FromBankAccountNumber {
        public FromBankAccountNumber(String value) {
            this.fromBankAccountNumber = value;
        }
        String fromBankAccountNumber ;
    }

    @Value
    public static class ToBankName {
        public ToBankName(String value) {
            this.toBankName = value;
        }
        String toBankName ;
    }

    @Value
    public static class ToBankAccountNumber {
        public ToBankAccountNumber(String value) {
            this.toBankAccountNumber = value;
        }
        String toBankAccountNumber ;
    }

    @Value
    public static class MoneyAmount {
        public MoneyAmount(int value) {
            this.moneyAmount = value;
        }
        int moneyAmount ;
    }

    @Value
    public static class FirmBankingStatus {
        public FirmBankingStatus(int value) {
            this.firmBankingStatus = value;
        }
        int firmBankingStatus ;
    }

}
