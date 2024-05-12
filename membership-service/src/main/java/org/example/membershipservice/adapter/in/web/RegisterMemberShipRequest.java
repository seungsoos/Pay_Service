package org.example.membershipservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterMemberShipRequest {

    private String name;
    private String address;
    private String email;
    private boolean isCorp;
}
