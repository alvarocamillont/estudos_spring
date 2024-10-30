package br.com.estudo.consultafip;

import br.com.estudo.consultafip.br.com.estudo.consultafip.services.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsultaFipApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConsultaFipApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var principal = new Principal();
        principal.mostraMenuPrincipal();
    }
}
