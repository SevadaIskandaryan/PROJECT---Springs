import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;

public class ConverterFloat extends Converter {
    int[] interger_part;
    int[] fractional_part;

    String exprInteger;
    String exprFractional;

    ConverterInt ci = new ConverterInt();

    @Override
    public String getSpringExpr(int[] binary) {
        //101
        interger_part = new int[binary.length/2];
        fractional_part = new int[binary.length/2];
        for(int k = 0; k < binary.length; k++){
            if(k < binary.length/2){
                interger_part[k] = binary[k];
            }else{
                fractional_part[k - binary.length/2] = binary[k];
            }
        }

        
        exprInteger = ci.getSpringExpr(interger_part);
        exprFractional = ci.getSpringExpr(fractional_part);

        return null;
        
    }

    public int[] getPart(int[] binary, int p){
        interger_part = new int[binary.length/2];
        fractional_part = new int[binary.length/2];
        for(int k = 0; k < binary.length; k++){
            if(k < binary.length/2){
                interger_part[k] = binary[k];
            }else{
                fractional_part[k - binary.length/2] = binary[k];
            }
        }

        if(p == 1){
            return interger_part;
        }else{
            return fractional_part;
        }
        
    }



    @Override
    public double evaluateBinary(int[] binary, double[] amplitudes) {

        double a = ci.evaluateBinary(getPart(binary, 1), amplitudes);
        double b = ci.evaluateBinary(getPart(binary, 0), amplitudes);

        double sum =  (int)a + (int)b/(Math.pow(10,binary.length/2));
        
        return sum;
    }
    
}
