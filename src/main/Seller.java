package main;
import java.util.*;

public class Seller {
	// class to represent seller's offer
	
	// poles are kept in descending order (by length)
	private PoleForSale[] offer;
	
	Seller(PoleForSale[] polesForSale) {
		this.offer = polesForSale;
		Arrays.sort(offer);
	}
	
	@Override
	public String toString() {
		String s = "Seller has those poles in offer:\n";
		for (int i = 0; i < offer.length; i++) {
			s += offer[i].toString();
		}
		return s;
	}
	
	public PoleForSale[] presentOffer() {
		// returns a copy of offer
		
		PoleForSale[] offerToPresent = new PoleForSale[offer.length];
		for (int i = 0; i < offer.length; i++) {
			offerToPresent[i] = new PoleForSale(offer[i]);
		}
		return offerToPresent;
	}
	
}
