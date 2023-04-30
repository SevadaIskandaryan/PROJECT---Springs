public class main {
    public static void main(String[] args) {

        //testing converter8bit binary to spring expression.
        Converter8Bit converter8bit = new Converter8Bit();
        int[] test1 = new int[]{1,1};
        System.out.println("test1 -- 1,1");
        System.out.println(converter8bit.getSpringExpr(test1));
        
        int[] test2 = new int[]{1,0,0,0,0,1};
        System.out.println("test2 -- 1,0,0,0,0,1");
        System.out.println(converter8bit.getSpringExpr(test2));

        int[] test3 = new int[]{1,0,1,1,0,0,0,1};
        System.out.println("test3 -- 1,0,1,1,0,0,0,1");
        System.out.println(converter8bit.getSpringExpr(test3));

        int[] test4 = new int[]{1,1,1,1,1,1,1,1};
        System.out.println("test3 -- 1,1,1,1,1,1,1,1");
        System.out.println(converter8bit.getSpringExpr(test4));
    }
}
