package main;

import java.util.*;

import strategies.EcologicStrategy;
import strategies.EconomicStrategy;
import strategies.MaximalisticStrategy;
import strategies.MinimalisticStrategy;
import strategies.Strategy;

public class Main {
	public static void main(String[] args) {
		// reading input
		Scanner in = new Scanner(System.in);
		
		int C = in.nextInt();
		PoleForSale[] polesForSale = new PoleForSale[C];
		for (int i = 0; i < C; i++){
			int length = in.nextInt();
			int price = in.nextInt();
			polesForSale[i] = new PoleForSale(length, price);
		}
		
		Seller seller = new Seller(polesForSale);
		
		int P = in.nextInt();
		Pole[] polesInProject = new Pole[P];
		for (int i = 0; i < P; i++) {
			int length = in.nextInt();
			polesInProject[i] = new Pole(length);
		}
		
		Project project = new Project(polesInProject);
		
		String strategyOption = in.next();
		
		in.close();
		
		Strategy strategy;
		
		
		// choosing strategy
		switch (strategyOption) {
			case "minimalistyczna":
				strategy = new MinimalisticStrategy(seller, project);
				break;
			case "maksymalistyczna":
				strategy = new MaximalisticStrategy(seller, project);
				break;
			case "ekologiczna":
				strategy = new EcologicStrategy(seller, project);
				break;
			case "ekonomiczna":
				strategy = new EconomicStrategy(seller, project);
				break;
			default:
				strategy = new MaximalisticStrategy(seller, project);
		}
		
		// obtaining solution
		Solution result = strategy.giveSolution();
		
		System.out.print(result);
	}
}
