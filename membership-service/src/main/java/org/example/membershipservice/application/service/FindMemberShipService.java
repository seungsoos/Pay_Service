package org.example.membershipservice.application.service;

import lombok.RequiredArgsConstructor;
import org.example.membershipservice.adapter.out.persistence.MemberShipEntity;
import org.example.membershipservice.adapter.out.persistence.MemberShipMapper;
import org.example.membershipservice.application.port.in.FindMemberShipCommand;
import org.example.membershipservice.application.port.in.FindMemberShipUseCase;
import org.example.membershipservice.application.port.out.FindMemberShipPort;
import org.example.membershipservice.common.UseCase;
import org.example.membershipservice.domain.Membership;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@Transactional
@RequiredArgsConstructor
public class FindMemberShipService implements FindMemberShipUseCase {

    private final FindMemberShipPort findMemberShipPort;
    private final MemberShipMapper memberShipMapper;

    @Override
    public Membership findMembership(FindMemberShipCommand command) {
        MemberShipEntity membershipEntity = findMemberShipPort.findMembership(new Membership.MemberShipId(command.getMemberShipId()));
        return memberShipMapper.mapToDomainEntity(membershipEntity);
    }
}
