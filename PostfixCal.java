public class PostfixCal implements IPostfixCalculator {
    private IStack<Integer> stack;
    
    public PostfixCal(IStack<Integer> stack) {
        this.stack = stack;
    }
    public int evaluate(String expression) {
        if (expression == null) {
            throw new RuntimeException("Expresion nula");
        }
        stack.clear();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new RuntimeException("Operandos insuficientes");
                }
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    private int applyOperator(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division por cero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Operador inválido: " + op);
        }
    }
}
