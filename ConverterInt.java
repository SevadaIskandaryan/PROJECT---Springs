import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;

public class ConverterInt extends Converter {



    @Override
    public String getSpringExpr(int[] binary) {
        //101
        int size = binary.length;

        String expr = new String();
        expr += "[";
        for (int c : binary) {
            if(c == 1){
                expr += "[]";
            }
        }

        expr += "]";
        return expr;
        
    }



    @Override
    public double evaluateBinary(int[] binary, double[] amplitudes) {
        double[] a = amplitudes.clone();
        int size = binary.length;
        double sum = 0.0;
        Arrays.sort(a);

        sum = a[a.length - 1];
        
        return sum;
    }
    
}
