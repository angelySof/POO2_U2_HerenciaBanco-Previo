package ufps.poo2.ejercicio.banco;

//implementacióSn F3
public class Cliente {

    private String cc;
    private String nombres;
    private String apellidos;

    public Cliente(){

    }

    public Cliente(String cc, String nombres, String apellidos) {
        this.cc = cc;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    
    public String getCc() {
		return cc;
	}


	public void setCc(String cc) {
		this.cc = cc;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	@Override
    public String toString() {
        return "Cliente [CC=" + cc + ", Nombres=" + nombres + ", Apellidos=" + apellidos + "]";
    }
}



