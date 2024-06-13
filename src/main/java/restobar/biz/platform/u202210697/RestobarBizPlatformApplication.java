package restobar.biz.platform.u202210697;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RestobarBizPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestobarBizPlatformApplication.class, args);
	}

}
