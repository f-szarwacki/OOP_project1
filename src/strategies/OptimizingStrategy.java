package strategies;


import java.util.TreeMap;

import main.Bitmask;
import main.Pole;
import main.Project;
import main.Seller;
import main.Solution;


public abstract class OptimizingStrategy extends Strategy {

	private int lengthOfProject;
	
	OptimizingStrategy(Seller seller, Project project) {
		super(seller, project);
		this.lengthOfProject = project.lengthOfProject();
	}
	
	
	@Override
	public Solution giveSolution() {
		TreeMap<Bitmask, Solution> dp = new TreeMap<Bitmask, Solution>();
		Bitmask current = new Bitmask(lengthOfProject);
		dp.put(current, new Solution());
		
		do {
			current = current.next();
			//TODO renaming
			Bitmask[] toConsider = current.getSubsets();
			Solution bestSolution = null;
			for (int i = 0; i < toConsider.length - 1; i++) {
				//TODO needs renaming
				Solution sol = optimalSolution(current.completion(toConsider[i]).givePoles(project));
				Solution newSolution = Solution.merge(dp.get(toConsider[i]), sol);
				
				if (bestSolution == null) {
					bestSolution = newSolution;
				}
				else {
					if (newSolution != null) {
						if (optimalizationCriterion(newSolution) < optimalizationCriterion(bestSolution)) {
							bestSolution = newSolution;
						}
					}
				}
			
			}
			dp.put(current, bestSolution);
			
		}
		while (current.next() != null);
		
		return dp.get(current);
	}
	
	public abstract Solution optimalSolution(Pole[] poles);
	
	protected abstract int optimalizationCriterion(Solution solution);

}
