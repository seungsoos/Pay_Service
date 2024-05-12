package org.example.membershipservice.application.port.out;

import org.example.membershipservice.adapter.out.persistence.MemberShipEntity;
import org.example.membershipservice.domain.Membership;

public interface FindMemberShipPort {

    MemberShipEntity findMembership(Membership.MemberShipId memberShipId);
}
