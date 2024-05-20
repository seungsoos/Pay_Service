package org.example.membershipservice.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.SelfValidating;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ModifyMemberShipCommand extends SelfValidating<ModifyMemberShipCommand> {

    @NotNull
    private String memberShipId;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private String email;
    @NotNull
    private boolean isValid;
    @NotNull
    private boolean isCorp;

    public ModifyMemberShipCommand(String memberShipId, String name, String address, String email, boolean isValid, boolean isCorp) {
        this.memberShipId = memberShipId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;
        this.validateSelf();
    }

}
