public class main {

    public static Spring[] createSprings(int[] binary){
        int size = binary.length;
        Spring[] springs = new Spring[size];
        for(int j = 0; j < size; j++){
            int bin_c = binary[size-1-j];
            springs[j] = new Spring(bin_c*Math.pow(2,j));
        }
        return springs;
    }

    public static void main(String[] args) {

        //testing converter8bit binary to spring expression.
        //testing evaluation of converter8bit
        Converter8Bit converter8bit = new Converter8Bit();
        int[] test1 = new int[]{1,1};
        System.out.println("test1 -- 1,1");
        Spring[] springs1 = createSprings(test1);
        System.out.println(converter8bit.getSpringExpr(test1));
        System.out.println(converter8bit.evaluateBinary(test1, converter8bit.computeFrequencyAmplitude(converter8bit.getSpringExpr(test1),springs1, 0, 1, 0.1, 1, 0) ));
        
        int[] test2 = new int[]{1,0,0,0,0,1};
        System.out.println("test2 -- 1,0,0,0,0,1");
        Spring[] springs2 = createSprings(test2);
        System.out.println(converter8bit.getSpringExpr(test2));
        System.out.println(converter8bit.evaluateBinary(test2, converter8bit.computeFrequencyAmplitude(converter8bit.getSpringExpr(test2), springs2, 0, 1, 0.1, 1, 0) ));

        int[] test3 = new int[]{1,0,1,1,0,0,0,1};
        Spring[] springs3 = createSprings(test3);
        System.out.println("test3 -- 1,0,1,1,0,0,0,1");
        System.out.println(converter8bit.getSpringExpr(test3));
        System.out.println(converter8bit.evaluateBinary(test3, converter8bit.computeFrequencyAmplitude(converter8bit.getSpringExpr(test3),springs3, 0, 1, 0.1, 1, 0) ));

        int[] test4 = new int[]{1,1,1,1,1,1,1,1};
        Spring[] springs4 = createSprings(test4);
        System.out.println("test4 -- 1,1,1,1,1,1,1,1");
        System.out.println(converter8bit.getSpringExpr(test4));
        System.out.println(converter8bit.evaluateBinary(test4, converter8bit.computeFrequencyAmplitude(converter8bit.getSpringExpr(test4),springs4, 0, 1, 0.1, 1, 0) ));

        
        
    }
}
