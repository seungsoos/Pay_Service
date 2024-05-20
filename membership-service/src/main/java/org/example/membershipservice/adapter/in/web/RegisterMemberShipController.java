package org.example.membershipservice.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.common.WebAdapter;
import org.example.membershipservice.application.port.in.RegisterMemberShipCommand;
import org.example.membershipservice.application.port.in.RegisterMemberShipUseCase;
import org.example.membershipservice.domain.Membership;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMemberShipController {

    private final RegisterMemberShipUseCase registerMemberShipUseCase;

    @PostMapping("/membership/register")
    public Membership registerMemberShip(@RequestBody RegisterMemberShipRequest request) {
        RegisterMemberShipCommand command = RegisterMemberShipCommand.builder()
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        return registerMemberShipUseCase.registerMemberShip(command);
    }
}
