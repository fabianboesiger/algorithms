import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt();
		int b = scanner.nextInt();

		int s1 = a;
		int u1 = 1;
		int v1 = 0;

		int s2 = b;
		int u2 = 0;
		int v2 = 1;

		while(s2 > 0) {
			int q = s1/s2;

			int st = s2;
			int ut = u2;
			int vt = v2;

			s2 = s1 - q * s2;
			u2 = u1 - q * u2;
			v2 = v1 - q * v2;

			s1 = st;
			u1 = ut;
			v1 = vt;
		}

		int d = s1;
		int u = u1;
		int v = v1;

		System.out.println("gcd("+a+", "+b+") = "+d+" = ("+u+") * ("+a+") + ("+v+") * ("+b+")");

		scanner.close();

	}

}