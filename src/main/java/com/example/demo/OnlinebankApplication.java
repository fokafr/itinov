package com.example.demo;

import com.example.demo.entities.AccountOperation;
import com.example.demo.entities.Costumer;
import com.example.demo.entities.CurrentAccount;
import com.example.demo.entities.SavingAccount;
import com.example.demo.enums.AccountStatus;
import com.example.demo.enums.OperationType;
import com.example.demo.repositories.AccountOperationRepository;
import com.example.demo.repositories.BankAccountRepository;
import com.example.demo.repositories.CostumerRepository;
import com.example.demo.services.BankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class OnlinebankApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinebankApplication.class, args);
	}


	CommandLineRunner start(BankService bankService){
		return args -> {
		   bankService.consulterCompte();
		};
	}



	//@Bean
	CommandLineRunner start(CostumerRepository costumerRepository,
							BankAccountRepository bankAccountRepository,
							AccountOperationRepository accountOperationRepository){
		return args -> {
			Stream.of("aymar","lagarde","foka").forEach(name ->
			{
				Costumer costumer = new Costumer();
				costumer.setName(name);
				costumer.setEmail(name+"@yahoo.fr");
				costumerRepository.save(costumer);
			});
			costumerRepository.findAll().forEach(costumer -> {
						CurrentAccount currentAccount = new CurrentAccount();
						currentAccount.setId_account(UUID.randomUUID().toString());
						currentAccount.setBalance(Math.random()*100000);
						currentAccount.setCreationDate(new Date());
						currentAccount.setStatus(AccountStatus.CREATED);
						currentAccount.setCostumer(costumer);
						currentAccount.setAutorisationDecouvert(10000);
						bankAccountRepository.save(currentAccount);

						SavingAccount savedAccount = new SavingAccount();
						savedAccount.setId_account(UUID.randomUUID().toString());
						savedAccount.setBalance(Math.random()*100000);
						savedAccount.setCreationDate(new Date());
						savedAccount.setStatus(AccountStatus.CREATED);
						savedAccount.setCostumer(costumer);
						savedAccount.setRate(5.5);
						bankAccountRepository.save(savedAccount);
					}
					);
			bankAccountRepository.findAll().forEach(ac -> {
				for(int i = 0; i< 10 ; i++){
					AccountOperation accountOperation = new AccountOperation();
					accountOperation.setOperationDate(new Date());
					accountOperation.setOperationAmont(Math.random()*113000);
					accountOperation.setOperationType(Math.random()>0.5 ? OperationType.DEBIT:OperationType.CREDIT);
					accountOperation.setBankAccount(ac);
					accountOperationRepository.save(accountOperation);
				}
			});
		};
	}

}
