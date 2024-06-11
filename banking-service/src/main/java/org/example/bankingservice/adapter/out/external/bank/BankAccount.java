package org.example.bankingservice.adapter.out.external.bank;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {

    private String bankName;
    private String bankAccountNumber;
    private boolean isValid;
}
