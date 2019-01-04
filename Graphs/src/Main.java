import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		String[] names = new String[] {"A", "B", "C", "D"};
		Matrix adjacencies = new Matrix(new int[][] {
			{0, 1, 0, 1},
			{1, 0, 1, 0},
			{1, 0, 0, 0},
			{0, 1, 0, 0}
		});
		Matrix weights = new Matrix(new int[][] {
			{0, 3, 0, 4},
			{2, 0, -1, 0},
			{1, 0, 0, 0},
			{0, -2, 0, 0}
		});
		
		Graph unweightedGraph = new Graph(adjacencies);
		Graph weightedGraph = new Graph(adjacencies, weights);
		
		System.out.println(prim(weightedGraph, weightedGraph.getVertex(0)));

	}
	
	static int prim(Graph graph, Vertex start) {
		ArrayList <Edge> edges = new ArrayList <Edge> ();
		ArrayList <Edge> potentialEdges = new ArrayList <Edge> ();

		potentialEdges.addAll(start.getOut());
		
		while(edges.size() < graph.getVerticesSize()-1) {
			Edge cheapest = null;
			for(int i = 0; i < potentialEdges.size(); i++) {
				if(cheapest == null || cheapest.getWeight() > potentialEdges.get(i).getWeight()) {
					cheapest = potentialEdges.get(i);
				}
			}
			if(cheapest != null) {
				potentialEdges.remove(cheapest);
				edges.add(cheapest);
				for(int i = 0; i < cheapest.getTo().getOut().size(); i++) {
					if(cheapest.getFrom() != cheapest.getTo().getOut().get(i).getTo()) {
						potentialEdges.add(cheapest.getTo().getOut().get(i));
					}
				}
			}else {
				return -1;
			}
		}
		int output = 0;
		for(int i = 0; i < edges.size(); i++) {
			output += edges.get(i).getWeight();
		}
		return output;
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
