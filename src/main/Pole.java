package main;

public class Pole implements Comparable<Pole> {
	// class representing a singular pole in either project or seller's offer
	
	protected int length;
	
	Pole(int length) {
		this.length = length;
	}
	
	Pole(Pole pole) {
		this.length = pole.length;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public boolean cut(Pole cutPoint) {
		// cuts off a given pole from current and returns whether it was possible
		
		if(cutPoint.getLength() <= length) {
			int newLength = length - cutPoint.getLength();
			length = newLength;	
			return true;
		}
		return false;
	}
	
	public static Pole sum(Pole... poles) {
		// "glues" an array of poles into one to easily operate on sum of their lengths
		
		int sumOfLengths = 0;
		for (int i = 0; i < poles.length; i++) {
			sumOfLengths += poles[i].getLength();
		}
		return new Pole(sumOfLengths);
	}
	
	public void add(Pole other) {
		this.length += other.length;
	}
	
	@Override
	public int compareTo(Pole other) {
		// compares poles in descending order
		
		if (this.length > other.length) {
			return -1;
		}
		else if (this.length < other.length) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		String s = "Pole of length: " + length + "\n";
		return s;
	}
}
