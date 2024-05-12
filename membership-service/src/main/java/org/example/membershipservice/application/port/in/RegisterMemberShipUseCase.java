package org.example.membershipservice.application.port.in;

import org.example.membershipservice.domain.Membership;


public interface RegisterMemberShipUseCase {

    Membership registerMemberShip(RegisterMemberShipCommand command);
}
