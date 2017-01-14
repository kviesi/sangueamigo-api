package br.com.stock.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.hemocentro.api.model.BloodType;
import br.com.hemocentro.api.model.Hemocentro;

@Entity
@Table(name = "sa_estoque")
public class Stock {

	@Id
	private Long id;
	private BloodType bloodType;
	private int bags;

	@ManyToOne
	@JoinColumn(name = "hemocentro_id")
	private Hemocentro hemocentro;

	public StockLevel getNivelEstoque() {
		return StockLevel.byBagQuantity(bags);
	}

	public int getBags() {
		return bags;
	}

	public BloodType getBloodType() {
		return bloodType;
	}

}
