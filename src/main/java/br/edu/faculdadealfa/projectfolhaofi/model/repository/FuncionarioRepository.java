package br.edu.faculdadealfa.projectfolhaofi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;

//                                   Tem que indicar a tipo da classe e a da ID
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	//  retorna list do func por ID 
	//* Funcionario findById(Long id);
	
	// retorna o func que tem o nome desejado
	//* Funcionario findByNome(String nome);
	
	//Optional<Funcionario> findById(Long id);
	
}
