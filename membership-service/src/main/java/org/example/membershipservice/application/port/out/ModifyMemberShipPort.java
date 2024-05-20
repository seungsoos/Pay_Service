package org.example.membershipservice.application.port.out;

import org.example.membershipservice.adapter.out.persistence.MemberShipEntity;
import org.example.membershipservice.domain.Membership;

public interface ModifyMemberShipPort {

    MemberShipEntity ModifyMemberShip(
            Membership.MemberShipId memberShipId,
            Membership.MemberShipName memberShipName,
            Membership.MemberShipEmail memberShipEmail,
            Membership.MemberShipAddress memberShipAddress,
            Membership.MemberShipIsValid memberShipIsValid,
            Membership.MemberShipIsCorp memberShipIsCorp);
}
