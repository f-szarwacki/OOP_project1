package main;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	// class to represent a solution to problem (or part of it)
	// ie what poles are being bought, for what price, how they're cut
	// and what the waste is
	
	private int cost;
	private int waste;
	private ArrayList<ArrayList<Pole> > division;
	private ArrayList<Integer> lengthsOfPolesUsed;
	
	public Solution() {
		cost = 0;
		waste = 0;
		division = new ArrayList<ArrayList<Pole> >();
		lengthsOfPolesUsed = new ArrayList<Integer>();
	}
	
	public Solution(PoleForSale poleBought, Pole[] poles) {
		// constructor of solution: buy poleBought and cut it into poles
		// assuming it is possible
		
		cost = poleBought.price;
		waste = poleBought.getLength() - Pole.sum(poles).getLength();
		division = new ArrayList<ArrayList<Pole> >();
		division.add(new ArrayList<Pole>(Arrays.asList(poles)));
		lengthsOfPolesUsed = new ArrayList<Integer>();
		lengthsOfPolesUsed.add(poleBought.getLength());
	}
	
	public void add(int cost, int waste, int lengthOfPoleUsed, ArrayList<Pole> subdivision) {
		// to an existing solution add a new division of pole bought and recount cost and waste
		
		this.cost += cost;
		this.waste += waste;
		this.division.add(subdivision);
		this.lengthsOfPolesUsed.add(lengthOfPoleUsed);
	}
	
	public static Solution merge(Solution a, Solution b) {
		// merge two solutions:
		// ie buy all the poles, split them as in projects
		// and sum up cost and waste
		
		if (a == null || b == null) {
			return null;
		}
		
		Solution result = new Solution();
		result.cost = a.cost + b.cost;
		result.waste = a.waste + b.waste;
		result.division.addAll(a.division);
		result.division.addAll(b.division);
		result.lengthsOfPolesUsed.addAll(a.lengthsOfPolesUsed);
		result.lengthsOfPolesUsed.addAll(b.lengthsOfPolesUsed);
		return result;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getWaste() {
		return waste;
	}
	
	@Override
	public String toString() {
		String s = "";
		s += cost + "\n" + waste + "\n";
		for (int i = 0; i < division.size(); i++){

			s += lengthsOfPolesUsed.get(i);
			for (int j = 0; j < division.get(i).size(); j++) {
				s += " " + division.get(i).get(j).getLength();
			}
			s += "\n";
		}
		return s;
	}
}
