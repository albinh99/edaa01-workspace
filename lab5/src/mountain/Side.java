package mountain;

public class Side {
    private Point p1;
    private Point p2;


        public Side(Point p1,Point p2){
            this.p1 = p1;
            this.p2 = p2;
        }


    @Override
    public boolean equals(Object s) {
        if (s == this) return true;
        if (!(s instanceof Side)) return false;
        Side s2 = (Side) s;
        if (this.p1.equals(s2.p1) && this.p2.equals(s2.p2)) return true;
        if (this.p1.equals(s2.p2) && this.p2.equals(s2.p1)) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return p1.hashCode() + p2.hashCode();
    }






}
