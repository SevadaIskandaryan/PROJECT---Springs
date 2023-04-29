import static java.lang.Math.*;

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

    public double[] move(double t0, double t1, double dt, double x0, double v0, double m){
        double[] coordinates = getCoordinatesArray(t1, t0, dt);

        double w = Math.sqrt(k/m); // omega = sqrt(k/m) for harmonic motion
        double a = Math.sqrt(Math.pow((v0/w),2) + Math.pow(x0, 2)); // the amplitute = sqrt((v/w)^2+x^2)
        double p = Math.atan2(x0, v0/w); // The phase of the motion

        for (int i = 0; i < coordinates.length; i++) {
            double x = a*sin(w*(t0+i*dt) + p);
            coordinates[i] = x;
        }

        return coordinates;
    }

    //creates empty array for coordinates with size (t1-t0)/dt
    public double[] getCoordinatesArray(double t1, double t0, double dt){
        double[] coordinates = new double[(int) Math.ceil((t1-t0)/dt)];
        return coordinates;
    }

    public Spring inSeries(Spring that) {
        double k_eq_in = (1 / this.k + 1 / that.k);
        return new Spring(1/k_eq_in);
    }

    public Spring inParallel(Spring that) {
        double k_eq = this.k + that.k;
        return new Spring(k_eq);
    }

    public static void main(String[] args) {
        System.out.println(); 
        Spring s = new Spring();
        
        System.out.println(s.move(10, 1, 3)); 
    }
}



/*  the formalas are obtained from lecture notes
    and from this sources
    https://physics.stackexchange.com/questions/456892/finding-the-amplitude-of-a-spring-oscillation-given-initial-position-and-velocit#:~:text=You'll%20need%20to%20know,velocity%20to%20determine%20the%20amplitude.&text=%CF%89%3D2%CF%80T%3D2,the%20mass%20of%20the%20mass.
    https://courses.lumenlearning.com/suny-osuniversityphysics/chapter/15-1-simple-harmonic-motion/
    https://en.wikipedia.org/wiki/Series_and_parallel_springs
    
    */