import com.sboot.backend.common.SpringConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@SpringBootApplication
@ContextConfiguration(classes = {SpringConfig.class})
@ComponentScan("com.sboot.backend.common")
@MapperScan("com.sboot.backend.common")
public class CommonApiApplication {
    private static final Logger logger = LogManager.getLogger(CommonApiApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CommonApiApplication.class, args);
        logger.info("Application Start!");
    }
}