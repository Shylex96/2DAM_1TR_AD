package hibernate.anotaciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas", schema = "adt3_hibernate")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPersonas")
	private int id;
	@Column(name = "nombrePersona")
	private String nombre;
	
	public Persona() {
		this.id = 0;
		this.nombre = "";

	}

	public Persona(int id) {
		this.id = id;
	}

	public Persona(String n) {
		this.id = 0;
		this.nombre = n;
	}

	public Persona(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
