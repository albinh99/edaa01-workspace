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
        Side side;

        if (order == 0) {
            g.moveTo(p1.getX(),p1.getY());
            g.forwardTo(p2.getX(),p2.getY());
            g.forwardTo(p3.getX(),p3.getY());
            g.forwardTo(p1.getX(),p1.getY());

        } else {
            int dev1 = (int) Math.round(RandomUtilities.randFunc(dev));

            if(!sides.containsKey(new Side(p1,p3))){
                Point mid13 = new Point(dev1+p1.getX()+(p3.getX()-p1.getX())/2, dev1+p1.getY()+(p3.getY()-p1.getY())/2);
                sides.put(new Side(p1,p3), mid13);
            }
            if(!sides.containsKey(new Side(p3,p2))){
                Point mid32 = new Point(dev1+p2.getX()+(p3.getX()-p2.getX())/2, dev1+p2.getY()+(p3.getY()-p2.getY())/2);
                sides.put(new Side(p3,p2), mid32);
            }
            if(!sides.containsKey(new Side(p2,p1))){
                Point mid21 = new Point(dev1+p2.getX()+(p1.getX()-p2.getX())/2, dev1+p1.getY()+(p2.getY()-p1.getY())/2);
                sides.put(new Side(p2,p1), mid21);

            }
            g.moveTo(mid13.getX(),mid13.getY());
            g.forwardTo(mid32.getX(),mid32.getY());
            g.forwardTo(mid21.getX(),mid21.getY());
            g.forwardTo(mid13.getX(),mid13.getY());

            fractalLine(g,order-1,mid13,mid32,mid21);
            fractalLine(g,order-1,mid13,p3,mid32);
            fractalLine(g,order-1,p1,mid13,mid21);
            fractalLine(g,order-1,mid21,mid32,p2);



        }
    }
}