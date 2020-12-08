package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Operadora
 *
 */
@Entity
@Table(name="operadora")
public class Operadora implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="operadora")
	private List<Telefono> telefonos;
	
	public Operadora(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefonos = new ArrayList<Telefono>();
	}
	
	public Operadora() {
		
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	
	public void addTelefono(Telefono telefono) {
		this.telefonos.add(telefono);
	}
	
   
}
