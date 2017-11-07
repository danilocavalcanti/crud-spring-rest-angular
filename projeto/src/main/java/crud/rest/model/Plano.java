package crud.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author danilocavalcanti
 *
 */
@Entity
public class Plano implements Serializable {

	private static final long serialVersionUID = 7160058287105541964L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String nome;

	public Plano() {
	};

	public Plano(String nome) {
		this.nome = nome;
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

}
