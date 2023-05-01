public abstract class Converter {

    public abstract String getSpringExpr(int[] binary);

    public double[] computeOscillation(String springExpr, Spring[] springs, double t0, double t1, double dt, double x0, double v0){
        SpringArray sa = new SpringArray();
        Spring s = sa.equivalentSpring(springExpr, springs);
        System.out.println(s.getSpring());
        return s.move(t0, t1, dt, x0, v0);
    }

    public double[] computeOscillation(String springExpr, double t0, double t1, double dt, double x0, double v0){
        SpringArray sa = new SpringArray();
        Spring s = sa.equivalentSpring(springExpr);
        return s.move(t0, t1, dt, x0, v0);
    }


    public double[] computeFrequencyAmplitude(String springExpr, Spring[] springs, double t0, double t1, double dt, double x0, double v0){
        double[] coordinates = computeOscillation(springExpr, springs, t0, t1, dt, x0, v0);
        FT ft = new FT(coordinates);
        return ft.getAmplitudes();
    }

    public double[] computeFrequencyAmplitude(String springExpr, double t0, double t1, double dt, double x0, double v0){
        double[] coordinates = computeOscillation(springExpr, t0, t1, dt, x0, v0);
        FT ft = new FT(coordinates);
        return ft.getAmplitudes();
    }

    public abstract double evaluateBinary(int[] binary, double[] amplitudes);

}
