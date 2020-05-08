package br.edu.faculdadealfa.projectfolhaofi.model.telas;

import java.util.Scanner;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;

public class CadastroFuncionario {
	public static Funcionario cadastrar(Scanner read) { 
		//static -> chama direto para n�o precisa de new 
		
		/*uma classe que serve para um processo, n�o precisa de instanciar para executar, chama direto*/
		Funcionario funcionario = new Funcionario();
		
		System.out.println("Digite o nome do funcion�rio: ");
		funcionario.setNome(read.next());
		
		System.out.println("Informe o cargo de " + funcionario.getNome() + ": ");
		funcionario.setCargo(read.next());
		

		System.out.println("Digite o sal�rio de " + funcionario.getNome() + ": ");
		funcionario.setSalarioBase(read.nextDouble());

		System.out.println("Funcionario " + funcionario.getNome() + " cadastrado.\nSal�rio:  R$" + funcionario.getSalarioBase());
		System.out.println();
		
		return funcionario;
	}
}
