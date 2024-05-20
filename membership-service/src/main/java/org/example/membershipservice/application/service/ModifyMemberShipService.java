package org.example.membershipservice.application.service;

import lombok.RequiredArgsConstructor;
import org.example.common.UseCase;
import org.example.membershipservice.adapter.out.persistence.MemberShipEntity;
import org.example.membershipservice.adapter.out.persistence.MemberShipMapper;
import org.example.membershipservice.application.port.in.ModifyMemberShipCommand;
import org.example.membershipservice.application.port.in.ModifyMemberShipUseCase;
import org.example.membershipservice.application.port.out.ModifyMemberShipPort;
import org.example.membershipservice.domain.Membership;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@Transactional
@RequiredArgsConstructor
public class ModifyMemberShipService implements ModifyMemberShipUseCase {

    private final ModifyMemberShipPort modifyMemberShipPort;
    private final MemberShipMapper memberShipMapper;

    @Override
    public Membership modifyMembership(ModifyMemberShipCommand command) {
        MemberShipEntity memberShipEntity = modifyMemberShipPort.ModifyMemberShip(
                new Membership.MemberShipId(command.getMemberShipId()),
                new Membership.MemberShipName(command.getName()),
                new Membership.MemberShipEmail(command.getEmail()),
                new Membership.MemberShipAddress(command.getAddress()),
                new Membership.MemberShipIsValid(command.isValid()),
                new Membership.MemberShipIsCorp(command.isCorp()));

        return memberShipMapper.mapToDomainEntity(memberShipEntity);
    }
}
