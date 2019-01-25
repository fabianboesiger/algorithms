public class Graph {
	
	private Vertex[] vertices;
	
	public Graph(Matrix adjacencies) {
		this(adjacencies, Matrix.zeroMatrix(adjacencies.getHeight(), adjacencies.getWidth()));
	}
	
	public Graph(Matrix adjacencies, Matrix weights) {
		this(adjacencies, weights, new String[adjacencies.getHeight()]);
	}
	
	public Graph(Matrix adjacencies, String[] names) {
		this(adjacencies, Matrix.zeroMatrix(adjacencies.getHeight(), adjacencies.getWidth()), new String[adjacencies.getHeight()]);
	}
	
	public Graph(Matrix adjacencies, Matrix weights, String[] names) {
		vertices = new Vertex[adjacencies.getHeight()];
		for(int i = 0; i < vertices.length; i++) {
			vertices[i] = new Vertex(names[i]);
		}
		for(int i = 0; i < vertices.length; i++) {
			for(int j = 0; j < vertices.length; j++) {
				if(adjacencies.getValue(i, j) == 1) {
					Edge edge = new Edge(getVertex(i), getVertex(j), weights.getValue(i, j));
					getVertex(i).getOut().add(edge);
					getVertex(j).getIn().add(edge);
				}
			}
		}
	}
	
	public Vertex getVertex(int index) {
		return vertices[index];
	}
	
	public int getIndex(Vertex vertex) {
		for(int i = 0; i < vertices.length; i++) {
			if(vertices[i] == vertex) {
				return i;
			}
		}
		return -1;
	}
	
	public int getVerticesSize() {
		return vertices.length;
	}
	
	public Vertex[] getVertices() {
		return vertices;
	}
	
}
