package strategies;
import main.Pole;
import main.PoleForSale;
import main.Project;
import main.Seller;


public class MaximalisticStrategy extends GreedyStrategy {
	
	public MaximalisticStrategy(Seller seller, Project project) {
		super(seller, project);
	}
	
	@Override
	protected PoleForSale choosePole(Pole pole) {
		return seller.presentOffer()[0];
	}

}
