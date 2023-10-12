package ufps.poo2.ejercicio.banco;

public class Cdt extends Account{

	
	public Cdt(int a, Cliente cliente) {
		super(a, cliente);
	}
	
	//modificacion F1
	public double calcularRentabilidad() {
		double saldo = getBalance();
		double ganancia = saldo * 0.01 * 10; // siempre va a ser de 10 dias
		return saldo + ganancia;
	}
	
	public void deposit(double sum) {
		try {
			if (sum > 0) {
				double total = sum;
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
		System.out.println("No puedes retirar en este tipo de cuenta");
	}
	
	@Override
	public String toString() {
		return "Cdt " + getAccountNumber() + ": " + "balance = " + getBalance();
	}
	
	//este metodo es de F1
	public double obtenerSaldo() {
		return super.getBalance();
	}
}