import java.util.Stack;

public class Converter8Bit extends Converter {


    //0 - []
    //1 - {}
    @Override
    public String getSpringExpr(int[] binary) {
        //101
        int size = binary.length;
        if(size > 8){
            throw new UnsupportedOperationException("Binary lenght incorrect");
        }

        boolean braces = false;
        boolean brackets = false;

        String[] expr = new String[size];

        for(int i=0; i < size -1; i++){
            if(i ==0 && binary[0] == 1){
                expr[i] = "{";
                expr[size-1] = "}";
                continue;
            }else if (i ==0 && binary[0] == 0){
                expr[i] = "[";
                expr[size-1] = "]";
                continue;
            }

            if(binary[i] == 1){
                if(!braces){
                    expr[i] = "{";
                    braces = true;
                }else{
                    expr[i] = "}";
                    braces = false;
                }
            }else if(binary[i] == 0){
                if(!brackets){
                    expr[i] = "[";
                    brackets = true;
                }else{
                    expr[i] = "]";
                    brackets = false;
                }
            }
        }

        String finalExpr = new String();
        for (String c : expr) {
            finalExpr += c;
        }
        return finalExpr;
        
    }



    @Override
    public double evaluateBinary(int[] binary, double[] amplitudes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluateBinary'");
    }
    
    
}
