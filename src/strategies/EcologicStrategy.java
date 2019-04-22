package strategies;

import main.Pole;
import main.PoleForSale;
import main.Project;
import main.Seller;
import main.Solution;


public class EcologicStrategy extends OptimizingStrategy {

	public EcologicStrategy(Seller seller, Project project) {
		super(seller, project);
	}

	@Override
	protected int optimalizationCriterion(Solution solution) {
		return solution.getWaste();
	}
	
	@Override
	//TODO change visibility after testing
	public Solution optimalSolution(Pole[] poles) {
		//TODO
		Pole sumOfPoles = Pole.sum(poles);
		
		PoleForSale[] offer = seller.presentOffer();
		
		Solution solution = null;
		
		for (int i = 0; i < offer.length; i++) {
			if (sumOfPoles.compareTo(offer[i]) >= 0) {
				Solution newSolution = new Solution(offer[i], poles);
				if (solution == null) {
					solution = newSolution;
				}
				else {
					if (solution.getWaste() > newSolution.getWaste()) {
						solution = newSolution;
					}
				}
			}
		}
		
		return solution;
	}

}
