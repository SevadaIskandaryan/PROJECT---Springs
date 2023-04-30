import java.util.Stack;

public class Converter8Bit extends Converter {


    //0 - []
    //1 - {}
    //I was thinking if written 100001 then it should change 
    // 1 with { } and 0 with [] to make in series and parralel connection
    // so it will be {[][]} and not like this {}[][][][]{}
    //but also implemented the other version too.
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



    
    public String getSpringExpr1(int[] binary) {
        //101
        int size = binary.length;
        if(size > 8){
            throw new UnsupportedOperationException("Binary lenght incorrect");
        }

        String expr = new String();
        expr += "[";
        for (int c : binary) {
            if(c == 1){
                expr += "{}";
            }else{
                expr += "[]";
            }
        }
        expr += "]";
        return expr;
        
    }



    @Override
    public double evaluateBinary(int[] binary, double[] amplitudes) {
        int size = binary.length;
        double sum = 0.0;
        for (int i = 0; i < size; i++) {
            sum += binary[i] * amplitudes[i];
        }
        return sum;
    }
    
    
}
