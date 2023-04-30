public class main {
    public static void main(String[] args) {
        Converter8Bit converter8bit = new Converter8Bit();

        int[] test1 = new int[]{1,0,1,1,0,0,0,1};
        System.out.println(converter8bit.getSpringExpr(test1));
    }
}
