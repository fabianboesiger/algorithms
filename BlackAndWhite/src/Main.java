import java.util.Random;

public class Main {
	
	private static final int BLACKS = 3;
	private static final int WHITES = 3;
	
	private static final int SIMULATION_ITERATIONS = 10000;
	
	private static Random random;

	public static void main(String[] args) {
		
		random = new Random();
		
		System.out.println("Estimate: "+simulationProbability(BLACKS, WHITES));
		System.out.println("Calculated: "+calculateProbability(BLACKS, WHITES));

	}
	
	private static double calculateProbability(int m, int n) {
		
		double[][] table = new double[m][m+n];
				
		for(int i = 0; i < table.length; i++) {
			for(int j = i; j < table[i].length; j++) {
				
				// Probability that a black piece gets drawn at that specific point in the game
				double p = (double) (m-i)/((m+n)-j);
				// Define diagonal elements
				if(i == j) {
					if(i == 0) {
						// Define first element
						table[i][j] = p;
					}else {
						// Define first element in row
						table[i][j] = table[i-1][j-1] * p;
					}
				}else {
					// Normal procedure
					double a = 1;
					for(int k = i; k < j; k++) {
						a *= (1-table[i][k]);
					}
					table[i][j] = a * p;
				}
				
			}
		}
		
		// For testing purposes
		printTable(table);
		
		double output = 0;
		
		// Add probabilities for final result
		for(int i = m-1; i < m+n; i++) {
			if(i%2 == 0) {
				output += table[table.length-1][i];
			}
		}
		
		return output;
		
	}
	
	private static void printTable(double[][] table) {
		System.out.println();
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table[i].length; j++) {
				System.out.print(Math.round(table[i][j]*1000)/1000.0+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static double simulationProbability(int m, int n) {
		int counter = 0;
		for(int i = 0; i < SIMULATION_ITERATIONS; i++) {
			if(simulate(m, n)) {
				counter++;
			}
		}
		return (double) counter/SIMULATION_ITERATIONS;
	}
	
	private static boolean simulate(int m, int n) {
		int counter = 0;
		while(m > 0) {
			if(random.nextDouble() < (float) m/(m+n)) {
				m--;
			}
			counter++;
		}
		return (counter%2 == 1);
	}

}
