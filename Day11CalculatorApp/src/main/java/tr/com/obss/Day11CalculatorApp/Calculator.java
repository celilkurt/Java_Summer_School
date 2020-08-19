package tr.com.obss.Day11CalculatorApp;

public interface Calculator<V,R> {

    public R calculate(V number1, V number2);

    public R subtract(V number1, V number2);

    public R sqrt(V number1);

    public R pow(V number1, V number2);

}
