
public class Rectangle {
	private final double height;
	private final double width;
	
	public Rectangle(double height, double width) throws LogicException {
		super();
		this.height = height;
		this.width = width;
		if (height == width) {
			throw new LogicException ("Prostok�t nie moze mie� r�wnych bok�w");
		}
		
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}
}
