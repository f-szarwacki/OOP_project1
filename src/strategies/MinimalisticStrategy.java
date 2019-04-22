package strategies;
import main.Pole;
import main.PoleForSale;
import main.Project;
import main.Seller;


public class MinimalisticStrategy extends GreedyStrategy {

	public MinimalisticStrategy(Seller seller, Project project) {
		super(seller, project);
	}
	
	@Override
	protected PoleForSale choosePole(Pole pole) {
		PoleForSale[] offer = seller.presentOffer();
		int i = 0;
		int j = offer.length - 1;
		
		while(j - i > 1) {
			int s = (i + j) / 2;
			if (pole.compareTo(offer[s]) <= 0) {
				j = s;
			}
			else {
				i = s;
			}
		}
		//if (pole.compareTo(offer[j]))
		
		
		return offer[j];
	}

}
