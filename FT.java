public class FT {
    private double[] timeValues;
    private int numHarmonics;

    public FT(double[] x){
        this.timeValues = x;
        this.numHarmonics = x.length;
    }

    public FT(double[] timeValues, int numHarmonics) {
        this.timeValues = timeValues;
        this.numHarmonics = numHarmonics;
    }

    public double[] getAmplitudes() {
        int N = timeValues.length;
        double[] amplitudes = new double[numHarmonics];

        for (int k = 0; k < numHarmonics; k++) {
            double real = 0;
            double imag = 0;

            for (int n = 0; n < N; n++) {
                double angle = 2 * Math.PI * k * n / N;
                real += timeValues[n] * Math.cos(angle);
                imag -= timeValues[n] * Math.sin(angle);
            }

            amplitudes[k] = Math.sqrt(real * real + imag * imag);
        }

        return amplitudes;
    }
}
