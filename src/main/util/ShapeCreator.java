package main.util;

import java.awt.*;

public class ShapeCreator {
	
	public static Rectangle rectangle(int x1, int y1, int width, int height) {
		return new Rectangle(x1, y1, width, height);
	}
	
	public static Rectangle square(int x1, int y1, int side) {
		return ShapeCreator.rectangle(x1, y1, side, side);
	}
	
}
