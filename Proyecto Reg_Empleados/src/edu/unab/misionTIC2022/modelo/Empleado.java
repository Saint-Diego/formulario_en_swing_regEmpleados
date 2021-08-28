package edu.unab.misionTIC2022.modelo;

public class Empleado {
	private Long id;
	private String nombre;
	private String apellido;
	private int edad;
	private String cargo;
	private Long telefono;
	private String direccion;
	private double salario;
	private static double totalSalario = 0.0;

	public Empleado() {
		this.id = 0L;
		this.nombre = "";
		this.apellido = "";
		this.edad = 0;
		this.cargo = "";
		this.telefono = 0L;
		this.direccion = "";
		this.salario = 0.0;
	}

	public Empleado(Long id, String nombre, String apellido, int edad, String cargo, Long telefono, String direccion,
			double salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.cargo = cargo;
		this.direccion = direccion;
		this.telefono = telefono;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", cargo="
				+ cargo + ", telefono=" + telefono + ", direccion=" + direccion + ", salario=" + salario + "]";
	}

	public static String[] convertirObjetoAVector(Empleado empleado) {

		return new String[] { "" + empleado.getId(), empleado.getNombre(), empleado.getApellido(),
				"" + empleado.getEdad(), empleado.getCargo(), "" + empleado.getTelefono(), empleado.getDireccion(),
				"$ " + empleado.getSalario() };
	}

	public static double calcularPagoNomina(double valor) {
		totalSalario += valor;
		return totalSalario;
	}
}
