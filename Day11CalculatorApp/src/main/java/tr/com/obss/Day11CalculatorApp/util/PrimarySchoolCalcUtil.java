package tr.com.obss.Day11CalculatorApp.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import tr.com.obss.Day11CalculatorApp.Calculator;

@Component("primarySchoolCalcUtil")
public class PrimarySchoolCalcUtil {

    @Autowired
    @Qualifier("simpleCalculator")
    Calculator<Integer,Integer> simpleCalculator;


    public Integer calculate(Integer number1, Integer number2){

        return simpleCalculator.calculate(number1,number2);
    }

    public Integer subtract(Integer number1, Integer number2){

        return simpleCalculator.subtract(number1,number2);
    }

    public Integer pow(Integer number1, Integer number2){

        return simpleCalculator.pow(number1,number2);
    }


    public Integer sqrt(Integer number1){

        return simpleCalculator.sqrt(number1);
    }



}
