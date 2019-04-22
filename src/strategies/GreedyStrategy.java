package strategies;

import java.util.ArrayList;

import main.Pole;
import main.PoleForSale;
import main.Project;
import main.Seller;
import main.Solution;


public abstract class GreedyStrategy extends Strategy {
	// class representing greedy strategies
	
	GreedyStrategy(Seller seller, Project project) {
		super(seller, project);
	}
	
	@Override
	public Solution giveSolution() {
		Solution solution = new Solution();
		Pole[] poles = project.getProject();
		
		boolean[] alreadyCut = new boolean[poles.length];
		
		for (int i = 0; i < poles.length; i++) {
			if (!alreadyCut[i]) {
				
				ArrayList<Pole> subdivision = new ArrayList<>();
				PoleForSale currentPoleToCut = this.choosePole(poles[i]);
				int lengthOfPoleToCut = currentPoleToCut.getLength();
				//TODO this should be changed
				
				for (int j = i; j < poles.length; j++) {
					if (!alreadyCut[j]) {
						if (currentPoleToCut.cut(poles[j])) {
							alreadyCut[j] = true;
							subdivision.add(poles[j]);
							
						}
					}
				}
				
				solution.add(currentPoleToCut.price, currentPoleToCut.getLength(), lengthOfPoleToCut, subdivision);
				
			}
		}
		
		
		return solution;
	}
	
	// TODO this one needs renaming
	protected abstract PoleForSale choosePole(Pole pole);

}
