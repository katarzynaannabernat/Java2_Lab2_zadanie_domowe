package pl.edu.agh.mwo.java2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;

public class Invoice {
	
	private ArrayList<Product> products;
	
	private Invoice() {
		this.products = new ArrayList<Product>();
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public void addProduct(Product product, Integer quantity) {
		if(quantity == null || quantity <= 0) {
			throw new IllegalArgumentException("Niepoprawna ilosc");
		}
		
		for(int i = 0; i < quantity; i++) {
			this.addProduct(product);
		}
	}
	
	public String getNumber() {
		// TODO: implement
		return null;
	}
	
	public BigDecimal getSubtotal() {
		BigDecimal total = new BigDecimal("0");
		for(Product product : this.products) {
			total = total.add(product.getPrice());
		}
		
		return total;
	}
	
	public BigDecimal getTax() {
		BigDecimal tax = new BigDecimal("0");
		for(Product product : this.products) {
			tax = tax.add(product.getPrice().multiply(product.getTaxPercent()));
		}
		
		return tax;
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal("0");
		for(Product product : this.products) {
			total = total.add(product.getPriceWithTax());
		}
		
		total = total.setScale(2, BigDecimal.ROUND_DOWN);
		return total;
	}
	
	public static Invoice create() {
		return new Invoice();
	}
	
}
