package ufps.poo2.ejercicio.banco;

public class Account {

    private double balance; // El saldo actual
    private int accountNumber; // El número de cuenta
    private Cliente client; // Referencia al cliente asociado a la cuenta

    public Account(int accountNumber, Cliente client) {
        this.balance = 0.0;
        this.accountNumber = accountNumber;
        this.client = client;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.err.println("Account.deposit(...): " + "no se puede depositar una cantidad negativa.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            balance -= amount;
        } else {
            System.err.println("Account.withdraw(...): " + "no se puede retirar una cantidad negativa.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Cuenta " + accountNumber + ": " + "saldo = " + balance + ", Cliente: " + client;
    }

    public final void print() {
        // No sobrescribas este método,
        // sobrescribe el método toString
        System.out.println(toString());
    }
}