package com.example.demo.entities;

import com.example.demo.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_COMPTE", length = 20, discriminatorType = DiscriminatorType.STRING)
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

    @Enumerated(EnumType.STRING) //les enum sont stockés sous des strings
    private AccountStatus status;

}
