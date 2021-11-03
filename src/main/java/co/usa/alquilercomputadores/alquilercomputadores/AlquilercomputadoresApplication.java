package co.usa.alquilercomputadores.alquilercomputadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.usa.alquilercomputadores.alquilercomputadores.model"})
@SpringBootApplication
public class AlquilercomputadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlquilercomputadoresApplication.class, args);
	}

}
