package com.bankutils.create;

import com.bankutils.create.Account.BankAccount;

public class CreateUser {
     private String name;
     private String password;
     private String cpf;
     private int agencia;

     public void registerUser(String name, String password, String cpf) {
          this.name = name;
          this.password = password;
          this.cpf = cpf;

          System.out.println("Conta criada com sucesso.");
          System.out.println("Name: " + this.name);
          System.out.println("Agency: " + this.agencia);
     }

     public String getName() {
          return name;
     }

     public String getPassword() {
          return password;
     }

     public String getCpf() {
          return cpf;
     }

     public int getAgencia() {
          return agencia;
     }
}
