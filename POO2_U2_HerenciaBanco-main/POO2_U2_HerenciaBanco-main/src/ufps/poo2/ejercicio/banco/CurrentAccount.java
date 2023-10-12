package ufps.poo2.ejercicio.banco;

public class CurrentAccount extends Account {
	private double overDraftLimit = 10;

	public CurrentAccount(int a, Cliente cliente) {
		super(a, cliente);
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
			System.out.println("Error al realizar la operación de retiro ");
			
		}
	}
	
	@Override
	public void deposit(double sum) {
		try {
			double interest = 1.9;
			if (sum > 0) {
				double total = ((sum * interest));
				super.deposit(total);
			} else {
				System.out.println("Error, el valor debe ser positivo");
			}
		} catch (Exception e) {
			System.out.println("Error al realizar la operación de depósito: ");
		}
	}
	
	//este metodo es de f1
	public double obtenerSaldo() {
		return super.getBalance();
	}
}