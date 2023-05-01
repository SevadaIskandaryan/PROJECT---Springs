import javax.swing.text.DefaultStyledDocument.ElementSpec;

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

    public static Spring[] createSpringsFloat(int[] binary){
        int size = binary.length;

        Spring[] springs = new Spring[size];
        for(int j = 0; j < size; j++){
            int bin_c = binary[size-1-j];
            if(j < size/2){
                springs[j] = new Spring(bin_c*Math.pow(2,j));
            }else{
                springs[j] = new Spring(bin_c*Math.pow(2,j-size/2));
            }
        }
        return springs;
    }

    public static void main(String[] args) {

        //testing converter8bit binary to spring expression.
        //testing evaluation of converter8bit
        System.out.println("Testing Converter8bit");
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

        



        //testing converterInt binary to spring expression.
        //testing evaluation of converterInt
        System.out.println();
        System.out.println("Testing ConverterInt");
        ConverterInt converterInt = new ConverterInt();
        test1 = new int[]{1,1,0,0,1,0,1,0,1};
        System.out.println("test1 -- 1,1,0,0,1,0,1,0,1");
        Spring[] springs11 = createSprings(test1);
        System.out.println(converterInt.getSpringExpr(test1));
        System.out.println(converterInt.evaluateBinary(test1, converterInt.computeFrequencyAmplitude(converterInt.getSpringExpr(test1),springs11, 0, 1, 0.1, 1, 0) ));
        
        test2 = new int[]{1,0,0,1,0,1,1,1,1};
        System.out.println("test2 -- 1,0,0,1,0,1,1,1,1");
        Spring[] springs22 = createSprings(test2);
        System.out.println(converterInt.getSpringExpr(test2));
        System.out.println(converterInt.evaluateBinary(test2, converterInt.computeFrequencyAmplitude(converterInt.getSpringExpr(test2), springs22, 0, 1, 0.1, 1, 0) ));

        test3 = new int[]{1,0,1,1,0,0,0,1,1,0};
        Spring[] springs33 = createSprings(test3);
        System.out.println("test3 -- 1,0,1,1,0,0,0,1,1,0");
        System.out.println(converterInt.getSpringExpr(test3));
        System.out.println(converterInt.evaluateBinary(test3, converterInt.computeFrequencyAmplitude(converterInt.getSpringExpr(test3),springs33, 0, 1, 0.1, 1, 0) ));

        test4 = new int[]{1,1,1,1,1,1,1,1,1,1,1};
        Spring[] springs44 = createSprings(test4);
        System.out.println("test4 -- 1,1,1,1,1,1,1,1,1,1,1");
        System.out.println(converterInt.getSpringExpr(test4));
        System.out.println(converterInt.evaluateBinary(test4, converterInt.computeFrequencyAmplitude(converterInt.getSpringExpr(test4),springs44, 0, 1, 0.1, 1, 0) ));

        // System.out.println();
        // System.out.println("Testing ConverterFloat");
        // ConverterFloat converterfloat = new ConverterFloat();
        // test1 = new int[]{1,1,1,0,1,1,0,1,0,0,1,1};
        // Spring[] springs111 = createSpringsFloat(test1);
        // System.out.println("test4 -- 1,1,1,0,1,1,0,1,0,0,1,1");
        // System.out.println(converterfloat.evaluateBinary(test1, converterfloat.computeFrequencyAmplitude(converterInt.getSpringExpr(test1),springs111, 0, 1, 0.1, 1, 0) ));

    }
}
