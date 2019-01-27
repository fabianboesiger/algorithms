import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		String[] names = new String[] {"A", "B", "C", "D"};
		Matrix noWeights = new Matrix(new int[][] {
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
	
		Graph unweightedGraph = new Graph(noWeights, names);
		Graph realGraph = new Graph(realWeights, names);
		Graph naturalGraph = new Graph(naturalWeights, names);
		
		System.out.println(prim(realGraph, realGraph.getVertex(0)));
		System.out.println(bellmanFord(realGraph, realGraph.getVertex(0)));
		System.out.println(dijkstra(naturalGraph, naturalGraph.getVertex(0)));
		System.out.println(breadthFirst(unweightedGraph, unweightedGraph.getVertex(0)));
		System.out.println(floydWarshall(realGraph));
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
		HashMap <Vertex, Integer> distances = new HashMap <Vertex, Integer> ();
		HashSet <Vertex> vertices = new HashSet <Vertex> ();

		for(Vertex vertex : graph.getVertices()) {
			distances.put(vertex, null);
			vertices.add(vertex);
		}
		distances.put(start, 0);
		
		while(!vertices.isEmpty()) {
			Vertex nearest = null;
			for(Vertex vertex : vertices) {
				if(distances.get(vertex) != null && (nearest == null || (distances.get(nearest) == null || distances.get(vertex) < distances.get(nearest)))) {
					nearest = vertex;
				}
			}
			vertices.remove(nearest);
			
			for(Edge edge : nearest.getOut()) {
				Vertex to = edge.getTo();
				if(vertices.contains(to)) {
					int alternativeDistance = distances.get(nearest) + edge.getWeight();
					if(distances.get(to) == null || alternativeDistance > distances.get(to)) {
						distances.put(to, alternativeDistance);
					}
				}
			}
		}
		
		return distances;
	}
	
	static HashMap <Vertex, Integer> breadthFirst(Graph graph, Vertex start) {
		HashMap <Vertex, Integer> distances = new HashMap <Vertex, Integer> ();
		LinkedList <Vertex> vertices = new LinkedList <Vertex> ();
		HashSet <Vertex> visited = new HashSet <Vertex> ();
		
		for(Vertex vertex : graph.getVertices()) {
			distances.put(vertex, null);
		}
		distances.put(start, 0);
		vertices.add(start);
		
		int counter = 0;
		while(vertices.size() > 0) {
			Vertex vertex = vertices.pop();
			counter++;
			for(Edge edges : vertex.getOut()) {
				Vertex to = edges.getTo();
				if(!visited.contains(to)) {
					vertices.add(to);
					distances.put(to, counter);
					visited.add(to);
				}
			}
		}
		
		return distances;
	}
	
	static HashMap <Vertex, HashMap <Vertex, Integer>> floydWarshall(Graph graph) {
		HashMap <Vertex, HashMap <Vertex, Integer>> table = new HashMap <Vertex, HashMap <Vertex, Integer>> ();
		for(Vertex vertex : graph.getVertices()) {
			table.put(vertex, new HashMap <Vertex, Integer> ());
			table.get(vertex).put(vertex, 0);
			for(Edge edge : vertex.getOut()) {
				table.get(vertex).put(edge.getTo(), edge.getWeight());
			}
		}
		
		for(int k = 0; k < graph.getVerticesSize(); k++) {
			for(int i = 0; i < graph.getVerticesSize(); i++) {
				for(int j = 0; j < graph.getVerticesSize(); j++) {
					Integer ik = table.get(graph.getVertex(i)).get(graph.getVertex(k));
					Integer kj = table.get(graph.getVertex(k)).get(graph.getVertex(j));
					Integer ij = table.get(graph.getVertex(i)).get(graph.getVertex(j));
					if(ik != null && kj != null && (ij == null || ik+kj < ij)) {
						table.get(graph.getVertex(i)).put(graph.getVertex(j), ik+kj);
					}
				}
			}
		}
		
		return table;		
	}
	/*
	static HashMap <Vertex, HashMap <Vertex, Integer>> johnson(Graph graph) {
		HashMap <Vertex, HashMap <Vertex, Integer>> table = new HashMap <Vertex, HashMap <Vertex, Integer>> ();
		for(Vertex vertex : graph.getVertices()) {
			table.put(vertex, new HashMap <Vertex, Integer> ());
		}
		
		int[][] weights = new int[graph.getVerticesSize()+1][graph.getVerticesSize()+1];
		for(int i = 0; i < )
		Graph newGraph = new Graph(new Matrix(weights), );
	}
	*/
}
