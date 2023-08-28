package com.example.demo.entities;

import com.example.demo.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {

    @Id //nous allons nous même generer l'id
    private String id_account;
    private double balance;
    private Date creationDate;

    @ManyToOne
    private Costumer costumer;

    @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> operations;

    private AccountStatus status;

}
