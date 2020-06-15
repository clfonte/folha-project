package br.edu.faculdadealfa.projectfolhaofi.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping()
	public List<FuncionarioDto> listar() {
		List<FuncionarioDto> dtoList = new ArrayList<FuncionarioDto>();
		repository.findAll().forEach(func -> {
			dtoList.add(new FuncionarioDto(func));
		});
		return dtoList;
	}

	// var referente ao id - metodo get que precisa da var que passa pela url
	// responseEntity - template de respostas
	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioDto> buscarPorId(@PathVariable Long id) {
		try {
			// return repository.getOne(id);
			Funcionario func = repository.getOne(id);

			// if (func != null) {
			return ResponseEntity.ok(new FuncionarioDto(func));

		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	public FuncionarioRepository getRepository() {
		return repository;
	}

	public void setRepository(FuncionarioRepository repository) {
		this.repository = repository;
	}

	// mais utilizado quando vai fazer alteraçao de infos
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FuncionarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid FuncionarioDto dto) {
		try {
			Funcionario func = repository.getOne(id);

			func.setNome(dto.getNome());
			func.setCpf(dto.getCpf());
			func.setSalarioBase(dto.getSalario());
			func.setCodigoUsuario(dto.getCodigoUsuario());
			func.setDataAlteracao(LocalDateTime.now());

			return ResponseEntity.ok(new FuncionarioDto(func));

		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	// remover
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		try {
			Funcionario func = repository.getOne(id);
			if (func != null) {
				repository.delete(func);

				return ResponseEntity.ok().build();
			} else {

				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}

	// metodos para dto - requisiçao http post
	// ResponseEntity devolve um json mais amigavel
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

		return ResponseEntity.ok(new FuncionarioDto(repository.save(new Funcionario(dto))));
	}
}
