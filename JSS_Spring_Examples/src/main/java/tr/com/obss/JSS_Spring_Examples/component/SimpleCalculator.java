package tr.com.obss.JSS_Spring_Examples.component;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import tr.com.obss.JSS_Spring_Examples.Calculator;

@Component("simpleCalculator")
public class SimpleCalculator implements Calculator<Integer,Integer> {

    @Override
    public Integer calculate(Integer number1, Integer number2) {
        return number1 + number2;
    }

    @Override
    public Integer subtract(Integer number1, Integer number2) {
        return number1 - number2;
    }

    @Override
    public Integer sqrt(Integer number1) {
        Double d = Math.sqrt(number1);
        return d.intValue();
    }

    @Override
    public Integer pow(Integer number1, Integer number2) {
        Double d = Math.pow(number1,number2);
        return d.intValue();
    }
}
