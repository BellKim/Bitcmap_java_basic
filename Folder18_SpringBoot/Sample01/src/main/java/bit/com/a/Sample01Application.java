package bit.com.a;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "")
public class Sample01Application {

	public static void main(String[] args) {
		SpringApplication.run(Sample01Application.class, args);
	}
	

}
