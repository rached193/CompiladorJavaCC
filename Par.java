package Practica2;

public class Par {
	private String clave;
	private Simbolo valor;
	private Par siguiente;
	
	
	public Par(String clave, Simbolo valor){
		this.clave=clave;
		this.valor=valor;
		siguiente = null;
	}
	
	public String getClave(){
		return clave;
	}
	
	public Simbolo getValor(){
		return valor;
	}
	
	public void setSiguiente(Par nsiguiente){
		this.siguiente=nsiguiente;
	}
	
	public Par getSiguiente(){
		return siguiente;
	}
}
