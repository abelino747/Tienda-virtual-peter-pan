package modelo;

public class ClientesDTO {

	private long cedula_cliente;
	private String nombre_cliente;
	private String direccion_cliente;
	private String email_cliente;
	private String telefono_cliente;
	
	 public ClientesDTO(long cedula_cliente, String nombre_cliente, String direccion_cliente, String email_cliente,
			String telefono_cliente) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.direccion_cliente = direccion_cliente;
		this.email_cliente = email_cliente;
		this.telefono_cliente = telefono_cliente;
	}

	 // constructor para consultar los clientes desde la cedula
	public ClientesDTO(long cedula_cliente) {
		
		this.cedula_cliente = cedula_cliente;
	}

	public long getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(String telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
	}
	 
	 
	 
}
