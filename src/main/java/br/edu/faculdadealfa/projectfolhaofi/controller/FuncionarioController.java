package br.edu.faculdadealfa.projectfolhaofi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.faculdadealfa.projectfolhaofi.controller.dto.FuncionarioDto;
import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;
import br.edu.faculdadealfa.projectfolhaofi.model.repository.FuncionarioRepository;

// quando faz a anotação controlller, ele vai importar o controller do pacote spring e dizer que ela quem vai fazer
// o controle entre a visao e os models

@RestController
@RequestMapping("funcionario") // determina um nome para o end point
public class FuncionarioController {

	@Autowired
	FuncionarioRepository repository;

	// metodo salvar
	/*
	 * public Funcionario salvar(Funcionario funcionario) { return
	 * repository.save(funcionario); }
	 */

	// listar
	@GetMapping("listar")
	public List<Funcionario> listar() {
		return repository.findAll();
	}

	public Funcionario buscarPorId(Long id) {
		return repository.getOne(id);
	}

	public FuncionarioRepository getRepository() {
		return repository;
	}

	public void setRepository(FuncionarioRepository repository) {
		this.repository = repository;
	}

	// remover
	public Boolean remover(Funcionario funcionario) {
		repository.delete(funcionario);
		return true;
	}

	// metodos para dto - requisiçao http post
	@PostMapping("cadastrar")
	@Transactional
	public ResponseEntity<FuncionarioDto> cadastrarFuncionario(@RequestBody @Valid FuncionarioDto dto) {
		/*
		 * Funcionario funcionario = new Funcionario(dto.getNome(), dto.getCpf(),
		 * dto.getSalario());
		 * 
		 * funcionario.setDataAlteracao(LocalDateTime.now());
		 * funcionario.setCodigoUsuario(72);
		 * 
		 * repository.save(funcionario); return dto;
		 */

		return ResponseEntity.ok (new FuncionarioDto(repository.save(new Funcionario(dto))));
	}
}
