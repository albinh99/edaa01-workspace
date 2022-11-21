package mountain;
import java.util.HashMap;
import fractal.*;
import mountain.RandomUtilities;
public class MountainFrac extends Fractal {

    private Point p1;
    private Point p2;
    private Point p3;

    private double dev;

    private HashMap<Side, Point> sides;


    public MountainFrac(Point p1, Point p2, Point p3, double dev) {
        super();
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.dev = dev;

    }

    /**
     * Getter of title
     */
    @Override
    public String getTitle() {
        return "Mountain Fractal";
    }

    /**
     * Initiates drawing of fractalLines
     * @param g TurtleGraphics obj to be used for drawing
     */
    @Override
    public void draw(TurtleGraphics g) {
        fractalLine(g, order, this.p1, this.p2, this.p3);
    }

    private void fractalLine(TurtleGraphics g, int order, Point p1, Point p2, Point p3) {
        sides = new HashMap<>();

        if (order == 0) {
            g.moveTo(p1.getX(),p1.getY());
            g.forwardTo(p2.getX(),p2.getY());
            g.forwardTo(p3.getX(),p3.getY());
            g.forwardTo(p1.getX(),p1.getY());

        } else {
            int dev1 = (int) Math.round(RandomUtilities.randFunc(dev));
            Side side13 = new Side(p1,p3);
            Side side32 = new Side(p3,p2);
            Side side21 = new Side(p2,p1);

            if(!sides.containsKey(side13)){
                Point mid13 = new Point(dev1+p1.getX()+(p3.getX()-p1.getX())/2, dev1+p1.getY()+(p3.getY()-p1.getY())/2);
                sides.put(side13, mid13);
            }
            if(!sides.containsKey(side32)){
                Point mid32 = new Point(dev1+p2.getX()+(p3.getX()-p2.getX())/2, dev1+p2.getY()+(p3.getY()-p2.getY())/2);
                sides.put(side32, mid32);
            }
            if(!sides.containsKey(side21)){
                Point mid21 = new Point(dev1+p2.getX()+(p1.getX()-p2.getX())/2, dev1+p1.getY()+(p2.getY()-p1.getY())/2);
                sides.put(side21, mid21);
            }
            int x13 = sides.get(side13).getX();
            int y13 = sides.get(side13).getY();
            int x32 = sides.get(side32).getX();
            int y32 = sides.get(side32).getY();
            int x21 = sides.get(side21).getX();
            int y21 = sides.get(side21).getY();

            g.moveTo(x13,y13);
            g.forwardTo(x32,y32);
            g.forwardTo(x21,y21);
            g.forwardTo(x13,y13);

            fractalLine(g,order-1,sides.get(side13),sides.get(side32),sides.get(side21));
            fractalLine(g,order-1,sides.get(side13),p3,sides.get(side32));
            fractalLine(g,order-1,p1,sides.get(side13),sides.get(side21));
            fractalLine(g,order-1,sides.get(side21),sides.get(side32),p2);

        }
    }
}