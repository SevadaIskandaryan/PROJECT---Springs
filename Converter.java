import java.util.List;

public abstract class Converter {

    public double[] computeOscillation(String springExpr, Spring[] springs, double t0, double t1, double dt, double x0, double v0){
        SpringArray sa = new SpringArray();
        Spring s = sa.equivalentSpring(springExpr, springs);
        return s.move(t0, t1, dt, x0, v0);
    }


    public double[] computeFrequencyAmplitude(String springExpr, Spring[] springs, double t0, double t1, double dt, double x0, double v0){
        double[] coordinates = computeOscillation(springExpr, springs, t0, t1, dt, x0, v0);
        FT ft = new FT(coordinates);
        return ft.getAmplitudes();
    }


}
