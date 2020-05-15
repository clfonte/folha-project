package br.edu.faculdadealfa.projectfolhaofi.telas;

import java.util.List;
import java.util.Scanner;

import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;
import br.edu.faculdadealfa.projectfolhaofi.model.Holerite;
import br.edu.faculdadealfa.projectfolhaofi.model.interfaces.Calculo;

public class EmissaoHolerite {
	public static List<Holerite> emitirHolerite(List<Funcionario> funcionarios, Scanner read) {
		
		System.out.println("ID de inicio");
		Long idInicio = read.nextLong();
		System.out.println("ID final");
		Long idFim = read.nextLong();
		
		System.out.println("Digite o m�s de calculo: ");
		Integer competencia = read.nextInt();
		
		System.out.println(" ___________________________________");
		System.out.println("| Qual tipo de folha deseja calcular?|");
		System.out.println("| 1   Salario                        |");
		System.out.println("| 2   Decimo Terceiro                |");
		System.out.println("| 3   Ferias                         |");
		System.out.println("| 4   SAIR                           |");
		System.out.println("|____________________________________|");
		int opcao = read.nextInt();
		
		

		switch (opcao) {
		case 1: // Calculo de Sal�rio 
			Calculo calculo = new CalculoSalario();
			return calculo.calcular(funcionarios, idInicio, idFim, competencia);			
			
		case 2: // Calculo de F�rias
			funcionarios.forEach(func -> {
				double ferias = 0;
				double salario_func = 0;
				if(func.getId() >= idInicio && func.getId() <= idFim) {
					salario_func = func.getSalarioBase();
					ferias = (salario_func + (salario_func / 3));
					System.out.println(ferias);
				}
			});
			break;
			
		case 3: // Calculo de 13�
			funcionarios.forEach(func -> {
				double decimo = 0;
				double salario_func = 0;
				if(func.getId() >= idInicio && func.getId() <= idFim) {
					System.out.println("Quantos meses" + func.getNome() + "");
					int meses = read.nextInt();
					salario_func = func.getSalarioBase();
					decimo = ((salario_func / 12) * meses); 
					System.out.println(decimo);
				}
			});
			break;
		case 4: 
			System.exit(0);
			
		default:
			System.out.println("Op��o inv�lida");
			break;
		}
		opcao = 0;
		return null;
	}
}
