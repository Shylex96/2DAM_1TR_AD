package es.studium.hibernate;

public class Usuario {
	private int id;
	private String nombre;
	private String clave;
	public Usuario() {
		this.id = 0;
		this.nombre =
				"";
		this.clave =
				"";
	}
	public Usuario(int id) {
		this.id = id;
	}
	public Usuario(String n, String c) {
		this.id = 0;
		this.nombre = n;
		this.clave = c;
	}
	public Usuario(int id, String nombre, String clave) {
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String n) {

		this.nombre = n;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String c) {
		this.clave = c;
	}
}