import java.util.HashMap;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		
		String[] names = new String[] {"A", "B", "C", "D"};
		Matrix adjacencies = new Matrix(new int[][] {
			{0, 1, 0, 1},
			{1, 0, 1, 0},
			{1, 0, 0, 0},
			{0, 1, 0, 0}
		});
		Matrix realWeights = new Matrix(new int[][] {
			{0, 3, 0, 4},
			{2, 0, -1, 0},
			{1, 0, 0, 0},
			{0, -2, 0, 0}
		});
		Matrix naturalWeights = new Matrix(new int[][] {
			{0, 3, 0, 4},
			{2, 0, 1, 0},
			{1, 0, 0, 0},
			{0, 2, 0, 0}
		});
		
		Graph unweightedGraph = new Graph(adjacencies, names);
		Graph realGraph = new Graph(adjacencies, realWeights, names);
		Graph naturalGraph = new Graph(adjacencies, naturalWeights, names);
		
		System.out.println(prim(realGraph, realGraph.getVertex(0)));
		System.out.println(bellmanFord(realGraph, realGraph.getVertex(0)));
		System.out.println(dijkstra(naturalGraph, naturalGraph.getVertex(0)));
	}
	
	static HashSet <Edge> prim(Graph graph, Vertex start) {
		HashSet <Edge> edges = new HashSet <Edge> ();
		HashSet <Edge> potentialEdges = new HashSet <Edge> ();
		HashSet <Vertex> vertices = new HashSet <Vertex> ();

		vertices.add(start);
		potentialEdges.addAll(start.getOut());
		
		while(vertices.size() < graph.getVerticesSize()) {
			Edge cheapest = null;
			
			potentialEdges.removeIf((potentialEdge) -> vertices.contains(potentialEdge.getTo()));
			for(Edge potentialEdge : potentialEdges) {
				if(cheapest == null || potentialEdge.getWeight() < cheapest.getWeight()) {
					cheapest = potentialEdge;
				}
			}
			
			if(cheapest != null) {
				edges.add(cheapest);
				potentialEdges.addAll(cheapest.getTo().getOut());
				vertices.add(cheapest.getTo());
			} else {
				return null;
			}
		}
		
		return edges;
	}
	
	static HashMap <Vertex, Integer> bellmanFord(Graph graph, Vertex start) {
		HashMap <Vertex, Integer> distances = new HashMap <Vertex, Integer> ();
		for(Vertex vertex : graph.getVertices()) {
			distances.put(vertex, null);
		}
		distances.put(start, 0);
		
		for(int i = 0; i < graph.getVerticesSize(); i++) {
			for(Vertex from : graph.getVertices()) {
				for(Edge edge : from.getOut()) {
					Vertex to = edge.getTo();
					Integer fromDistance = distances.get(from);
					if(fromDistance != null) {
						if(distances.get(to) == null || fromDistance + edge.getWeight() < distances.get(to)){
							if(i < graph.getVerticesSize() - 1) {
								distances.put(to, fromDistance + edge.getWeight());
							} else {
								return null;
							}
						}
					}
				}
			}
		}
		
		return distances;
	}
	
	static HashMap <Vertex, Integer> dijkstra(Graph graph, Vertex start){
		return null;
	}
	

}
