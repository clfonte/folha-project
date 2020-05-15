package br.edu.faculdadealfa.projectfolhaofi.telas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.faculdadealfa.projectfolhaofi.controller.FuncionarioController;
import br.edu.faculdadealfa.projectfolhaofi.model.Funcionario;

public class Principal {

	public void principalRun(FuncionarioController controle) {
		Scanner read = new Scanner(System.in);
		List<Funcionario> funcionarios = new ArrayList<>();
		int opcao = 0;
		int contId = 0;
		

		do {

			System.out.println(" __________ OPCOES __________");
			System.out.println("| 1   Funcionario            |");
			System.out.println("| 2   Folha de pagamento     |");
			System.out.println("| 3   SAIR                   |");
			System.out.println("|____________________________|");
			
			opcao = read.nextInt();

			switch (opcao) {
			case 1:// cadastro funcionario

				System.out.println("1. Cadastrar Funcionario");
				System.out.println("2. Listar Funcionarios");
				
				opcao = read.nextInt();		
				
				switch (opcao) {
				case 1:
					// contId++;
					Funcionario func = controle.salvar(CadastroFuncionario.cadastrar(read));
					
					System.out.println("Funcionario " + func.getNome() + " cadastrado com sucesso." + "No cargo de " + func.getCargo() 
					+ ", com salario de R$" + func.getSalarioBase());
					
					break;
				
				case 2: //listar funcionarios
					System.out.println("Funcionarios cadastrados:");
					
					 for (int i = 0; i < contId; i++) {
				     Funcionario funcionario =  funcionarios.get(i);
					 System.out.println(funcionario.getNome());
			         System.out.println(funcionario.getCargo());
					 System.out.println(funcionario.getSalarioBase());
					 System.out.println("");
					 }
					
					// controle.listar();
					break;
				}
				
				break;

			case 2: // calculo folha		
				EmissaoHolerite.emitirHolerite(funcionarios, read).forEach(holerite->{ //est�tico - chama sem instanciar ( = new ) / foreach - m�todo de lista
					System.out.println("------------" + holerite.getTipoFolha() + "------------");
					System.out.println("Funcionario " + holerite.getFuncionario().getNome());
					System.out.println("Salario R$"+ holerite.getFuncionario().getSalarioBase());
					System.out.println("Competencia: mes " + holerite.getCompetencia());
					holerite.getEventos().forEach(evento->{ //puxa a lista de eventos, para cada evento, adiciona uma linha
						System.out.println(evento.toString());
						
						//calculo dos totais

						System.out.println("Vencimentos: R$" + holerite.getVencimentos());
						System.out.println("Descontos: R$" + holerite.getDescontos());
						System.out.println("Total: R$" + holerite.getTotal());
						
					});
					System.out.println("");
				});; //retorna a lista de holerites
				
				
				break;
			case 3: // sair
				System.out.println("Aplicacao encerrada.");
				break;
				
			default:
				System.out.println("Opcao invalida");
				break;
			}
		} while (opcao != 3);
		read.close(); // encerra o objeto scanner
	}
}
