//=======================================================================================================
// Exercise     : AD8H11P1.Parenthesis
// Template URL : https://www.cadmo.ethz.ch/education/lectures/HS18/DA/uebungen/AD8H11P1.Parenthesis.zip
// Author       :  
//=======================================================================================================

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

class Main {
		
	public static void read_and_solve(InputStream in, PrintStream out) {

		Scanner scanner = new Scanner(in);
		//
		// Get N and allocate space
		//
		int N = scanner.nextInt();
		int v[] = new int[N];

		//
		// Read the values and the signs
		//		
		v[0] = scanner.nextInt();		
		for (int i = 1; i < N; i += 1) {
			String op = scanner.next();
			v[i] = scanner.nextInt();
			if (op.equals("-")) {
				v[i] = - v[i];
			}
		}
		
		int output = 0;
		
		int u[] = new int[N];
		
		for(int i = 0; i < v.length-1; i++) {
			int negative = -(-v[i]+v[i+1]);
			int positive = (v[i]+v[i+1]);
			if(negative > positive && v[i] < 0) {
				u[i] = negative;
			}else {
				u[i] = positive;
			}
			System.out.println(u[i]);
		}
		
		out.println(output);
				
		//
		// Provide your solution here
		//		
		scanner.close();
	}

	//
	// Do not modify the main method, and keep the method read_and_solve
	// 
	public static void main(String[] args) {	
		read_and_solve(System.in, System.out);		
	}
}