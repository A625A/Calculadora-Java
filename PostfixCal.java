public class PostfixCal implements IPostfixCalculator {
    private IStack<Double> stack;
    
    public PostfixCal(IStack<Double> stack) {
        this.stack = stack;
    }
    public double evaluate(String expression) {
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
                double b = stack.pop();
                double a = stack.pop();
                double result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Double.parseDouble(token));
            }
        }
        return stack.pop();
    }
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    private double applyOperator(double a, double b, String op) {
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

    public static void main(String[] args) {
        IStack<Double> stack = new Vstack<>();
        PostfixCal calc = new PostfixCal(stack);
        String expresion = args.length > 0 ? String.join(" ", args) : "2 12.56 + 5 /";
        double resultado = calc.evaluate(expresion);
        System.out.println("Expresion: " + expresion);
        System.out.println("Resultado: " + resultado);
    }
}
