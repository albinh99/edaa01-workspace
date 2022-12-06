package fractal;

import koch.Koch;
import mountain.MountainFrac;
import mountain.Point;
import mountain.Side;

import java.util.HashMap;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		Point p1 = new Point(300, 150);
		Point p2 = new Point(100, 450);
		Point p3 = new Point(500, 400);

		fractals[0] = new MountainFrac(p1, p2, p3, 20);
		fractals[1] = new Koch(300);
	    new FractalView(fractals, "Fraktaler", 600, 600);
		Side a = new Side(p1,p2);
		Point p11 = new Point(300,150);
		Point p22 = new Point(100, 450);
		Point p4 = new Point(500,400);

		Side b = new Side(p11,p22);
		HashMap<Side, Point> apa = new HashMap<>();
		apa.put(a,p3);
		System.out.println(p1.equals(p11));
		//apa.put(b,p4);

		System.out.println(apa.containsKey(b));
		//System.out.println(apa.containsValue(p3));

	}

}
