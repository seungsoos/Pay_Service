package org.example.membershipservice.adapter.out.persistence;

import org.example.membershipservice.domain.Membership;
import org.springframework.stereotype.Component;

@Component
public class MemberShipMapper {

    public Membership mapToDomainEntity(MemberShipEntity memberShipEntity) {
        return Membership.generateMember(
                new Membership.MemberShipId(memberShipEntity.getMemberShipId()+""),
                new Membership.MemberShipName(memberShipEntity.getName()),
                new Membership.MemberShipEmail(memberShipEntity.getEmail()),
                new Membership.MemberShipAddress(memberShipEntity.getAddress()),
                new Membership.MemberShipIsValid(memberShipEntity.isValid()),
                new Membership.MemberShipIsCorp(memberShipEntity.isCorp())
        );
    }

}
