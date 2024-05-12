package org.example.membershipservice.application.port.in;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.membershipservice.common.SelfValidating;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterMemberShipCommand extends SelfValidating<RegisterMemberShipCommand> {

    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String email;
    @AssertTrue
    private boolean isValid;
    @NotNull
    private boolean isCorp;

    public RegisterMemberShipCommand(String name, String address, String email, boolean isValid, boolean isCorp) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;
        this.validateSelf();
    }
}
