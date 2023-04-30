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

        String expr = new String();
        for (int c : binary) {
            System.out.println(c);
            if(c == 1){
                if(!braces){
                    expr +="{";
                    braces = true;
                }else{
                    expr +="}";
                    braces = false;
                }
            }
            if(c == 0){
                if(!brackets){
                    expr +="[";
                    brackets = true;
                }else{
                    expr +="]";
                    brackets = false;
                }
            }
        }

        return expr;
        
    }



    @Override
    public double evaluateBinary(int[] binary, double[] amplitudes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluateBinary'");
    }
    
    
}
