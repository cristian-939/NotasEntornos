package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import vista.Inicio;
import vista.Ventanas;

public class Modelo {
	private Connection conexion;
	private String mi_url;
	// ventanasVISTA
	private Inicio inicio;
	private Ventanas ventanas;
	// Atributos
	boolean AciertoUsuario;
	private String[][] tablaAluno;
	private String[][] tablaProfe;
	private String[][] tablaAsig;
	private String[][] tablaAAN;

	public Modelo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			mi_url = "jdbc:oracle:thin:@localhost:1521:XE";
			conexion = DriverManager.getConnection(mi_url, "NOTAS", "123456");
		} catch (ClassNotFoundException e) {
			System.out.println("Sin Driver");
		} catch (SQLException e) {
			System.out.println("Sin Conexion");
		}
	}

	public void Inicio_Usuarios(String nick, String contrasena) {
		try {
			String query = "SELECT * FROM USUARIOS WHERE NICK=? AND CONTRASENA=?";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, nick);
			pstmt.setString(2, contrasena);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next()) {
				// String resultadoNick = rset.getString(1);
				// String resultadoContrasena = rset.getString(2);
				AciertoUsuario = true;
			}
			rset.close();
			pstmt.close();
		} catch (SQLException s) {
			System.out.println("Error en Inicio_usuarios");
		}

		if (AciertoUsuario == true) {
			inicio.setVisible(false);
			ventanas.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "Error Usuario o Contraseña", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void Consulta_Alumno() {
		try {
			tablaAluno = null;
			String nfilas = "Select count(*) from tb_alumno";
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(nfilas);
			rset.next();
			int f = rset.getInt(1);
			// ---------------------------------
			String query = "SELECT cod_alumno, dni, nombre_alum, n_expediente FROM tb_alumno ORDER BY cod_alumno";
			stmt = conexion.createStatement();
			rset = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();
			int c = rsmd.getColumnCount();
			int i = 0;
			tablaAluno = new String[f][c];
			while (rset.next()) {
				for (int j = 0; j < c; j++) {
					tablaAluno[i][j] = rset.getString(j + 1);
				}
				i++;
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			System.out.println("Error en el Consulta_Alumno");
		}
		ventanas.rellenarTablaAlumnos();
	}
	
	
	public void Consulta_Profesores() {
		try {
			String nfilas = "Select count(*) from tb_profesor";
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(nfilas);
			rset.next();
			int f = rset.getInt(1);
			// ---------------------------------
			String query = "SELECT cod_profe, dni_profe, nombre_profe FROM tb_profesor ORDER BY cod_profe";
			stmt = conexion.createStatement();
			rset = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rset.getMetaData();
			int c = rsmd.getColumnCount();
			int i = 0;
			tablaProfe = new String[f][c];
			while (rset.next()) {
				for (int j = 0; j < c; j++) {
					tablaProfe[i][j] = rset.getString(j + 1);
				}
				i++;
			}
			rset.close();
			stmt.close();
		} catch (SQLException s) {
			System.out.println("Error en el Consulta_Profesores");
		}
		ventanas.rellenarTablaProfesores();
		
	}
	
	
			public void Consulta_Asignaturas() {
				try {
					String nfilas = "Select count(*) from tb_asignatura";
					Statement stmt = conexion.createStatement();
					ResultSet rset = stmt.executeQuery(nfilas);
					rset.next();
					int f = rset.getInt(1);
					// ---------------------------------
					String query = "SELECT cod_asignatura, nombre_asignatura, tb_profesor_cod_profe FROM tb_asignatura ORDER BY cod_asignatura";
					stmt = conexion.createStatement();
					rset = stmt.executeQuery(query);
					ResultSetMetaData rsmd = rset.getMetaData();
					int c = rsmd.getColumnCount();
					int i = 0;
					tablaAsig = new String[f][c];
					while (rset.next()) {
						for (int j = 0; j < c; j++) {
							tablaAsig[i][j] = rset.getString(j + 1);
						}
						i++;
					}
					rset.close();
					stmt.close();
				} catch (SQLException s) {
					System.out.println("Error en el Consulta_Asignaturas");
				}
				ventanas.rellenarTablaAsignatura();
			}
			
			
			
			public void Consulta_Alu_Asig_Nota() {
				try {
					String nfilas = "Select count(*) from alu_asig_nota";
					Statement stmt = conexion.createStatement();
					ResultSet rset = stmt.executeQuery(nfilas);
					rset.next();
					int f = rset.getInt(1);
					// ---------------------------------
					String query = "SELECT nombre_alum, nombre_asignatura, nota FROM tb_asignatura, tb_alumno, alu_asig_nota  WHERE tb_alumno_cod_alumno=cod_alumno AND tb_asignatura_cod_asignatura = cod_asignatura ORDER BY nombre_alum, nombre_asignatura";
					stmt = conexion.createStatement();
					rset = stmt.executeQuery(query);
					ResultSetMetaData rsmd = rset.getMetaData();
					int c = rsmd.getColumnCount();
					int i = 0;
					tablaAAN = new String[f][c];
					while (rset.next()) {
						for (int j = 0; j < c; j++) {
							tablaAAN[i][j] = rset.getString(j + 1);
						}
						i++;
					}
					rset.close();
					stmt.close();
				} catch (SQLException s) {
					System.out.println("Error en el Consulta_Alu_Asig_Nota");
				}
				ventanas.rellenarTablaALU_ASIG_NOTA();	
			}

	public void InsertTablaAlumnos(String dni, String nombre, String expediente) {
		try {
			String nfilas = "Select count(*) from tb_alumno";
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(nfilas);
			rset.next();
			int f = rset.getInt(1);
			int numAlu = f + 1;
			// ---------------------------------------
			String query = "INSERT INTO tb_alumno (cod_alumno, dni, nombre_alum, n_expediente) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setInt(1, numAlu);
			pstmt.setString(2, dni);
			pstmt.setString(3, nombre);
			pstmt.setString(4, expediente);
			ResultSet rsete = pstmt.executeQuery();

			rset.close();
			rsete.close();
			pstmt.close();
		} catch (SQLException s) {
			System.out.println("Error en InsertTablaAlumnos");
		}

	}
	
	
		
			public void InsertTablaProfes(String dni, String nombre) {
				try {
					String nfilas = "Select count(*) from tb_profesor";
					Statement stmt = conexion.createStatement();
					ResultSet rset = stmt.executeQuery(nfilas);
					rset.next();
					int f = rset.getInt(1);
					int numAlu = f + 1;
					// ---------------------------------------
					String query = "INSERT INTO tb_profesor (cod_profe, dni_profe, nombre_profe) VALUES (?, ?, ?)";
					PreparedStatement pstmt = conexion.prepareStatement(query);
					pstmt.setInt(1, numAlu);
					pstmt.setString(2, dni);
					pstmt.setString(3, nombre);
					ResultSet rsete = pstmt.executeQuery();

					rset.close();
					rsete.close();
					pstmt.close();
				} catch (SQLException s) {
					System.out.println("Error en InsertTablaProfes");
				}

			}
	
	public void UpdateTablaAlumnos(String dni, String nombre, String expediente, String codigo) {
		try {

			// ---------------------------------------
			String query = "UPDATE tb_alumno SET dni=?, nombre_alum=?, n_expediente=? where cod_alumno=?";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, dni);
			pstmt.setString(2, nombre);
			pstmt.setString(3, expediente);
			pstmt.setString(4, codigo);
			ResultSet rsete = pstmt.executeQuery();

			rsete.close();
			pstmt.close();
		} catch (SQLException s) {
			System.out.println("Error en UpdateTablaAlumnos");
		}
	}
	
	public void UpdateTablaProfesor(String dni, String nombre, String codigo) {
		try {

			// ---------------------------------------
			String query = "UPDATE tb_profesor SET dni_profe=?, nombre_profe=? where cod_profe=?";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, dni);
			pstmt.setString(2, nombre);
			pstmt.setString(3, codigo);
	
			ResultSet rsete = pstmt.executeQuery();

			rsete.close();
			pstmt.close();
		} catch (SQLException s) {
			System.out.println("Error en UpdateTablaProfesor");
		}
	}
	
	
	
	public void DeleteTablaAlumnos(String codigo) {
		try {
			String query = "DELETE FROM tb_alumno WHERE cod_alumno=?";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, codigo);
			ResultSet rsete = pstmt.executeQuery();

			rsete.close();
			pstmt.close();
		} catch (SQLException s) {
			System.out.println("Error en DeleteTablaAlumnos");
		}
	}
	
	
	
	public void DeleteTablaProfe(String codigo) {
		try {
			String query = "DELETE FROM tb_profesor WHERE cod_profe=?";
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, codigo);
			ResultSet rsete = pstmt.executeQuery();

			rsete.close();
			pstmt.close();
		} catch (SQLException s) {
			System.out.println("Error en DeleteTablaProfe");
		}
	}

	public void setInicio(Inicio inicio) {
		this.inicio = inicio;
	}

	public void setVentanas(Ventanas ventanas) {
		this.ventanas = ventanas;
	}

	public String[][] getTablaAluno() {
		return tablaAluno;
	}

	public String[][] getTablaProfe() {
		return tablaProfe;
	}

	public String[][] getTablaAsig() {
		return tablaAsig;
	}

	public String[][] getTablaAAN() {
		return tablaAAN;
	}
	
	

}
