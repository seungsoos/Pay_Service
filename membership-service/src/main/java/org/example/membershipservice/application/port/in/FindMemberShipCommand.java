package org.example.membershipservice.application.port.in;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.common.SelfValidating;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FindMemberShipCommand extends SelfValidating<FindMemberShipCommand> {

    @NotNull
    private String memberShipId;

}
