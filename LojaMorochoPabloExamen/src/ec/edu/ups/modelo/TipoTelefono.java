package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoTelefono
 *
 */
@Entity
@Table(name="tipoTelefono")
public class TipoTelefono implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String tipo;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
	private List<Telefono> telefonos;
	
	public TipoTelefono(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.telefonos = new ArrayList<Telefono>();
	}
   
	public TipoTelefono() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
