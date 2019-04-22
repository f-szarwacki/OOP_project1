package strategies;
import main.Project;
import main.Seller;
import main.Solution;

public abstract class Strategy {
	// abstract class representing strategies
	
	protected Seller seller;
	protected Project project;
	
	Strategy(Seller seller, Project project) {
		this.seller = seller;
		this.project = project;
	}
	
	public abstract Solution giveSolution();
}
