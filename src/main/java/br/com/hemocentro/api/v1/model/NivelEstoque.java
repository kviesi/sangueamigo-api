package br.com.hemocentro.api.v1.model;

public enum NivelEstoque {

	ALTO, NORMAL, BAIXO, CRITICO;

	public static NivelEstoque byBagQuantity(int bags) {
		if (bags >= 6) {
			return NivelEstoque.ALTO;
		} else if (bags < 6 && bags >= 4) {
			return NivelEstoque.NORMAL;
		} else if (bags < 4 && bags >= 2) {
			return NivelEstoque.BAIXO;
		} else {
			return NivelEstoque.CRITICO;
		}
	}

}
