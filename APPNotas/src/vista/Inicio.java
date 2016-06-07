package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;


import controlador.Controlador;
import modelo.Modelo;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;
	//------------------------------
	private Modelo modelo;
	private Controlador controlador;
	private JTextField txtNick;
	private JPasswordField txtpassword;


	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(144, 238, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblG = new JLabel("Gestor notas DAM");
		lblG.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblNick = new JLabel("Nick-->");
		lblNick.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a-->");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtNick = new JTextField();
		txtNick.setColumns(10);
		
		txtpassword = new JPasswordField();
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.solicitoNickyContraseña();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(149)
							.addComponent(lblG))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(66)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblContrasea)
								.addComponent(lblNick))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtpassword)
								.addComponent(txtNick, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(lblG)
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNick)
						.addComponent(txtNick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(txtpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(btnEntrar)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}


	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}


	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}


	public String getTxtNick() {
		return txtNick.getText();
	}


	public String getTxtpassword() {
		char[] contrasena = txtpassword.getPassword();
		String contraseña = new String(contrasena);
		return contraseña;
	}
	
	
	
	
}
