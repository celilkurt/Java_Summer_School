import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public BookLibrary initBookLibrary(){
        return new JavaBookLibrary();
    }
}
