package controlador;

import modelo.Modelo;
import vista.Inicio;
import vista.Ventanas;

public class Controlador {
	private Modelo modelo;
	private Inicio inicio;
	private Ventanas ventanas;

	public void solicitoNickyContraseña() {
		modelo.Inicio_Usuarios(inicio.getTxtNick(), inicio.getTxtpassword());
	}

	public void pidoInsert_tablaAlumnos(String dni, String nombre, String expediente) {
		modelo.InsertTablaAlumnos(dni, nombre, expediente);
	}

	public void pidoInsert_tablaProfes(String dni, String nombre) {
		modelo.InsertTablaProfes(dni, nombre);
	}

	public void pidoUpdate_tablaAlumnos(String dni, String nombre, String expediente, String cod_alu) {
		modelo.UpdateTablaAlumnos(dni, nombre, expediente, cod_alu);
	}

	public void pidoUpdate_tablaProfesor(String dni, String nombre, String cod_alu) {
		modelo.UpdateTablaProfesor(dni, nombre, cod_alu);
	}

	public void pidoDelete_tablaAlumnos(String cod_alu) {
		modelo.DeleteTablaAlumnos(cod_alu);
	}

	public void pidoDelete_tablaProfesores(String cod_profe) {
		modelo.DeleteTablaProfe(cod_profe);
	}

	public void rellenotablaAlumnos() {
		modelo.Consulta_Alumno();
	}

	public void rellenotablaProfesores() {
		modelo.Consulta_Profesores();
	}

	public void rellenotablaAsignaturas() {
		modelo.Consulta_Asignaturas();
	}

	public void rellenotablaAlu_Asig_Nota() {
		modelo.Consulta_Alu_Asig_Nota();
	}

	public void setInicio(Inicio inicio) {
		this.inicio = inicio;
	}

	public void setVentanas(Ventanas ventanas) {
		this.ventanas = ventanas;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

}
