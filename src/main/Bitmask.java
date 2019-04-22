package main;

public class Bitmask implements Comparable<Bitmask> {
	// class to represent subsets of poles included in project
	private int bitmask;
	private int numOfElements;
	private int numOfBitsActive;
	
	
	public Bitmask(int numOfElements) {
		// constructor of empty subset
		
		this.numOfElements = numOfElements;
		this.bitmask = 0;
		this.numOfBitsActive = 0;
	}
	
	
	public Bitmask(int numOfElements, int bitmask) {
		// constructor of subset of given bitmask
		
		this.numOfElements = numOfElements;
		this.bitmask = bitmask;
		this.numOfBitsActive = 0;
		for (int i = 0; i < numOfElements; i++) {
			if ((1 << i & bitmask) != 0) {
				this.numOfBitsActive++;
			}
		}
	}
	
	
	public Bitmask next() {
		// giving next (as a binary number) subset
		// or null if current subset is the whole set
		
		if (this.bitmask == (1 << this.numOfElements) - 1) {
			return null;
		}
		return new Bitmask(this.numOfElements, this.bitmask + 1);
	}
	
	
	public Bitmask[] getSubsets() {
		// gives an array of all subsets of given subset
		
		int i = 0;
		while (((1 << i) & (this.bitmask)) == 0 && i <= numOfElements - 1) {
			i++;
		}
		if (i == numOfElements) {
			Bitmask[] result = new Bitmask[1];
			result[0] = new Bitmask(numOfElements, 0);
			return result;
		}
		else {
			Bitmask[] subjob = new Bitmask(this.numOfElements, this.bitmask ^ (1 << i)).getSubsets();
			
			Bitmask[] result = new Bitmask[2 * subjob.length];
			for (int j = 0; j < subjob.length; j++) {
				result[j] = subjob[j];
				result[j + subjob.length] = new Bitmask(numOfElements, subjob[j].bitmask ^ (1 << i));
			}
			return result;
		}
	}
	
	public Bitmask completion(Bitmask subset) {
		// gives the completion of argument to subset
		
		return new Bitmask(this.numOfElements, this.bitmask ^ subset.bitmask);
	}
	
	public int compareTo(Bitmask other) {
		// implementing inclusion comparison
		
		if (this.bitmask < other.bitmask) {
			return -1;
		}
		else if (this.bitmask > other.bitmask) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		// representing subset as binary number
		
		String s = "";
		for (int i = numOfElements - 1; i >= 0; i--) {
			if ((1 << i & bitmask) == 0) {
				s += "0";
			}
			else {
				s += "1";
			}
		}
		return s;
	}
	
	public Pole[] givePoles(Project project) {
		// given a project it returns array of poles from project which correspond
		// to elements in current subset
		
		Pole[] poles = project.getProject();
		Pole[] result = new Pole[this.numOfBitsActive];
		int it = 0;
		for (int i = 0; i < numOfElements; i++) {
			if ((1 << i & bitmask) != 0) {
				result[it] = new Pole(poles[i]);
				it++;
			}
		}
		return result;
	}
}
