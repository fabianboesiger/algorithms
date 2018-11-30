//=======================================================================================================
// Exercise     : AD18H9P1.RealCoins
// Template URL : https://www.cadmo.ethz.ch/education/lectures/HS18/DA/uebungen/AD18H9P1.RealCoins.zip
// Author       :  
//=======================================================================================================

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.math.BigInteger;

class Main {
		
	public static void read_and_solve(InputStream in, PrintStream out) {

		Scanner scanner = new Scanner(in);
		//
		// Get N & K
		//
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		
		BigInteger[] coins = new BigInteger[N+1];
		BigInteger[] table = new BigInteger[K+1];
		
		for(int i = 0; i < N; i++) {
			coins[i] = BigInteger.valueOf(scanner.nextInt());
		}

		for(int i = 0; i < K; i++) {
				if(BigInteger.valueOf(i+1).compareTo(coins[0]) == 0) {
					table[i] = BigInteger.ONE;
				}else {
					table[i] = BigInteger.ZERO;
				}
			}
		}
		
		for(int j = 0; j < N; j++) {
			for(int i = K-1; i >= 0; i--) {
				table[i] = 
			}
		}
		
		//
		// Provide your solution here ...
		//
		// out.println(result.toString());		
		
		out.println("");
				
		scanner.close();
	}

	//
	// Do not modify the main method, and keep the method read_and_solve
	// 
	public static void main(String[] args) {	
		read_and_solve(System.in, System.out);		
	}
}