package main.prefabs;

public class Ground extends CollidableGameObject {
	
	private double verticalPosition;
	
	public Ground(double position) {
		this.verticalPosition = position;
	}
	
	public double getVerticalPosition() {
		return verticalPosition;
	}
	
	public void setVerticalPosition(double verticalPosition) {
		this.verticalPosition = verticalPosition;
	}
}