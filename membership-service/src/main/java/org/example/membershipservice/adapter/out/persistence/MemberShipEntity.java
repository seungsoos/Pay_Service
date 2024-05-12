package org.example.membershipservice.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "membership")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberShipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberShipId;

    private String name;

    private String address;

    private String email;

    private boolean isValid;

    private boolean isCorp;

    public MemberShipEntity(String name, String address, String email, boolean isValid, boolean isCorp) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;
    }
}
