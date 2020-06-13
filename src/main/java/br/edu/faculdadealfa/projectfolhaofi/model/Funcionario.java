package br.edu.faculdadealfa.projectfolhaofi.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.edu.faculdadealfa.projectfolhaofi.controller.dto.FuncionarioDto;

@Entity
public class Funcionario extends TemplateTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Informe o nome")
	@Length(min = 4, max = 100)
	private String nome;

	@Column(name = "DS_CPF")
	private String cpf;

	@NotNull(message = "Informe o salario")
	private Double salarioBase;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
	// vem da classe endereço
	// se excluir o funcionario apaga os enderecos relacionados
	// cria uma lista de enderecos para o funcionario
	private List<Endereco> enderecos;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
	private List<Holerite> holerites;

	private String cargo;

	// dois construtores para nao precisar inserir as infos
	public Funcionario() {

	}

	public Funcionario(FuncionarioDto dto) {
		this.nome = dto.getNome();
		this.cpf = dto.getCpf();
		this.salarioBase = dto.getSalario();

		this.setCodigoUsuario(dto.getCodigoUsuario());
		this.setDataAlteracao(LocalDateTime.now());
	}

	public Funcionario(String nome, String string, Double salarioBase) {
		this.nome = nome;
		this.salarioBase = salarioBase;
	}

	public Funcionario(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Holerite> getHolerites() {
		return holerites;
	}

	public void setHolerites(List<Holerite> holerites) {
		this.holerites = holerites;
	}

}