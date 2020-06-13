package br.edu.faculdadealfa.projectfolhaofi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.faculdadealfa.projectfolhaofi.controller.FuncionarioController;
import br.edu.faculdadealfa.projectfolhaofi.visao.Principal;

@SpringBootApplication
public class ProjectFolhaOfiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjectFolhaOfiApplication.class, args);
	}
	
	// mapear
	@Autowired
	FuncionarioController controle;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Principal principal = new Principal();
		principal.principalRun(controle);
	}

}
