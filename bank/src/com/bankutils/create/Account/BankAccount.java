package com.bankutils.create.Account;

public class BankAccount {
     private double saldo;
     private String name;
     private int agencia;

     public void BankAccount(double saldo, String name, int agencia) {
          this.saldo = saldo;
          this.name = name;
          this.agencia = agencia;
     }

     public void adicionarSaldo(double valor) {
          this.saldo += valor;
     }

     public void removerSaldo(double valor) {
          this.saldo -= valor;
     }

     public void getSaldo() {
          System.out.println("Seu saldo é de: " + this.saldo);
     }

     public void getAgency() {
          System.out.println("Sua agência é: " + this.agencia);
     }
}
