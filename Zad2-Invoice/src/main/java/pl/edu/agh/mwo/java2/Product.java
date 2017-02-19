package pl.edu.agh.mwo.java2;

import java.math.BigDecimal;

public class Product {
	
	private static final BigDecimal DEFAULT_TAX = BigDecimal.valueOf(0.23);
	
	private final String name;
	
	private final BigDecimal price;
	
	private final BigDecimal taxPercent;
	
	private Product(final String name, final BigDecimal price, final BigDecimal tax) {
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
		
		if (name == null) {
			throw new IllegalArgumentException("Nie mo¿na podaæ NULL jako nazwa produktu");
		}
		if (this.name.length() == 0) {
			  throw new IllegalArgumentException("Nazwa produktu nie mo¿e byæ pustym stringiem");
			}
		if (price == null) {
			throw new IllegalArgumentException("Nie mo¿na podaæ NULL jako cena produktu");
		}
		if (price.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Cena nie mo¿e byæ ujemna");
		}
		if (tax == null) {
			throw new IllegalArgumentException("Podatek nie mo¿e przyjmowaæ wartoœci NULL");
		}
		if (tax.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Podatek nie mo¿e byæ ujemny");
		}
	}

	public String getName() {
		return name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public BigDecimal getTaxPercent() {
		return taxPercent;
	}
	
	public BigDecimal getPriceWithTax() {
		return price.add(price.multiply(taxPercent));
	}
	
	public static Product create(final String name, final BigDecimal price, final BigDecimal tax) {
		return new Product(name, price, tax);
	}
	
	public static Product create(final String name, final BigDecimal price) {
		return create(name, price, DEFAULT_TAX);
	}
}
