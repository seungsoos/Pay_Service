package org.example.membershipservice.application.port.in;

import org.example.membershipservice.domain.Membership;


public interface FindMemberShipUseCase {

    Membership findMembership(FindMemberShipCommand command);
}
