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
		/*
		 * Each cell shows the probability that this cell gets visited and a black
		 * stone gets drawn, keep this in mind when reading the following comments
		 */
		double[][] table = new double[m][m+n];
				
		for(int i = 0; i < table.length; i++) {
			for(int j = i; j < table[i].length; j++) {
				/*
				 * Probability that a black stone gets drawn at that specific point
				 * in the game
				 */
				double p = (double) (m-i)/((m+n)-j);
				if(i == j) {
					// Define diagonal elements
					if(i == 0) {
						/*
						 * Define first element, probability that it gets visited is 1,
						 * multiplied with the probability that a black stone gets drawn
						 */
						table[i][j] = 1 * p;
					}else {
						/*
						 * Define diagonal element in each row with probability that a black
						 * stone was drawn previously multiplied with the probability that a 
						 * black stone will be drawn
						 */
						table[i][j] = table[i-1][j-1] * p;
					}
				}else {
					// Now the magic happens, it's difficult to explain
					if(i == 0) {
						/*
						 * In the first row, the probability is calculated with the probability
						 * that never a black stone was drawn, multiplied with the probability
						 * that a black stone is drawn
						 */
						double q = (double) (m-i)/((m+n)-(j-1));
						table[i][j] = table[i][j-1]/q*(1-q) * p;
					}else {
						/*
						 * In every other row, the probability is calculated with the probability
						 * that a white stone is drawn in the cell to the left of the current cell,
						 * added with the probability that a black stone is drawn in the top left
						 * cell. This is the probability that this cell gets visited. This probability
						 * is multiplied with the probability that a black stone gets drawn.
						 */
						double q = (double) (m-i)/((m+n)-(j-1));
						table[i][j] = (table[i][j-1]/q*(1-q) + table[i-1][j-1]) * p;
					}
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
			}else {
				n--;
			}
			counter++;
		}
		return (counter%2 == 1);
	}

}
