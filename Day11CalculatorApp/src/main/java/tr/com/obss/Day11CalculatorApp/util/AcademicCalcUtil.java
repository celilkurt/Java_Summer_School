package tr.com.obss.Day11CalculatorApp.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import tr.com.obss.Day11CalculatorApp.Calculator;

@Component("academicCalcUtil")
public class AcademicCalcUtil  {

    @Autowired
    Calculator<Double,Double> scientificCalculator;

    public Double calculate(Double number1, Double number2){

        return scientificCalculator.calculate(number1,number2);
    }


    public Double subtract(Double number1, Double number2){

        return scientificCalculator.subtract(number1,number2);
    }

    public Double sqrt(Double number1){

        return scientificCalculator.sqrt(number1);
    }

    public Double pow(Double number1, Double number2){

        return scientificCalculator.pow(number1,number2);
    }

}
