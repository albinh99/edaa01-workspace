package fractal;

import koch.Koch;
import mountain.MountainFrac;
import mountain.Point;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		Point p1 = new Point(300, 150);
		Point p2 = new Point(100, 450);
		Point p3 = new Point(500, 400);

		fractals[0] = new MountainFrac(p1, p2, p3, 5);
		fractals[1] = new Koch(300);
	    new FractalView(fractals, "Fraktaler", 600, 600);

	}

}
