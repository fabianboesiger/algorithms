import java.util.Stack;

public class Main {
	
	public static Stack <Integer> S;
	public static Stack <Integer> T;
	public static int c = 0;
	
	public static void main(String[] args) {
		
		S = new Stack <Integer> ();
		T = new Stack <Integer> ();
		
		int[] a = new int[] {3, 3, 5, 5, 4, 4, 4, 4, 5, 5, 3, 5};
		for(int i = 0; i < a.length; i++) {
			S.push(a[i]);
		}
		
		while(!S.empty()) {
			int s = S.pop();
			
			if(T.empty()) {
				T.push(s);
				c = 1;
			}else {
				if(s == T.peek()) {
					T.push(s);
					c++;
					
					if(c >= 3) {
						int t = T.peek();
						
						// Genau 3 Loops
						while(!T.empty() && T.peek() == t) {
							T.pop();
						}
						// Egal, da der erste While-Loop verkürzt wird
						while(!S.empty() && S.peek() == t) {
							S.pop();
						}
						
						if(!T.empty()) {
							t = T.peek();
							// Nicht mehr als 2 Loops
							while(!T.empty() && T.peek() == t) {
								S.push(T.pop());
							}
							c = 1;
						}else {
							c = 0;
						}
					}
				}else {
					T.push(s);
					c = 1;
				}
			}
		}
		System.out.println(T.toString());

	}

}
