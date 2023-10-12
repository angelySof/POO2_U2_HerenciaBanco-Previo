package ufps.poo2.ejercicio.test;

import ufps.poo2.ejercicio.banco.Bank;
import ufps.poo2.ejercicio.banco.Cliente;

public class Client {

public static void main(String[] args) {

	//Esta clase es usada para realizar las pruebas de las implementaciones de F1, F2, F3 y F4.
		
	
		// ==================================================
	Bank bank = Bank.getInstance();
	Cliente cliente1 = new Cliente("123456789", "Juan", "Perez");
	Cliente cliente2 = new Cliente("123459", "Maria", "Lopez");
	Cliente cliente3 = new Cliente("2345", "Carlos", "Rojas");
	
	bank.openAccount('A', 12345, cliente1);
	bank.openAccount('C', 23456, cliente2);
	bank.openAccount('D', 34567, cliente3);
	


	bank.payDividend(12345, 10);
	bank.payDividend(23456, 10);
	bank.payDividend(34567, 10);
	
	System.out.println(bank.getBalance(12345));
	System.out.println(bank.getBalance(23456));
	System.out.println(bank.getBalance(34567));
	
	System.out.println("Esta es la rentabilidad: ");
	bank.calcularRentabilidad(34567);
	
	bank.printAllAccounts();
	bank.printAccountsWithClientNames();
	

		
	}
	
}