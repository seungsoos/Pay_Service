package org.example.membershipservice.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Membership {

    private final String memberMoneyId;
	private final String name;
	private final String email;
	private final String address;
	private final boolean isValid;
	private final boolean isCorp;


    public static Membership generateMember(MemberShipId memberShipId,
                                            MemberShipName memberShipName,
                                            MemberShipEmail memberShipEmail,
                                            MemberShipAddress memberShipAddress,
                                            MemberShipIsValid memberShipIsValid,
                                            MemberShipIsCorp memberShipIsCorp
                                            ) {
        return new Membership(memberShipId.memberMoneyId,
                memberShipName.nameValue,
                memberShipEmail.emailValue,
                memberShipAddress.addressValue,
                memberShipIsValid.isValidValue,
                memberShipIsCorp.isCorpValue);

    }
    @Value
    public static class MemberShipId {
        public MemberShipId(String value) {
            this.memberMoneyId = value;
        }
        String memberMoneyId ;
    }
    @Value
    public static class MemberShipName {
        public MemberShipName(String value) {
            this.nameValue = value;
        }
        String nameValue;
    }

    @Value
    public static class MemberShipEmail {
        public MemberShipEmail(String value) {
            this.emailValue = value;
        }
        String emailValue;
    }

    @Value
    public static class MemberShipAddress {
        public MemberShipAddress(String value) {
            this.addressValue = value;
        }
        String addressValue;
    }

    @Value
    public static class MemberShipIsValid {
        public MemberShipIsValid(boolean value) {
            this.isValidValue = value;
        }
        boolean isValidValue;
    }

    @Value
    public static class MemberShipIsCorp {
        public MemberShipIsCorp(boolean value) {
            this.isCorpValue = value;
        }
        boolean isCorpValue;
    }

}
