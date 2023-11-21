package hibernate.anotaciones;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies", schema = "adt3_hibernate")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPelicula")
	private int id;
	@Column(name = "tituloPelicula")
	private String titulo;
	@Column(name = "anioPelicula")
	private int anio;
	@Column(name = "duracionPelicula")
	private int duracion;
	
	@ManyToOne
	@JoinColumn(name = "directorPeliculaFK")
	private Persona director;
	
	public Pelicula() {
		this.id = 0;
		this.titulo = "";
		this.anio = 0;
		this.duracion = 0;
		this.director = new Persona();
	}

	public Pelicula(int id) {
		this.id = id;
	}

	public Pelicula(String t, int a, int dur, Persona dir) {
		this.id = 0;
		this.titulo = t;
		this.anio = a;
		this.duracion = dur;
		this.director = dir;
	}

	public Pelicula(int id, String titulo, int anio, int dur, Persona dir) {
		this.id = id;
		this.titulo = titulo;
		this.anio = anio;
		this.duracion = dur;
		this.director = dir;
	}

	public int getId() {
		return id;
	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Persona getDirector() {
		return director;
	}

	public void setDirector(Persona director) {
		this.director = director;
	}
}
