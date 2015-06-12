package Practica2;

import Practica2.Simbolo.clase_parametro;
import Practica2.Simbolo.tipo_variable;

public class Tabla_simbolos {
	TablaHash table;

	/**
	 * Crea una tabla de símbolos vacía. Este procedimientodebe invocarse antes
	 * de hacer ninguna operación con la tabla de símbolos.
	 */
	public void inicializar_tabla() {
		table = new TablaHash();
	}

	/**
	 * Busca en la tabla el símbolo de mayor nivel cuyo nombre coincida con @param
	 * nombre. Si existe, devuelve un puntero como resultado, de lo contrario
	 * devuelve NULL
	 */
	public Simbolo buscar_simbolo(String nombre) {
		return table.buscar(nombre);
	}

	public Simbolo introducir_programa(String nombre, int dir) {
		return null;
	}

	/**********************************************************************
	 * Introduce en la tabla un simbolo PROGRAMA, con el nombre del parametro,
	 * de nivel 0, con la direccion del parametro. Dado que debe ser el primer
	 * simbolo a introducir, NO SE VERIFICA QUE EL SIMBOLO YA EXISTA.
	 **********************************************************************/

	public Simbolo introducir_variable(String nombre, tipo_variable variable,
			int nivel, int dir) {
		if (!table.existe(nombre, nivel)) {
			Simbolo sim = new Simbolo();
			sim.introducir_variable(nombre, variable, nivel, dir);
			table.insertar(sim);
			return sim;
		} else {
			return null;
		}
	}

	/**********************************************************************
	 * Si existe un símbolo en la tabla del mismo nivel y con el mismo nombre,
	 * devuelve NULL (o una excepción, esto se deja a vuestra elección. De lo
	 * contrario, introduce un símbolo VARIABLE (simple) con los datos de los
	 * argumentos.
	 **********************************************************************/
	/**********************************************************************/
	public Simbolo introducir_accion(String nombre, int nivel, int dir) {
		if (!table.existe(nombre, nivel)) {
			Simbolo sim = new Simbolo();
			sim.introducir_accion(nombre, nivel, dir);
			table.insertar(sim);
			return sim;
		} else {
			return null;
		}
	}

	/**********************************************************************
	 * Si existe un símbolo en la tabla del mismo nivel y con el mismo nombre,
	 * devuelve NULL. De lo contrario, introduce un símbolo ACCION con los datos
	 * de los argumentos.
	 **********************************************************************/
	/**********************************************************************/

	public Simbolo introducir_parametro(String nombre, tipo_variable variable,
			clase_parametro parametro, int nivel, int dir) {
		if (!table.existe(nombre, nivel)) {
			Simbolo sim = new Simbolo();
			sim.introducir_parametro(nombre, variable,parametro, nivel,dir);
			table.insertar(sim);
			return sim;
		}else{
		return null;
		}
	}

	/**********************************************************************
	 * Si existe un símbolo en la tabla del mismo nivel y con el mismo nombre,
	 * devuelve NULL. De lo contrario, introduce un símbolo PARAME TRO con los
	 * datos de los argumentos.
	 **********************************************************************/
	/**********************************************************************/
	public void eliminar_programa() {
	}

	/*********************************
	 ************************************* 
	 Elimina de la tabla todos los símbolos PROGRAMA de nivel 0 (debería haber
	 * uno solo).
	 **********************************************************************/
	/**********************************************************
	************/
	public void eliminarNivel(int nivel) {
		//table.imprimirNivel(nivel);
		table.eliminarNivel(nivel);
	}

	/**********************************************************************
	 * Elimina de la tabla todos los simbolos que sean del nivel del argumento.
	 **********************************************************************/
	/**********************************************************************/
	public void ocultar_parametros(int nivel) {
	}

	/**********************************************************************
	 * Marca todos los parámetros de un nivel como ocultos para que no puedan
	 * ser encontrados, pero se mantenga la definición completa de la acción
	 * donde están declarados para verificación de invocaciones a la acción.
	 **********************************************************************/
	/**********************************************************************/
	public void eliminar_parametros_ocultos(int nivel) {
	}

	/**********************************************************************
	 * Elimina de la tabla todas los parámetros que hayan sido ocultados
	 * previamente. LOS PROCEDIMIENTOS Y FUNCIONES DONDE ESTABAN DECLARADOS
	 * DEBEN SER ELIMINAODS TAMBIEN PARA MANTENER LA COHERENCIA DE LA TABLA.
	 **********************************************************************/
	/**********************************************************************/
	public void eliminar_acciones(int nivel) {
	}
	/**********************************************************************
	 * Elimina de la tabla todas los procedimientos de un nivel. LOS PARAMETROS
	 * DE ESTAS ACCIONES DEBEN SER ELIMINADOS TAMBIEN PARA MANTENER LA
	 * COHERENCIA DE LA TABLA.
	 **********************************************************************/

}
