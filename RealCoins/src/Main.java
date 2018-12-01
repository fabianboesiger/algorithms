//=======================================================================================================
// Exercise     : AD18H9P1.RealCoins
// Template URL : https://www.cadmo.ethz.ch/education/lectures/HS18/DA/uebungen/AD18H9P1.RealCoins.zip
// Author       :  
//=======================================================================================================

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
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
		
		int[] coins = new int[N];
		BigInteger[] table = new BigInteger[K+1];
		
		for(int i = 0; i < N; i++) {
			coins[i] = scanner.nextInt();
		}
		
		for(int i = 1; i < K+1; i++) {
			table[i] = BigInteger.ZERO;
		}
		table[0] = BigInteger.ONE;
		
		if(coins[0] <= K) {
			table[coins[0]] = BigInteger.ONE;
		}
				
		for(int i = 1; i < N; i++) {
			
			for(int j = K; j > 0; j--) {
				if(j-coins[i] >= 0) {
					table[j] = table[j].add(table[j-coins[i]]);
				}
			}
		}
		
		//
		// Provide your solution here ...
		//
		// out.println(result.toString());	
		
		BigInteger output = BigInteger.valueOf(2).pow(N);
				
		for(int i = 0; i < K; i++) {
			output = output.subtract(table[i]).subtract(table[i]);
		}
		
		if(output.compareTo(BigInteger.ZERO) == -1) {
			out.println(0);
		}else {
			out.println(output);
		}
				
		scanner.close();
	}

	//
	// Do not modify the main method, and keep the method read_and_solve
	// 
	public static void main(String[] args) {	
		read_and_solve(System.in, System.out);		
	}
}