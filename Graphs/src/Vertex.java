import java.util.ArrayList;

public class Vertex {
	
	private ArrayList <Edge> in;
	private ArrayList <Edge> out;
	
	Vertex(){
		in = new ArrayList <Edge> ();
		out = new ArrayList <Edge> ();
	}
	
	public ArrayList <Edge> getIn(){
		return in;
	}
	
	public ArrayList <Edge> getOut(){
		return out;
	}
	
}
