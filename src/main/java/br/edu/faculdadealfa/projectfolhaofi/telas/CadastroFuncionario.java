package br.edu.faculdadealfa.projectfolhaofi.telas;

import java.util.Scanner;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;

public class CadastroFuncionario {
	public static Funcionario cadastrar(Scanner read) { 
		//static -> chama direto para nao precisa de new 
		
		/*uma classe que serve para um processo, nao precisa de instanciar para executar, chama direto*/
		Funcionario funcionario = new Funcionario();
		
		System.out.println("Digite o nome do funcionario: ");
		funcionario.setNome(read.next());
		
		System.out.println("Informe o cargo de " + funcionario.getNome() + ": ");
		funcionario.setCargo(read.next());
		

		System.out.println("Digite o salario de " + funcionario.getNome() + ": ");
		funcionario.setSalarioBase(read.nextDouble());

		System.out.println("Funcionario " + funcionario.getNome() + " cadastrado.\nSalario:  R$" + funcionario.getSalarioBase()
		+ ". No cargo de " + funcionario.getCargo());
		System.out.println();
		
		return funcionario;
	}
}
