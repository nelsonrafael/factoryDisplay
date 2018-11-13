package dataStructure;

public class Line {
	
	private String name;
	private int doorsProduced;
	
	public Line(String name) {
		this.name = name;
		this.doorsProduced = 0;
	}
	
	public void setDoorsProduced(int n) {
		this.doorsProduced = n;
	}
	
	public int getDoorsProduced() {
		return this.doorsProduced;
	}
	
	public String getName() {
		return this.name;
	}
	
}
