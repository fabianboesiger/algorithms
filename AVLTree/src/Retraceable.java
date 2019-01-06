public interface Retraceable <T extends Comparable <T>> {
	
	public void setChild(Node <T> current, Node <T> next);
	public void retrace();
	
}
