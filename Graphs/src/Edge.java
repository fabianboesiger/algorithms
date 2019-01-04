
public class Edge {
	
	private Vertex from;
	private Vertex to;
	private int weight;
	
	public Edge(Vertex from, Vertex to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public Edge(Vertex from, Vertex to) {
		this(from, to, 1);
	}
	
	public int getWeight() {
		return weight;
	}
	
	public Vertex getFrom() {
		return from;
	}
	
	public Vertex getTo() {
		return to;
	}
	
	@Override
	public String toString() {
		return from.getName()+" ---["+weight+"]--> "+to.getName();
	}
	
}
