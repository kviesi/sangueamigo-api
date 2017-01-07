package br.com.hemocentro.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sa_estoque")
public class Estoque {

	@Id
	private Long id;
	private BloodType bloodType;
	private int bags;

	@ManyToOne
	@JoinColumn(name = "hemocentro_id")
	private Hemocentro hemocentro;

	public NivelEstoque getNivelEstoque() {
		return NivelEstoque.byBagQuantity(bags);
	}

	public int getBags() {
		return bags;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

}
