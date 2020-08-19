package tr.com.obss.Day11CalculatorApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tr.com.obss.Day11CalculatorApp.config.CalculatorAppConfig;
import tr.com.obss.Day11CalculatorApp.util.AcademicCalcUtil;
import tr.com.obss.Day11CalculatorApp.util.PrimarySchoolCalcUtil;

public class Day11CalculatorApplication {


	static AcademicCalcUtil academicCalcUtil;
	static PrimarySchoolCalcUtil primarySchoolCalcUtil;



	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorAppConfig.class);
		academicCalcUtil = context.getBean(AcademicCalcUtil.class);
		primarySchoolCalcUtil = context.getBean(PrimarySchoolCalcUtil.class);

		System.out.println(primarySchoolCalcUtil.calculate(3,5));
		System.out.println(academicCalcUtil.subtract(new Double(3.8),new Double(5.7)));

		System.out.println(primarySchoolCalcUtil.calculate(3,4));
	}

}
