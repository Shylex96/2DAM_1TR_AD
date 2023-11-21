package hibernate.anotaciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dogs", schema = "adt3_hibernate")
public class Perro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPerro")
	private int id;
	@Column(name = "razaPerro")
	private String raza;
	@Column(name = "tamanoPerro")
	private String tamano;
	@Column(name = "edadPerro")
	private int edad;
	@Column(name = "colorPerro")
	private String color;
	
	public Perro() {
		this.id = 0;
		this.raza = "";
		this.tamano = "";
		this.edad = 0;
		this.color = "";
	}

	public Perro(int id) {
		this.id = id;
	}

	public Perro(String r, String t, int  e, String c) {
		this.id = 0;
		this.raza = r;
		this.tamano = t;
		this.edad = e;
		this.color = c;
	}

	public Perro(int id, String raza, String tamano, int edad, String color) {
		this.id = id;
		this.raza = raza;
		this.tamano = tamano;
		this.edad = edad;
		this.color = color;
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
