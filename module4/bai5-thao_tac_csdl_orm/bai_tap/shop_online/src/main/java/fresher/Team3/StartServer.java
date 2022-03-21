package fresher.Team3;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication


public class StartServer {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		
		System.out.println("start.....");
		System.out.println(new BCryptPasswordEncoder(4).encode("thanh99"));
		SpringApplication.run(StartServer.class,args);
		
		
		
	}

}