package org.example.membershipservice.adapter.in.web;


import lombok.RequiredArgsConstructor;
import org.example.common.WebAdapter;
import org.example.membershipservice.application.port.in.ModifyMemberShipCommand;
import org.example.membershipservice.application.port.in.ModifyMemberShipUseCase;
import org.example.membershipservice.domain.Membership;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMemberShipController {

    private final ModifyMemberShipUseCase modifyMemberShipUseCase;
    @PostMapping("/membership/modify/{membershipId}")
    public ResponseEntity<Membership> modifyMemberShip(@RequestBody ModifyMemberShipRequest request) {

        ModifyMemberShipCommand command = ModifyMemberShipCommand.builder()
                .memberShipId(request.getMembershipId())
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .isValid(request.isValid())
                .isCorp(request.isCorp())
                .build();

        return ResponseEntity.ok(modifyMemberShipUseCase.modifyMembership(command));
    }
}
