package br.com.stock.model;

public enum StockLevel {

	HIGH, NORMAL, LOW, CRITICAL;

	public static StockLevel byBagQuantity(int bags) {
		if (bags >= 6) {
			return StockLevel.HIGH;
		} else if (bags < 6 && bags >= 4) {
			return StockLevel.NORMAL;
		} else if (bags < 4 && bags >= 2) {
			return StockLevel.LOW;
		} else {
			return StockLevel.CRITICAL;
		}
	}

}
