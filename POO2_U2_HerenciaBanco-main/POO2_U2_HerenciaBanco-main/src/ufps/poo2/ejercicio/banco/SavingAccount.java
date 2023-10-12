package ufps.poo2.ejercicio.banco;

public class SavingAccount extends Account {
	private double interest = 0.19;
	private double overDraftLimit = 10;
	public SavingAccount(int a, Cliente cliente) {
		super(a, cliente);
	}

	@Override
	public void deposit(double sum) {
		try {
			if (sum > 0) {
				double total = ((sum * interest) + sum);
				super.deposit(total);
			} else {
				System.out.println("Error, el valor debe ser positivo");
			}
		} catch (Exception e) {
			System.out.println("Error al realizar la operación de depósito: ");
		}
	}
	
	@Override
	public void withdraw(double sum) {
		try {
			if (sum > 0) {
				if (sum <= super.getBalance() + overDraftLimit) {
					super.withdraw(sum);
				} else {
					System.out.println("No se puede realizar la operación");
				}
			} else {
				System.out.println("Error, es negativo");
			}
		} catch (Exception e) {
			System.out.println("Error al realizar la operación de retiro: ");
			
		}
	}
	
	// este metodo es de F1
	public double obtenerSaldo() {
		return super.getBalance() + overDraftLimit;
	}
}