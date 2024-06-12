package org.example.bankingservice.application.port.in;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.SelfValidating;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FirmBankingRequestCommand extends SelfValidating<FirmBankingRequestCommand> {

    @NotNull
    private String fromBankName;
    @NotNull
    private String fromBankAccountNumber;
    @NotNull
    private String toBankName;
    @NotNull
    private String toBankAccountNumber;
    @NotNull
    private int moneyAmount;

    public FirmBankingRequestCommand(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, int moneyAmount) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
    }
}
