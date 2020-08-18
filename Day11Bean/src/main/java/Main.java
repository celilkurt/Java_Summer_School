import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args){

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        JavaBookLibrary javaBookLibrary = (JavaBookLibrary)context.getBean("initBookLibrary",BookLibrary.class);
        BookReader bookReader = new BookReader(javaBookLibrary);
        bookReader.getInstance().getBooks().stream().forEach(System.out::println);

    }


}
