
public class Matrix {
	
	private int width;
	private int height;
	private int[][] values;
	
	public Matrix(int[][] values) {
		this.width = values[0].length;
		this.height = values.length;
		this.values = values;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getValue(int y, int x) {
		return values[y][x];
	}
	
	public void setValue(int y, int x, int value) {
		values[y][x] = value;
	}
	
}
