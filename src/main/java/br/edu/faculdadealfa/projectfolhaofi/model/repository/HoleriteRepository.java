package br.edu.faculdadealfa.projectfolhaofi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.faculdadealfa.projectfolhaofi.model.Holerite;

public interface HoleriteRepository extends JpaRepository<Holerite, Long>{
	// List<Holerite> findByFuncionario(Funcionario funcionario);
	
}

// templatetable serve para classes filhas pra que todas a entidades possuam a mesma informação