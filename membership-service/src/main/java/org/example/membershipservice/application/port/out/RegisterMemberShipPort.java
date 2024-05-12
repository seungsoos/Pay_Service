package org.example.membershipservice.application.port.out;

import org.example.membershipservice.adapter.out.persistence.MemberShipEntity;
import org.example.membershipservice.domain.Membership;

public interface RegisterMemberShipPort {

    MemberShipEntity createMemberShip(
            Membership.MemberShipName memberShipName,
            Membership.MemberShipEmail memberShipEmail,
            Membership.MemberShipAddress memberShipAddress,
            Membership.MemberShipIsValid memberShipIsValid,
            Membership.MemberShipIsCorp memberShipIsCorp);
}
