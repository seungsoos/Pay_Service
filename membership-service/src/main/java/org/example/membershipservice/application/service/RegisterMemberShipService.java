package org.example.membershipservice.application.service;

import lombok.RequiredArgsConstructor;
import org.example.membershipservice.adapter.out.persistence.MemberShipEntity;
import org.example.membershipservice.adapter.out.persistence.MemberShipMapper;
import org.example.membershipservice.application.port.in.RegisterMemberShipCommand;
import org.example.membershipservice.application.port.in.RegisterMemberShipUseCase;
import org.example.membershipservice.application.port.out.RegisterMemberShipPort;
import org.example.membershipservice.common.UseCase;
import org.example.membershipservice.domain.Membership;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterMemberShipService implements RegisterMemberShipUseCase {

    private final RegisterMemberShipPort registerMemberShipPort;
    private final MemberShipMapper memberShipMapper;

    @Override
    public Membership registerMemberShip(RegisterMemberShipCommand command) {
        MemberShipEntity memberShipEntity = registerMemberShipPort.createMemberShip(
                new Membership.MemberShipName(command.getName()),
                new Membership.MemberShipEmail(command.getEmail()),
                new Membership.MemberShipAddress(command.getAddress()),
                new Membership.MemberShipIsValid(command.isValid()),
                new Membership.MemberShipIsCorp(command.isCorp()));

        return memberShipMapper.mapToDomainEntity(memberShipEntity);
    }
}
