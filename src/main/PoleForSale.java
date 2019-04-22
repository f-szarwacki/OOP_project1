package main;

public class PoleForSale extends Pole {
	// class representing a pole in seller's offer
	
	public final int price;
	
	PoleForSale(int length, int price) {
		super(length);
		this.price = price;
	}
	
	PoleForSale(PoleForSale pole) {
		super(pole);
		this.price = pole.price;
	}
	
	@Override
	public String toString() {
		String s = "Pole for sale of length " + this.length + " costing " + price + "\n";
		return s;
	}
}
