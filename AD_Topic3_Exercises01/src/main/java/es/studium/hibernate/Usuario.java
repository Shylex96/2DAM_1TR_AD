package es.studium.hibernate;

/*A partir de la versión 6 de Hibernate estos son los paquetes que
debemos importar */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/* Se puede especificar en la anotación, además del nombre de la
tabla, el nombre de la base de datos */
@Entity
@Table(name = "users", schema = "adt3_hibernate")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private int id;
	@Column(name = "nombreUsuario")
	private String nombre;
	@Column(name = "passUsuario")
	private String clave;
	
	public Usuario() {
		this.id = 0;
		this.nombre = "";
		this.clave = "";
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
