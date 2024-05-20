package org.example.membershipservice.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.example.common.PersistenceAdapter;
import org.example.membershipservice.application.port.out.FindMemberShipPort;
import org.example.membershipservice.application.port.out.ModifyMemberShipPort;
import org.example.membershipservice.application.port.out.RegisterMemberShipPort;
import org.example.membershipservice.domain.Membership;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberShipPersistenceAdapter implements RegisterMemberShipPort, FindMemberShipPort, ModifyMemberShipPort {

    private final MemberShipRepository memberShipRepository;

    @Override
    public MemberShipEntity createMemberShip(Membership.MemberShipName memberShipName, Membership.MemberShipEmail memberShipEmail, Membership.MemberShipAddress memberShipAddress, Membership.MemberShipIsValid memberShipIsValid, Membership.MemberShipIsCorp memberShipIsCorp) {
        return memberShipRepository.save(
                new MemberShipEntity(
                        memberShipName.getNameValue(),
                        memberShipAddress.getAddressValue(),
                        memberShipEmail.getEmailValue(),
                        memberShipIsValid.isValidValue(),
                        memberShipIsCorp.isCorpValue())
        );
    }

    @Override
    public MemberShipEntity findMembership(Membership.MemberShipId memberShipId) {
        return memberShipRepository.findById(Long.valueOf(memberShipId.getMemberMoneyId()))
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public MemberShipEntity ModifyMemberShip(Membership.MemberShipId memberShipId, Membership.MemberShipName memberShipName, Membership.MemberShipEmail memberShipEmail, Membership.MemberShipAddress memberShipAddress, Membership.MemberShipIsValid memberShipIsValid, Membership.MemberShipIsCorp memberShipIsCorp) {
        MemberShipEntity memberShipEntity = memberShipRepository.findById(Long.valueOf(memberShipId.getMemberMoneyId()))
                .orElseThrow(RuntimeException::new);
        memberShipEntity.setName(memberShipName.getNameValue());
        memberShipEntity.setEmail(memberShipEmail.getEmailValue());
        memberShipEntity.setAddress(memberShipAddress.getAddressValue());
        memberShipEntity.setCorp(memberShipIsCorp.isCorpValue());
        memberShipEntity.setValid(memberShipIsValid.isValidValue());
        return memberShipEntity;
    }
}
