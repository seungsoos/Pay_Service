package org.example.bankingservice.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Registerd_bank_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterdBankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registeredBankAccountId;

    private String membershipId;

    private String bankName;

    private String bankAccountNumber;

    private boolean linkStatusIsValid;

    public RegisterdBankAccountEntity(String membershipId, String bankName, String bankAccountNumber, boolean linkStatusIsValid) {
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkStatusIsValid = linkStatusIsValid;
    }
}
