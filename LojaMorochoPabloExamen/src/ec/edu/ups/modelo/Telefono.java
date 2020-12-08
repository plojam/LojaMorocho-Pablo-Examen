package ec.edu.ups.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Telefono
 *
 */
@Entity
@Table(name="telefono")
public class Telefono implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String numero;
	@ManyToOne
	@JoinColumn
	private TipoTelefono tipo;
	@ManyToOne
	@JoinColumn
	private Operadora operadora;
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	
	public Telefono(int id, String numero, TipoTelefono tipo, Operadora operadora, Usuario usuario) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
		this.usuario = usuario;
	}
	
	public Telefono() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoTelefono getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefono tipo) {
		this.tipo = tipo;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
   
}
