import java.util.Random;

public class Main {
	
	public static final int TESTS = 10;
	public static final int ITERATIONS = 100000;
	
	public static void main(String[] args) {
		
		Random random = new Random();
		
		for(int t = 0; t < TESTS; t++) {
		
			int balls = 1 + random.nextInt(1000);
			int[] bins = new int[1 + random.nextInt(1000)];
			
			int firstEmpty = 0;
			int firstAndSecondEmpty = 0;
			int firstCount = 0;
			int emptyCount = 0;
			
			for(int i = 0; i < ITERATIONS; i++) {
				
				for(int j = 0; j < bins.length; j++) {
					bins[j] = 0;
				}
				
				for(int j = 0; j < balls; j++) {
					bins[random.nextInt(bins.length)]++;
				}
				
				if(bins[0] == 0) {
					firstEmpty++;
				}
				if(bins[0] == 0 && bins[1] == 0) {
					firstAndSecondEmpty++;
				}
				firstCount += bins[0];
				for(int bin : bins) {
					if(bin == 0) {
						emptyCount++;
					}
				}
			
			}
			
			double simulated = (double) emptyCount/ITERATIONS;
			double calculated = Math.pow(1 - (double) 1/bins.length, balls) * bins.length;
			double result = (1 - Math.abs(simulated - calculated));
			System.out.println("Test (Bins: " + bins.length + ", Balls: " + balls + ") is correct with " + (result * 100) + "% (Simulated: " + simulated + ", Calculated: " + calculated + ") probability");
		
		}
		
	}

}
