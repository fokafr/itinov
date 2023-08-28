package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //la generation de l'id est confiée à la BDD
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy =  "costumer") //Eviter la generation de plusieurs clés etrangères
    private List<BankAccount> BankAccounts;

}
