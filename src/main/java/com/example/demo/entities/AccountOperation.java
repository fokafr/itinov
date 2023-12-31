package com.example.demo.entities;

import com.example.demo.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private Date operationDate;
    private double operationAmont;

    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    @ManyToOne
    private BankAccount bankAccount;
}
