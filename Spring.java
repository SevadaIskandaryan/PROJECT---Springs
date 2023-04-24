public class Spring {

    private double k;

    public Spring() {
        k = 1.0;
    }

    public Spring(double s) {
        k = s;
    }

    public double getSpring() {
        return k;
    }

    private void setSpring(double s) {
        k = s;
    }

    public double[] move(double t, double dt, double x0, double v0) {
        return move(0, t, dt, x0, v0, 1);
    }

    public double[] move(double t, double dt, double x0) {
        return move(0, t, dt, x0, 0, 1);
    }

    public double[] move(double t0, double t1, double dt, double x0, double v0) {
        return move(t0, t1, dt, x0, v0, 1);
    }

}