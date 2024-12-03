package mcg.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"mcg.usuario","com.mcg.commonsService.usuario.models.entity"})
@EnableJpaRepositories("mcg.usuario.repository")
@EntityScan("com.mcg.commonsService.usuario.models.entity")
public class UsuarioApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsuarioApplication.class, args);
	}

}
