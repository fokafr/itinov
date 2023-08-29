package com.example.demo.services;

import com.example.demo.entities.BankAccount;
import com.example.demo.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BankService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public  void consulterCompte(){
        Optional<BankAccount> bankAccount = bankAccountRepository.findById("\tb4047db2-c76a-41b8-a290-7a083e39b3a7");
    }
}
