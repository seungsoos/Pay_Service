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
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {

    @NotNull
    private String membershipId;
    @NotNull
    private String bankName;
    @NotNull
    private String bankAccountNumber;
    @AssertTrue
    private boolean linkStatusIsValid;


    public RegisterBankAccountCommand(String membershipId, String bankName, String bankAccountNumber, boolean linkStatusIsValid) {
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkStatusIsValid = linkStatusIsValid;
        this.validateSelf();
    }

}
