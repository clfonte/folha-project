package br.edu.faculdadealfa.projectfolhaofi.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;

// Data Transfer Object 
// Data Access Object faz o acesso ao db
// classe intermediária
public class FuncionarioDto {

	private Long id;
	@NotBlank(message = "Informe o nome")
	@Length(min = 4, max = 100)
	private String nome;

	@NotNull(message = "Informe um CPF")
	@CPF(message = "Informe um CPF valido")
	private String cpf;

	@NotNull(message = "Informe o salario")
	private Double salario;
	private Integer codigoUsuario;

	public FuncionarioDto() {

	}

	public FuncionarioDto(Funcionario func) {
		this.id = func.getId();
		this.nome = func.getNome();
		this.cpf = func.getCpf();
		this.salario = func.getSalarioBase();
		this.codigoUsuario = func.getCodigoUsuario();
	}

	// alt shift s - getters e setter
	// r - seleciona a opcao
	// alt a - seleciona tudo
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

}
