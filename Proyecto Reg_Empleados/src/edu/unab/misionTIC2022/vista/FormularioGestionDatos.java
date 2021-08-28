package edu.unab.misionTIC2022.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import edu.unab.misionTIC2022.modelo.Empleado;

public class FormularioGestionDatos extends JFrame implements ActionListener, FocusListener, KeyListener {

	private static final long serialVersionUID = 2857210923217594905L;
	private DefaultTableModel dtmDatosPersonales = new DefaultTableModel();
	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtEdad;
	private JTextField txtCargo;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtSalario;
	private JTextField txtTotalNomina;
	private JTable tblDatosPersonales;
	private JButton btnNuevo;
	private JButton btnAsignar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;

	private List<Empleado> listaEmpleado = new ArrayList<Empleado>();
	private String[] columnas = new String[] { "Cédula", "Nombres", "Apellidos", "Edad", "Cargo", "Teléfono",
			"Dirección", "Salario" };
	private int filaSeleccionada = 0;
	private boolean modificar = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioGestionDatos frame = new FormularioGestionDatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioGestionDatos() {
		setTitle("Sistema Administrador de Empleados - Drapps.co");
		setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - 350), 0, 700, 712);
		contentPane = new JPanel();
		contentPane.setFocusCycleRoot(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				int opcion = JOptionPane.showConfirmDialog(null, "¿Estas seguro que desea salir?", "Información",
						JOptionPane.OK_CANCEL_OPTION);
				if (opcion == JOptionPane.OK_OPTION) {
					System.exit(0);

				} else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});

		JPanel pnlDatosEmpleado = new JPanel();
		pnlDatosEmpleado.setBorder(
				new TitledBorder(null, "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		pnlDatosEmpleado.setBounds(12, 12, 662, 639);
		contentPane.add(pnlDatosEmpleado);
		pnlDatosEmpleado.setLayout(null);

		JLabel lblIdentificacion = new JLabel("Identificaci\u00F3n:");
		lblIdentificacion.setBounds(28, 33, 83, 16);
		pnlDatosEmpleado.add(lblIdentificacion);

		txtCedula = new JTextField();
		txtCedula.setName("Identificaci\u00F3n");
		txtCedula.addActionListener(this);
		txtCedula.addKeyListener(this);
		txtCedula.addFocusListener(this);
		lblIdentificacion.setLabelFor(txtCedula);
		txtCedula.setColumns(10);
		txtCedula.setBounds(144, 31, 150, 20);
		pnlDatosEmpleado.add(txtCedula);

		JLabel lblNombre = new JLabel("Nombres:");
		lblNombre.setBounds(28, 78, 58, 16);
		pnlDatosEmpleado.add(lblNombre);

		txtNombres = new JTextField();
		txtNombres.setName("Nombre");
		txtNombres.addActionListener(this);
		txtNombres.addKeyListener(this);
		txtNombres.addFocusListener(this);
		lblNombre.setLabelFor(txtNombres);
		txtNombres.setColumns(10);
		txtNombres.setBounds(144, 76, 150, 20);
		pnlDatosEmpleado.add(txtNombres);

		JLabel lblApellido = new JLabel("Apellidos:");
		lblApellido.setBounds(365, 78, 59, 16);
		pnlDatosEmpleado.add(lblApellido);

		txtApellidos = new JTextField();
		txtApellidos.setName("Apellidos");
		txtApellidos.addActionListener(this);
		txtApellidos.addKeyListener(this);
		txtApellidos.addFocusListener(this);
		lblApellido.setLabelFor(txtApellidos);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(481, 74, 150, 20);
		pnlDatosEmpleado.add(txtApellidos);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(28, 117, 34, 16);
		pnlDatosEmpleado.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setName("Edad");
		txtEdad.addActionListener(this);
		txtEdad.addKeyListener(this);
		txtEdad.addFocusListener(this);
		lblEdad.setLabelFor(txtEdad);
		txtEdad.setColumns(10);
		txtEdad.setBounds(144, 116, 150, 20);
		pnlDatosEmpleado.add(txtEdad);

		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(365, 118, 39, 16);
		pnlDatosEmpleado.add(lblCargo);

		txtCargo = new JTextField();
		txtCargo.setName("Cargo");
		txtCargo.addActionListener(this);
		txtCargo.addKeyListener(this);
		txtCargo.addFocusListener(this);
		lblCargo.setLabelFor(txtCargo);
		txtCargo.setColumns(10);
		txtCargo.setBounds(481, 117, 150, 20);
		pnlDatosEmpleado.add(txtCargo);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(28, 162, 56, 16);
		pnlDatosEmpleado.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setName("Tel\u00E9fono");
		txtTelefono.addActionListener(this);
		txtTelefono.addKeyListener(this);
		txtTelefono.addFocusListener(this);
		lblTelefono.setLabelFor(txtTelefono);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(144, 161, 150, 20);
		pnlDatosEmpleado.add(txtTelefono);

		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(365, 162, 60, 16);
		pnlDatosEmpleado.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setName("Direcci\u00F3n");
		txtDireccion.addActionListener(this);
		txtDireccion.addKeyListener(this);
		txtDireccion.addFocusListener(this);
		lblDireccion.setLabelFor(txtDireccion);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(481, 161, 150, 20);
		pnlDatosEmpleado.add(txtDireccion);

		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(28, 206, 45, 16);
		pnlDatosEmpleado.add(lblSalario);

		txtSalario = new JTextField();
		txtSalario.setName("Salario");
		txtSalario.addActionListener(this);
		txtSalario.addKeyListener(this);
		txtSalario.addFocusListener(this);
		lblSalario.setLabelFor(txtSalario);
		txtSalario.setColumns(10);
		txtSalario.setBounds(144, 205, 150, 20);
		pnlDatosEmpleado.add(txtSalario);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.addFocusListener(this);
		btnNuevo.setBounds(28, 257, 101, 26);
		pnlDatosEmpleado.add(btnNuevo);

		btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(this);
		btnAsignar.addFocusListener(this);
		btnAsignar.setBounds(193, 257, 101, 26);
		pnlDatosEmpleado.add(btnAsignar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.addFocusListener(this);
		btnModificar.setBounds(365, 257, 101, 26);
		pnlDatosEmpleado.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.addFocusListener(this);
		btnEliminar.setBounds(530, 257, 101, 26);
		pnlDatosEmpleado.add(btnEliminar);

		JSeparator sprHorizontal_DatosTabla = new JSeparator();
		sprHorizontal_DatosTabla.setBounds(28, 304, 603, 2);
		pnlDatosEmpleado.add(sprHorizontal_DatosTabla);

		dtmDatosPersonales.setColumnCount(columnas.length);
		dtmDatosPersonales.setColumnIdentifiers(columnas);

		tblDatosPersonales = new JTable();
		tblDatosPersonales.setAutoscrolls(true);
		tblDatosPersonales.setModel(dtmDatosPersonales);

		JScrollPane scpDatosPersonales = new JScrollPane(tblDatosPersonales);
		scpDatosPersonales.setBounds(28, 326, 603, 218);
		pnlDatosEmpleado.add(scpDatosPersonales);

		JLabel lblTotalNomina = new JLabel("Total N\u00F3mina:");
		lblTotalNomina.setBounds(365, 558, 81, 16);
		pnlDatosEmpleado.add(lblTotalNomina);

		txtTotalNomina = new JTextField();
		txtTotalNomina.setText("$ 0");
		txtTotalNomina.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalNomina.setEditable(false);
		txtTotalNomina.setBounds(481, 556, 150, 20);
		pnlDatosEmpleado.add(txtTotalNomina);
		txtTotalNomina.setColumns(10);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(530, 595, 101, 26);
		pnlDatosEmpleado.add(btnSalir);
		
		JLabel lblAutores = new JLabel("Desarrollado por Diego L\u00F3pez y Richard Pardo");
		lblAutores.setForeground(new Color(204, 0, 0));
		lblAutores.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lblAutores.setBounds(322, 657, 352, 18);
		contentPane.add(lblAutores);
	}

	public List<JComponent> vectorComponentes() {
		List<JComponent> componentes = new ArrayList<>();
		componentes.add(txtCedula);
		componentes.add(txtNombres);
		componentes.add(txtApellidos);
		componentes.add(txtEdad);
		componentes.add(txtCargo);
		componentes.add(txtTelefono);
		componentes.add(txtDireccion);
		componentes.add(txtSalario);

		return componentes;
	}

	public boolean comprobarCamposEnBlanco(List<JComponent> componentes) {
		boolean sw = false;
		for (JComponent objeto : componentes) {
			if (((JTextField) objeto).getText().equals("")) {
				JOptionPane.showMessageDialog(this,
						String.format("El campo %s no puede estar vacío", ((JTextField) objeto).getName()),
						"Error de validación", JOptionPane.ERROR_MESSAGE);
				((JTextField) objeto).requestFocus();
				sw = true;
				break;
			}
		}
		return sw;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object objeto = ae.getSource();
		
		if (objeto.equals(txtCedula)) {
			comprobarCamposEnBlanco(vectorComponentes());
			
		} else if (objeto.equals(txtNombres)) {
			comprobarCamposEnBlanco(vectorComponentes());
			
		} else if (objeto.equals(txtApellidos)) {
			comprobarCamposEnBlanco(vectorComponentes());
			
		} else if (objeto.equals(txtEdad)) {
			comprobarCamposEnBlanco(vectorComponentes());
			
		} else if (objeto.equals(txtCargo)) {
			comprobarCamposEnBlanco(vectorComponentes());
			
		} else if (objeto.equals(txtTelefono)) {
			comprobarCamposEnBlanco(vectorComponentes());
			
		} else if (objeto.equals(txtDireccion)) {
			comprobarCamposEnBlanco(vectorComponentes());
			
		} else if (objeto.equals(txtSalario)) {
			boolean encontrar = false;

			if (!comprobarCamposEnBlanco(vectorComponentes())) {

				for (int i = 0; i < dtmDatosPersonales.getRowCount(); i++) {
					if (dtmDatosPersonales.getValueAt(i, 0).equals(txtCedula.getText())) {
						JOptionPane.showMessageDialog(this,
								"Usuaio con número de cédula " + txtCedula.getText() + " ya se encuentra registrado");
						encontrar = true;
						break;
					}
				}

				if (!encontrar) {
					Empleado empleado = new Empleado();
					empleado.setId(Long.parseLong(txtCedula.getText()));
					empleado.setNombre(txtNombres.getText());
					empleado.setApellido(txtApellidos.getText());
					empleado.setEdad(Integer.parseInt(txtEdad.getText()));
					empleado.setCargo(txtCargo.getText());
					empleado.setTelefono(Long.parseLong(txtTelefono.getText()));
					empleado.setDireccion(txtDireccion.getText());
					empleado.setSalario(Double.parseDouble(txtSalario.getText()));
					if (modificar) {
						listaEmpleado.set(filaSeleccionada, empleado);
						double salarioNuevo = listaEmpleado.get(filaSeleccionada).getSalario();
						dtmDatosPersonales.insertRow(filaSeleccionada, Empleado.convertirObjetoAVector(empleado));
						txtTotalNomina.setText("$ " + new BigDecimal(Empleado.calcularPagoNomina(salarioNuevo)).toPlainString());
					} else {
						listaEmpleado.add(empleado);
						dtmDatosPersonales.addRow(Empleado.convertirObjetoAVector(empleado));
						txtTotalNomina.setText("$ " + new BigDecimal(
								Empleado.calcularPagoNomina(listaEmpleado.get(listaEmpleado.size() - 1).getSalario()))
								.toPlainString());
					}
					modificar = false;
				}
				txtCedula.requestFocus();
			}
			
		} else if (objeto.equals(btnNuevo)) {
			txtCedula.setText("");
			txtNombres.setText("");
			txtApellidos.setText("");
			txtEdad.setText("");
			txtCargo.setText("");
			txtTelefono.setText("");
			txtDireccion.setText("");
			txtSalario.setText("");
			txtCedula.requestFocus();

		} else if (objeto.equals(btnAsignar)) {
			boolean encontrar = false;

			if (!comprobarCamposEnBlanco(vectorComponentes())) {

				for (int i = 0; i < dtmDatosPersonales.getRowCount(); i++) {
					if (dtmDatosPersonales.getValueAt(i, 0).equals(txtCedula.getText())) {
						JOptionPane.showMessageDialog(this,
								"Usuaio con número de cédula " + txtCedula.getText() + " ya se encuentra registrado");
						encontrar = true;
						break;
					}
				}

				if (!encontrar) {
					Empleado empleado = new Empleado();
					empleado.setId(Long.parseLong(txtCedula.getText()));
					empleado.setNombre(txtNombres.getText());
					empleado.setApellido(txtApellidos.getText());
					empleado.setEdad(Integer.parseInt(txtEdad.getText()));
					empleado.setCargo(txtCargo.getText());
					empleado.setTelefono(Long.parseLong(txtTelefono.getText()));
					empleado.setDireccion(txtDireccion.getText());
					empleado.setSalario(Double.parseDouble(txtSalario.getText()));
					if (modificar) {
						listaEmpleado.set(filaSeleccionada, empleado);
						double salarioNuevo = listaEmpleado.get(filaSeleccionada).getSalario();
						dtmDatosPersonales.insertRow(filaSeleccionada, Empleado.convertirObjetoAVector(empleado));
						txtTotalNomina.setText("$ " + new BigDecimal(Empleado.calcularPagoNomina(salarioNuevo)).toPlainString());
					} else {
						listaEmpleado.add(empleado);
						dtmDatosPersonales.addRow(Empleado.convertirObjetoAVector(empleado));
						txtTotalNomina.setText("$ " + new BigDecimal(
								Empleado.calcularPagoNomina(listaEmpleado.get(listaEmpleado.size() - 1).getSalario()))
								.toPlainString());
					}
					modificar = false;
				}
				txtCedula.requestFocus();
			}

		} else if (objeto.equals(btnModificar)) {
			modificar = true;
			filaSeleccionada = tblDatosPersonales.getSelectedRow();
			if (filaSeleccionada >= 0) {
				txtCedula.setText(tblDatosPersonales.getValueAt(filaSeleccionada, 0).toString());
				txtNombres.setText(tblDatosPersonales.getValueAt(filaSeleccionada, 1).toString());
				txtApellidos.setText(tblDatosPersonales.getValueAt(filaSeleccionada, 2).toString());
				txtEdad.setText(tblDatosPersonales.getValueAt(filaSeleccionada, 3).toString());
				txtCargo.setText(tblDatosPersonales.getValueAt(filaSeleccionada, 4).toString());
				txtTelefono.setText(tblDatosPersonales.getValueAt(filaSeleccionada, 5).toString());
				txtDireccion.setText(tblDatosPersonales.getValueAt(filaSeleccionada, 6).toString());
				txtSalario.setText(tblDatosPersonales.getValueAt(filaSeleccionada, 7).toString().replace("$ ", ""));
				dtmDatosPersonales.removeRow(filaSeleccionada);
				double salarioViejo = Double.parseDouble(txtSalario.getText());
				txtTotalNomina.setText("$ " + new BigDecimal(Empleado.calcularPagoNomina(-salarioViejo)).toPlainString());
				txtCedula.requestFocus();

			} else {
				JOptionPane.showMessageDialog(this, "Registro no seleccionado");
			}

		} else if (objeto.equals(btnEliminar)) {
			filaSeleccionada = tblDatosPersonales.getSelectedRow();
			if (filaSeleccionada >= 0) {
				dtmDatosPersonales.removeRow(filaSeleccionada);
				txtTotalNomina.setText("$ "+ String.valueOf(
						new BigDecimal(Empleado.calcularPagoNomina(-listaEmpleado.get(filaSeleccionada).getSalario()))
						.toPlainString()));
				listaEmpleado.remove(filaSeleccionada);
				txtCedula.requestFocus();

			} else {
				JOptionPane.showMessageDialog(this, "Registro no seleccionado");
			}

		} else if (objeto.equals(btnSalir)) {
			int opcion = JOptionPane.showConfirmDialog(this, "¿Estas seguro que desea salir?", "Información",
					JOptionPane.OK_CANCEL_OPTION);
			if (opcion == JOptionPane.OK_OPTION) {
				System.exit(0);
			}
		}

	}

	@Override
	public void focusGained(FocusEvent fe) {
		Object objeto = fe.getSource();

		if (objeto.equals(txtCedula)) {
			txtCedula.selectAll();

		} else if (objeto.equals(txtNombres)) {
			txtNombres.selectAll();

		} else if (objeto.equals(txtApellidos)) {
			txtApellidos.selectAll();

		} else if (objeto.equals(txtEdad)) {
			txtEdad.selectAll();

		} else if (objeto.equals(txtCargo)) {
			txtCargo.selectAll();

		} else if (objeto.equals(txtTelefono)) {
			txtTelefono.selectAll();

		} else if (objeto.equals(txtDireccion)) {
			txtDireccion.selectAll();

		} else if (objeto.equals(txtSalario)) {
			txtSalario.selectAll();

		}

	}

	@Override
	public void focusLost(FocusEvent fe) {
		Object objeto = fe.getSource();

		if (objeto.equals(btnEliminar)) {
			btnSalir.requestFocus();

		} else if (objeto.equals(btnSalir)) {
			txtCedula.requestFocus();
		}

	}

	@Override
	public void keyTyped(KeyEvent ke) {
		Object objeto = ke.getSource();
		char c = ke.getKeyChar();
		int code = ke.getKeyChar();

		if (objeto.equals(txtCedula)) {
			if (!Character.isDigit(c) && (c != '\b') && (code != KeyEvent.VK_ENTER)) {
				ke.consume();
				getToolkit().beep();
				JOptionPane.showMessageDialog(this, "Por favor digite solo números");
			}

		} else if (objeto.equals(txtNombres)) {
			if (!Character.isLetter(c) && !Character.isSpaceChar(c) && (c != '\b') && (code != KeyEvent.VK_ENTER)) {
				ke.consume();
				getToolkit().beep();
				JOptionPane.showMessageDialog(this, "Por favor digite solo letras");
			} else {
				ke.setKeyChar(Character.toUpperCase(c));
			}

		} else if (objeto.equals(txtApellidos)) {
			if (!Character.isLetter(c) && !Character.isSpaceChar(c) && (c != '\b') && (code != KeyEvent.VK_ENTER)) {
				ke.consume();
				getToolkit().beep();
				JOptionPane.showMessageDialog(this, "Por favor digite solo letras");
			} else {
				ke.setKeyChar(Character.toUpperCase(c));
			}

		} else if (objeto.equals(txtEdad)) {
			if (!Character.isDigit(c) && (c != '\b') && (code != KeyEvent.VK_ENTER)) {
				ke.consume();
				getToolkit().beep();
				JOptionPane.showMessageDialog(this, "Por favor digite solo números");
			}

		} else if (objeto.equals(txtCargo)) {
			if (!Character.isLetter(c) && !Character.isSpaceChar(c) && (c != '\b') && (code != KeyEvent.VK_ENTER)) {
				ke.consume();
				getToolkit().beep();
				JOptionPane.showMessageDialog(this, "Por favor digite solo letras");
			} else {
				ke.setKeyChar(Character.toUpperCase(c));
			}

		} else if (objeto.equals(txtTelefono)) {
			if (!Character.isDigit(c) && (c != '\b') && (code != KeyEvent.VK_ENTER)) {
				ke.consume();
				getToolkit().beep();
				JOptionPane.showMessageDialog(this, "Por favor digite solo números");
			}

		} else if (objeto.equals(txtDireccion)) {
			ke.setKeyChar(Character.toUpperCase(c));

		} else if (objeto.equals(txtSalario)) {
			if (!Character.isDigit(c) && (c != '\b') && (code != KeyEvent.VK_ENTER)) {
				ke.consume();
				getToolkit().beep();
				JOptionPane.showMessageDialog(this, "Por favor digite solo números");
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
