import java.util.ArrayList;

public class Vertex {
	
	private ArrayList <Edge> in;
	private ArrayList <Edge> out;
	private String name;
	
	public Vertex(){
		this(null);
	}
	
	public Vertex(String name){
		in = new ArrayList <Edge> ();
		out = new ArrayList <Edge> ();
		this.name = name;
	}
	
	public ArrayList <Edge> getIn(){
		return in;
	}
	
	public ArrayList <Edge> getOut(){
		return out;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}
	
}
