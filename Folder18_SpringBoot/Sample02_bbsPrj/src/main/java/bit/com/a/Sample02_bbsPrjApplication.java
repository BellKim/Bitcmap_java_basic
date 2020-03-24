package bit.com.a;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "bit.com.a")
public class Sample02_bbsPrjApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sample02_bbsPrjApplication.class, args);
	}

}
