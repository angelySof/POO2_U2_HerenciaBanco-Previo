package ufps.poo2.ejercicio.banco;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	private static Bank instance;
	private List<Account> accounts;

	private Bank() {
		accounts = new ArrayList<>();
	}

	public static Bank getInstance() {
		if (instance == null) {
			instance = new Bank();
		}
		return instance;
	}

	public void openAccount(char letter, int accnum, Cliente cliente) {
	    try {
	        switch (letter) {
	            case 'A':
	                SavingAccount cuenta = new SavingAccount(accnum, cliente);
	                accounts.add(cuenta);
	                System.out.println("Cuenta de ahorros creada para " + cliente.getNombres() + " " + cliente.getApellidos());
	                break;

	            case 'C':
	                CurrentAccount cuenta2 = new CurrentAccount(accnum, cliente);
	                accounts.add(cuenta2);
	                System.out.println("Cuenta corriente creada para " + cliente.getNombres() + " " + cliente.getApellidos());
	                break;

	            case 'D':
	                Cdt cuenta3 = new Cdt(accnum, cliente);
	                accounts.add(cuenta3);
	                System.out.println("Cuenta CDT creada para " + cliente.getNombres() + " " + cliente.getApellidos());
	                break;

	            default:
	                break;
	        }
	    } catch (Exception e) {
	        System.out.println("Escoge entre A o C");
	    }
	}


	public void closeAccount(int accnum) {
		for (Account account : accounts) {
			if (account instanceof SavingAccount) {
				SavingAccount cuentaAhorros = (SavingAccount) account;
				if (cuentaAhorros.getAccountNumber() == accnum) {
					accounts.remove(cuentaAhorros);
					System.out.println("Cuenta de ahorros cerrada");
					break;
				}
			}
			if (account instanceof CurrentAccount) {
				CurrentAccount cuentaCorriente = (CurrentAccount) account;
				if (cuentaCorriente.getAccountNumber() == accnum) {
					accounts.remove(cuentaCorriente);
					System.out.println("Cuenta corriente cerrada:");
					break;
				}
			}
			if (account instanceof Cdt) {
				Cdt cuentaCdt = (Cdt) account;
				if (cuentaCdt.getAccountNumber() == accnum) {
					accounts.remove(cuentaCdt);
					System.out.println("Cuenta Cdt cerrada:");
					break;
				}
			}

		}
	}

	public void payDividend(int accnum, int sum) {
		for (Account account : accounts) {
			if (account instanceof SavingAccount) {
				SavingAccount cuentaAhorros = (SavingAccount) account;
				if (cuentaAhorros.getAccountNumber() == accnum) {
					System.out.println("deposito hecho a la cuenta ahorros");
					cuentaAhorros.deposit(sum);

				}
			}
			if (account instanceof CurrentAccount) {
				CurrentAccount cuentaCorriente = (CurrentAccount) account;
				if (cuentaCorriente.getAccountNumber() == accnum) {
					System.out.println("deposito hecho a la cuenta corriente");
					cuentaCorriente.deposit(sum);

				}

			}
			if (account instanceof Cdt) {
				Cdt cuentaCdt = (Cdt) account;
				if (cuentaCdt.getAccountNumber() == accnum) {
					System.out.println("deposito hecho a la cuenta Cdt");
					cuentaCdt.deposit(sum);
				}
			}

		}
	}

	public void calcularRentabilidad(int accnum) {
		for (Account account : accounts) {
			if (account instanceof Cdt) {
				Cdt cuentaCdt = (Cdt) account;
				if (cuentaCdt.getAccountNumber() == accnum) {
					System.out.println(
							"la rentabilidad más el valor del balance en cuenta CDT: " + cuentaCdt.calcularRentabilidad());
				}
			}
		}
	}

	public String getBalance(int accnum) {
		for (Account account : accounts) {
			if (account instanceof SavingAccount) {
				SavingAccount cuentaAhorros = (SavingAccount) account;
				if (cuentaAhorros.getAccountNumber() == accnum) {
					return Double.toString(cuentaAhorros.obtenerSaldo());
				}
			}
			if (account instanceof CurrentAccount) {
				CurrentAccount cuentaCorriente = (CurrentAccount) account;
				if (cuentaCorriente.getAccountNumber() == accnum) {
					return Double.toString(cuentaCorriente.obtenerSaldo());
				}
			}
			if (account instanceof Cdt) {
				Cdt cuentaCdt = (Cdt) account;
				if (cuentaCdt.getAccountNumber() == accnum) {
					return Double.toString(cuentaCdt.obtenerSaldo());
				}
			}
		}
		return ("No hay cuenta asociada");
	}

	public void withdrawAccount(int accnum, int sum) {
		for (Account account : accounts) {
			if (account instanceof SavingAccount) {
				SavingAccount cuentaAhorros = (SavingAccount) account;
				if (cuentaAhorros.getAccountNumber() == accnum) {
					System.out.println("retiro hecho a la cuenta de ahorros");
					cuentaAhorros.withdraw(sum);

				}
			}
			if (account instanceof CurrentAccount) {
				CurrentAccount cuentaCorriente = (CurrentAccount) account;
				if (cuentaCorriente.getAccountNumber() == accnum) {
					System.out.println("retiro hecho a la cuenta corriente");
					cuentaCorriente.withdraw(sum);

				}
			}
			if (account instanceof Cdt) {
				Cdt cuentaCdt = (Cdt) account;
				if (cuentaCdt.getAccountNumber() == accnum) {
					cuentaCdt.withdraw(sum);

				}
			}

		}
	}

	public void sendLetterToOverdraftAccounts() {
		for (Account account : accounts) {
			if (account instanceof CurrentAccount) {
				CurrentAccount cuentaCorriente = (CurrentAccount) account;
				if (cuentaCorriente.getBalance() < 0) {
					Account cuenta = cuentaCorriente;
					System.out.println("La cuenta: " + cuenta.getAccountNumber() + " esta en sobregiro");
				}
			}
		}
	}

	// implementacion F2
	public void printAllAccounts() {
		for (Account account : accounts) {
			System.out.println(account.toString());
			System.out.println("Saldo: " + account.getBalance());
		}
	}
	
	//REQUERIMIENTO F4 (Recorrer cuentas e imprimir la cuenta y dar el nombre del cliente)
	 public void printAccountsWithClientNames() {
	        for (Account account : accounts) {
	            Cliente cliente = account.getClient(); 

	            if (cliente != null) {
	                System.out.println("Número de cuenta: " + account.getAccountNumber());
	                System.out.println("Nombre completo del cliente: " + cliente.getNombres() + " " + cliente.getApellidos());
	                System.out.println("---------------");
	            }
	        }
	    }

}
