package org.example.bankingservice.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterBankAccountRequest {

    private String membershipId;
    private String bankName;
    private String bankAccountNumber;
    private boolean isValid;
}
