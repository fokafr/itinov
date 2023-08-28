package com.example.demo.entities;

import com.example.demo.enums.operationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private Date operationDate;
    private double operationAmont;
    private com.example.demo.enums.operationType operationType;

    @ManyToOne
    private BankAccount bankAccount;
}
