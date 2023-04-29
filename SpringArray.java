import java.util.Stack;

public class SpringArray {
    public Spring equivalentSpring(String springExpr){
        //{}[]
        Stack<Double> stack = new Stack<>();
        for (char c : springExpr.toCharArray()) {
            System.out.println(c);
            if (c == '{') {
                stack.push(-1.0);
            } else if (c == '[') {
                stack.push(-2.0);
            } else if (c == '}') {
                double sum = 0;
                while (stack.peek() != -1.0) {
                    sum += 1/(stack.pop());
                }
                stack.pop();
                if(sum == 0){
                    stack.push(1.0);
                } else{
                    stack.push(1/sum);
                }
            } else if (c == ']') {
                double sum = 0;
                while (stack.peek() != -2.0) {
                    sum += stack.pop();
                }
                stack.pop();
                if(sum == 0){
                    stack.push(1.0);
                } else{
                    stack.push(sum);
                }
            }
        }

        double result = stack.pop();
        //return result
        return new Spring(result);
    }

    public static void main(String[] args) {
        //for testing
        //SpringArray s = new SpringArray();
        
        //System.out.println(s.equivalentSpring("[]")); // output 1
        //System.out.println(s.equivalentSpring("[[]{}{}{}]")); // Output: 4
        //System.out.println(s.equivalentSpring("{[][][[][]{}{}]}")); // Output: 0.44444...
        //System.out.println(s.equivalentSpring("[{{[{}]}[{{}[{}]}]}]{{{[{}][{}]}[{}]}[{}]{{}[{}]}}")); // Output: 0.1666666...
    }
}
