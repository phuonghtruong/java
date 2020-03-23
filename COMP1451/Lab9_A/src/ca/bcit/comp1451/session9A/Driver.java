package ca.bcit.comp1451.session9A;

/**
 * 
 */

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Square wall = new Square(310, 120, "red", false, 60);
		Square window = new Square(310, 120, "red", false, 60);
		Triangle roof = new Triangle(210,140,"green",false, 60,70);
		Circle sun = new Circle(230,90,"blue",false, 68);
		
		Picture p = new Picture(wall, window, roof, sun);
		p.draw();

	}

}

