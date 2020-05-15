package br.edu.faculdadealfa.projectfolhaofi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

// Faz mapear a classe para que indique que tem que ao iniciair tabela func
@Entity
public class Funcionario {

	@Id
	// Gera o id da tabela com AI
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Informe o nome.")
	@Length(min = 4, max = 60)
	private String nome;

	@CPF(message = "Informe um CPF valido.")
	private String CPF;

	// validar
	@NotNull(message = "Informe o salario.")
	private Double salarioBase;

	@NotBlank(message = "Informe o cargo")
	private String cargo;

	// quando apagar o funcionario ele vai apagar todos endereços relacionados a ele
	// para nao ter coisa sobrando no db
	// mappedBy nome do campo que esta sendo mapeado
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
	private List<Endereco> endereco;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario")
	private List<Holerite> holerites;

	// dois construtores para nao precisar inserir infos
	public Funcionario() {
		
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	

}
