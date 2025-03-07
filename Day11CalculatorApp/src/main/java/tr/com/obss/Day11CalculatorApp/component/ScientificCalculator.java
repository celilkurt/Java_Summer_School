package tr.com.obss.Day11CalculatorApp.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import tr.com.obss.Day11CalculatorApp.Calculator;

@Component
@Primary
public class ScientificCalculator implements Calculator<Double,Double> {


    @Override
    public Double calculate(Double number1, Double number2) {

        return number1 + number2;
    }

    @Override
    public Double subtract(Double number1, Double number2) {
        return number1 - number2;
    }

    @Override
    public Double sqrt(Double number1) {
        return Math.sqrt(number1);
    }

    @Override
    public Double pow(Double number1, Double number2) {
        return Math.pow(number1,number2);
    }
}

