package strategies;
import main.Pole;
import main.PoleForSale;
import main.Project;
import main.Seller;
import main.Solution;


public class EconomicStrategy extends OptimizingStrategy {

	public EconomicStrategy(Seller seller, Project project) {
		super(seller, project);
	}

	@Override
	protected int optimalizationCriterion(Solution solution) {
		return solution.getCost();
	}

	@Override
	public Solution optimalSolution(Pole[] poles) {
		//TODO
		Pole sumOfPoles = Pole.sum(poles);
		PoleForSale poleChoosen = null;
		PoleForSale[] offer = seller.presentOffer();
		
		for(int i = 0; i < offer.length; i++) {
			if (sumOfPoles.compareTo(offer[i]) >= 0) {
				if (poleChoosen == null) {
					poleChoosen = offer[i];
				}
				else {
					if (poleChoosen.price > offer[i].price) {
						poleChoosen = offer[i];
					}
				}
			}
		}
		if (poleChoosen == null) {
			return null;
		}
		else {
			return new Solution(poleChoosen, poles);
		}
	}

}
