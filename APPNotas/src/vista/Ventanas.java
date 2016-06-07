package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Modelo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ventanas extends JFrame {

	private JPanel contentPane;
	private JTextField txtexpediente;
	private JTextField txtdni;
	private JTextField txtnombre;
	private JTable tableALU;
	private DefaultTableModel dtmAlumno;
	private DefaultTableModel dtmProfe;
	private Controlador controlador;
	private Modelo modelo;
	private JTextField txtdniProfe;
	private JTextField txtnombreProfe;
	private JTable tablePROFE;
	String codigo_alumn;
	String codigo_profe;
	private JTable tableASGNTRA;
	private JTextField textField;
	private JTable tableAAN;

	/**
	 * Create the frame.
	 */
	public Ventanas() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				controlador.rellenotablaAlumnos();
				controlador.rellenotablaProfesores();
				controlador.rellenotablaAsignaturas();
				controlador.rellenotablaAlu_Asig_Nota();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "name_24139699517280");
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Alumnos", null, panel, null);
		
		JLabel lblDni = new JLabel("DNI-->");
		
		JLabel lblNombre = new JLabel("Nombre-->");
		
		JLabel lblNExpediente = new JLabel("N\u00BA Expediente-->");
		
		txtexpediente = new JTextField();
		txtexpediente.setColumns(10);
		
		txtdni = new JTextField();
		txtdni.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.pidoInsert_tablaAlumnos(txtdni.getText(), txtnombre.getText(), txtexpediente.getText());
				txtdni.setText("");
				txtnombre.setText("");
				txtexpediente.setText("");
				//----------------------------------
				tableALU.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Codigo", "DNI", "Nombre", "N\u00BA Expediente"
						}
					));
				//------------------------------------
				
				controlador.rellenotablaAlumnos();
			}
		});
		
		JButton btnMod = new JButton("MOD");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.pidoUpdate_tablaAlumnos(txtdni.getText(), txtnombre.getText(), txtexpediente.getText(), codigo_alumn);
				txtdni.setText("");
				txtnombre.setText("");
				txtexpediente.setText("");
				//----------------------------------
				tableALU.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Codigo", "DNI", "Nombre", "N\u00BA Expediente"
						}
					));
				//------------------------------------
				
				controlador.rellenotablaAlumnos();
			}
		});
		
		JButton btnDel = new JButton("DEL");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.pidoDelete_tablaAlumnos(codigo_alumn);
				txtdni.setText("");
				txtnombre.setText("");
				txtexpediente.setText("");
				//----------------------------------
				tableALU.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Codigo", "DNI", "Nombre", "N\u00BA Expediente"
						}
					));
				//------------------------------------
				
				controlador.rellenotablaAlumnos();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNExpediente, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDni)
								.addComponent(lblNombre))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtdni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtexpediente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMod)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnDel)
							.addGap(7)))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDni)
								.addComponent(txtdni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(txtnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNExpediente)
								.addComponent(txtexpediente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAdd)
								.addComponent(btnMod)
								.addComponent(btnDel))))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		
		tableALU = new JTable();
		tableALU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaSelected = tableALU.getSelectedRow();
				codigo_alumn = tableALU.getValueAt(filaSelected, 0).toString();
				txtdni.setText(tableALU.getValueAt(filaSelected, 1).toString());
				txtnombre.setText(tableALU.getValueAt(filaSelected, 2).toString());
				txtexpediente.setText(tableALU.getValueAt(filaSelected, 3).toString());
			}
		});
		tableALU.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "DNI", "Nombre", "N\u00BA Expediente"
			}
		));
		tableALU.getColumnModel().getColumn(0).setPreferredWidth(57);
		tableALU.getColumnModel().getColumn(1).setPreferredWidth(85);
		tableALU.getColumnModel().getColumn(2).setPreferredWidth(140);
		tableALU.getColumnModel().getColumn(3).setPreferredWidth(95);
		scrollPane.setViewportView(tableALU);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Profesores", null, panel_2, null);
		
		JLabel lblDni_1 = new JLabel("DNI-->");
		
		JLabel lblNombre_1 = new JLabel("Nombre-->");
		
		txtdniProfe = new JTextField();
		txtdniProfe.setColumns(10);
		
		txtnombreProfe = new JTextField();
		txtnombreProfe.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnAddProfe = new JButton("ADD");
		btnAddProfe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.pidoInsert_tablaProfes(txtdniProfe.getText(), txtnombreProfe.getText());
				txtdniProfe.setText("");
				txtnombreProfe.setText("");
				//----------------------------------
				tablePROFE.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Codigo", "DNI", "Profesor"
						}
					));
				//------------------------------------
				controlador.rellenotablaProfesores();
			}
		});
		
		JButton btnModProfe = new JButton("MOD");
		btnModProfe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.pidoUpdate_tablaProfesor(txtdniProfe.getText(), txtnombreProfe.getText(), codigo_profe);
				txtdniProfe.setText("");
				txtnombreProfe.setText("");
				//----------------------------------
				tablePROFE.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Codigo", "DNI", "Profesor"
						}
					));
				//------------------------------------
				controlador.rellenotablaProfesores();
			}
		});
		
		JButton btnDelProfe = new JButton("DEL");
		btnDelProfe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.pidoDelete_tablaAlumnos(codigo_alumn);
				controlador.pidoDelete_tablaProfesores(codigo_profe);
				txtdniProfe.setText("");
				txtnombreProfe.setText("");
				//----------------------------------
				tablePROFE.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Codigo", "DNI", "Profesor"
						}
					));
				//------------------------------------
				controlador.rellenotablaProfesores();
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDni_1)
								.addComponent(lblNombre_1))
							.addGap(25)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtnombreProfe)
								.addComponent(txtdniProfe, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnAddProfe)
							.addGap(18)
							.addComponent(btnModProfe)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDelProfe)))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(21)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni_1)
						.addComponent(txtdniProfe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre_1)
						.addComponent(txtnombreProfe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddProfe)
						.addComponent(btnModProfe)
						.addComponent(btnDelProfe))
					.addGap(47))
		);
		
		tablePROFE = new JTable();
		tablePROFE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int filaSelected = tablePROFE.getSelectedRow();
				codigo_profe = tablePROFE.getValueAt(filaSelected, 0).toString();
				txtdniProfe.setText(tablePROFE.getValueAt(filaSelected, 1).toString());
				txtnombreProfe.setText(tablePROFE.getValueAt(filaSelected, 2).toString());
	
			}
		});
		tablePROFE.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "DNI", "Profesor"
			}
		));
		scrollPane_1.setViewportView(tablePROFE);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Asignaturas", null, panel_1, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblAsignatura = new JLabel("Asignatura:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnAdd_1 = new JButton("ADD");
		
		JButton btnMod_1 = new JButton("MOD");
		
		JButton btnDel_1 = new JButton("DEL");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAsignatura)
								.addComponent(lblProfesor))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 137, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnAdd_1)
							.addGap(18)
							.addComponent(btnMod_1)
							.addGap(18)
							.addComponent(btnDel_1)))
					.addGap(18)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAsignatura)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProfesor)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd_1)
						.addComponent(btnMod_1)
						.addComponent(btnDel_1))
					.addGap(37))
		);
		
		tableASGNTRA = new JTable();
		tableASGNTRA.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"COD Asig", "Asignatura", "COD PROFESOR"
			}
		));
		scrollPane_2.setViewportView(tableASGNTRA);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Alumno Asignatura Nota", null, panel_3, null);
		
		JLabel lblAlumno = new JLabel("Alumno:");
		
		JLabel lblAsignatura_1 = new JLabel("Asignatura:");
		
		JLabel lblNota = new JLabel("Nota:");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JComboBox comboBox_1 = new JComboBox();
		
		JComboBox comboBox_2 = new JComboBox();
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		
		JButton btnAdd_2 = new JButton("ADD");
		
		JButton btnMod_2 = new JButton("MOD");
		
		JButton btnDel_2 = new JButton("DEL");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(lblAlumno)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox_1, 0, 130, Short.MAX_VALUE))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(lblAsignatura_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_2, 0, 119, Short.MAX_VALUE))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(lblNota)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 18, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(btnAdd_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnMod_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDel_2)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlumno)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAsignatura_1)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNota)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd_2)
						.addComponent(btnMod_2)
						.addComponent(btnDel_2))
					.addContainerGap(22, Short.MAX_VALUE))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tableAAN = new JTable();
		tableAAN.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Alumno", "Asignatura", "Nota"
			}
		));
		scrollPane_3.setViewportView(tableAAN);
		panel_3.setLayout(gl_panel_3);
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	public void rellenarTablaAlumnos() {
		String[][] tablaAlumnos = modelo.getTablaAluno();
		dtmAlumno = (DefaultTableModel) tableALU.getModel();
		for (int i = 0; i < tablaAlumnos.length; i++) {
			dtmAlumno.addRow(tablaAlumnos[i]);
		}
	}
	
	
	public void rellenarTablaProfesores() {
		String[][] tablaProfesores = modelo.getTablaProfe();
		dtmProfe = (DefaultTableModel) tablePROFE.getModel();
		for (int i = 0; i < tablaProfesores.length; i++) {
			dtmProfe.addRow(tablaProfesores[i]);
		}
	}
	
	public void rellenarTablaAsignatura() {
		String[][] tablaAsignatura = modelo.getTablaAsig();
		DefaultTableModel dtmAsig = (DefaultTableModel) tableASGNTRA.getModel();
		for (int i = 0; i < tablaAsignatura.length; i++) {
			dtmAsig.addRow(tablaAsignatura[i]);
		}
	}
	
	public void rellenarTablaALU_ASIG_NOTA() {
		String[][] tablaAAN = modelo.getTablaAAN();
		DefaultTableModel dtmAAN = (DefaultTableModel) tableAAN.getModel();
		for (int i = 0; i < tablaAAN.length; i++) {
			dtmAAN.addRow(tablaAAN[i]);
		}
	}
}
