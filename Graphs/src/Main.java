import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
	
		Matrix adjacencies = new Matrix(new int[][] {
			{0, 1, 0},
			{1, 0, 1},
			{1, 0, 0}
		});
		Matrix weights = new Matrix(new int[][] {
			{0, 3, 0},
			{2, 0, -1},
			{1, 0, 0}
		});
		
		Graph unweightedGraph = new Graph(adjacencies);
		Graph weightedGraph = new Graph(adjacencies, weights);
		
		System.out.println(bellmanFord(weightedGraph, 0, 2));

	}
	
	static int bellmanFord(Graph graph, int from, int to) {
		ArrayList <int[]> columns = new ArrayList <int[]> ();
				
		while(columns.size() < 2 || !Arrays.equals(columns.get(columns.size()-1), columns.get(columns.size()-2))) {

			int[] array = new int[graph.getVerticesSize()];
			Arrays.fill(array, Integer.MAX_VALUE);
			array[from] = 0;
			if(columns.size() > 1) {
				for(int i = 0; i < array.length; i++) {
					ArrayList <Edge> in = graph.getVertex(i).getIn();
					int min = Integer.MAX_VALUE;
					Edge minEdge = null;
					for(int j = 0; j < in.size(); j++) {
						int current = columns.get(columns.size()-2)[graph.getIndex(in.get(j).getFrom())];
						if(current < min) {
							min = current;
							minEdge = in.get(j);
						}
					}
					array[i] = Math.min(columns.get(columns.size()-2)[i], min+minEdge.getWeight());
				}
			}
			
			columns.add(array);
			System.out.println(Arrays.toString(array));
		}
		
		return columns.get(columns.size()-1)[to];
	}

}
