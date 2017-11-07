package crud.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author danilocavalcanti
 *
 */
@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 569472607854061825L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_plano", nullable = true)
	private Plano plano;

	public Cliente() {
	};
	
	public Cliente(String nome) {
		this.nome = nome;
	}

	public Cliente(String nome, Plano plano) {
		this.nome = nome;
		this.plano = plano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

}
