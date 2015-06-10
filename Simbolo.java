package Practica2;

import java.util.ArrayList;

public class Simbolo {
	
	
	public enum tipo_simbolo{
		PROGRAMA, VARIABLE,  ACCION, PARAMETRO
	}
	
	public enum tipo_variable{
		DESCONOCIDO, ENTERO, BOOLEANO, CARACTER, CADENA
	}
	
	public enum clase_parametro{
		VAL, REF
	}
	
	private String nombre;
	private int nivel;
	private tipo_simbolo tipo;
	private tipo_variable variable;
	private clase_parametro parametro;
	private ArrayList<Simbolo> lista_parametros;
	private long dir;
	private RegistroFactor factor;
	
public void introducir_parametro(String nombre, tipo_variable variable,clase_parametro clase, int nivel ){
	this.nombre = nombre;
	this.variable=variable;
	this.parametro = clase;
	this.nivel = nivel;
	this.tipo = tipo_simbolo.PARAMETRO;
}


public void introducir_accion (String nombre, int nivel, int dir){
	this.nombre=nombre;
	this.nivel = nivel;
	this.dir = dir;
	this.tipo = tipo_simbolo.ACCION;
}

public void introducir_variable(String nombre, tipo_variable variable, int nivel, int dir){
	this.nombre=nombre;
	this.variable=variable;
	this.nivel=nivel;
	this.dir=dir;
	this.tipo = tipo_simbolo.VARIABLE;
}

public String getNombre(){
	return nombre;
}

public int getNivel(){
	return nivel;
}

public tipo_simbolo getTipo(){
	return tipo;
}

public tipo_variable getVariable(){
	return variable;
}

public clase_parametro getParametro(){
return parametro;
}


public ArrayList<Simbolo> getListaParametros(){
	return lista_parametros;
}

public void setListaParametros(ArrayList<Simbolo> lista){
	lista_parametros=lista;
}

public long getDir(){
	return dir;
}

public RegistroFactor getFactor(){
	return factor;
}


public void setFactor(RegistroFactor factor){
	this.factor=factor;
}
}
