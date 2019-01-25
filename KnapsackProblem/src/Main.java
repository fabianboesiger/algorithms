public class Main {

	public static void main(String[] args) {
		
		int backpackMaxWeight = 20;
		int[] weights = {5, 5, 6, 9, 6, 11, 12, 15, 17, 30};
		int[] values = {7, 7, 6, 5, 10, 5, 14, 17, 20, 21};
		
		/*
		 * valuesTable[i][j]: Maximaler Wert bei der Betrachtung der ersten i Objekte
		 *  mit dem maximal möglichen Gesamtgewicht j
		 */
		int[][] valuesTable = new int[weights.length+1][backpackMaxWeight+1];
		
		for(int i = 0; i < weights.length; i++) {
			for(int j = 1; j <= backpackMaxWeight; j++) {
				if(weights[i] <= j) {
					valuesTable[i+1][j] = Math.max(values[i] + valuesTable[i][j-weights[i]], valuesTable[i][j]);
				} else {
					valuesTable[i+1][j] = valuesTable[i][j];
				}
			}
		}
		
		System.out.print("i      j|\t");
		for(int j = 0; j < valuesTable[0].length; j++) {
			System.out.print(j+"\t");
		}
		System.out.println();
		System.out.print("--------+-------");
		for(int j = 0; j < valuesTable[0].length; j++) {
			System.out.print("--------");
		}
		System.out.println();
		for(int i = 0; i < valuesTable.length; i++) {
			System.out.print(i+"\t|\t");
			for(int j = 0; j < valuesTable[i].length; j++) {
				System.out.print(valuesTable[i][j]+"\t");
			}
			System.out.println();
		}
		
		
		System.out.println("Solution: "+valuesTable[weights.length][backpackMaxWeight]);
		
	}

}
