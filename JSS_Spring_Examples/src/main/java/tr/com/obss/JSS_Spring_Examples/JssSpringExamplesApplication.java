package tr.com.obss.JSS_Spring_Examples;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tr.com.obss.JSS_Spring_Examples.config.CalculatorAppConfig;
import tr.com.obss.JSS_Spring_Examples.util.AcademicCalcUtil;
import tr.com.obss.JSS_Spring_Examples.util.PrimarySchoolCalcUtil;

public class JssSpringExamplesApplication {

	@Autowired
	static  AcademicCalcUtil academicCalcUtil;

	@Autowired
	static PrimarySchoolCalcUtil primarySchoolCalcUtil;



	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorAppConfig.class);
		AcademicCalcUtil academicCalcUtil = context.getBean(AcademicCalcUtil.class);
		PrimarySchoolCalcUtil primarySchoolCalcUtil = context.getBean(PrimarySchoolCalcUtil.class);

		System.out.println(primarySchoolCalcUtil.calculate(3,5));
		System.out.println(academicCalcUtil.subtract(new Double(3.8),new Double(5.7)));

	}

}
