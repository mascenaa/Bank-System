package com.bankutils.create;

import com.bankutils.create.Account.BankAccount;

public class CreateUser {
     private String name;
     private String password;
     private String cpf;
     private double saldo;
     private int agencia;

     public void registerUser(String name, String password, String cpf, double saldo, int agencia) {
          this.name = name;
          this.password = password;
          this.cpf = cpf;
          this.saldo = 0;
          // generate random agency number between 0 and 1000
          this.agencia = (int) (Math.random() * 1000);

          BankAccount bankAccount = new BankAccount();
          bankAccount.BankAccount(saldo, name, agencia);
          System.out.println("Conta criada com sucesso.");
     }

     public String getName() {
          return name;
     }

     public String getPassword() {
          return password;
     }
}
