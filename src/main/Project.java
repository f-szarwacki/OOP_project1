package main;
import java.util.*;

public class Project {
	// class representing project of construction ie set of poles to be bought
	
	// poles are kept in descending order (by length)
	private Pole[] project;
	
	Project(Pole[] poles) {
		project = poles;
		Arrays.sort(project);
	}
	
	public Pole[] getProject(){
		return project;
	}
	
	public int lengthOfProject() {
		return project.length;
	}
	
	@Override
	public String toString() {
		String s = "Project consisting of poles: \n";
		for (int i = 0; i < project.length; i++) {
			s += project[i].toString();
		}
		return s;
	}
	
}
