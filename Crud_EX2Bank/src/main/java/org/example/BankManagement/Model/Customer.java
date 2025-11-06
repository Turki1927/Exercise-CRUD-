package org.example.BankManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private int ID;
    private String  userName;
    private double balance;


}
