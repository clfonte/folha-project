package br.edu.faculdadealfa.projectfolhaofi.model.telas;
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

			System.out.println(" _____________ OPCOES ______________");
			System.out.println("| 1   Funcionario                   |");
			System.out.println("| 2   Folha de pagamento            |");
			System.out.println("| 3   SAIR                          |");
			System.out.println("|___________________________________|");
			
			opcao = read.nextInt();

			switch (opcao) {
			case 1:// cadastro funcion�rio

				System.out.println("1. Cadastrar Funcionario");
				System.out.println("2. Listar Funcionarios");
				
				opcao = read.nextInt();		
				
				if (opcao == 1) {
					contId++;
					Funcionario funcionario = controle.salvar(CadastroFuncionario.cadastrar(read));
				
				} else if (opcao ==2 ) { //listar funcionarios
					for (int i = 0; i < contId; i++) {
						Funcionario func =  funcionarios.get(i);
						System.out.println(func.getNome());
						System.out.println(func.getCargo());
						System.out.println(func.getSalarioBase());
						System.out.println("");
					}
				}
				break;

			case 2: // calculo folha		
				EmissaoHolerite.emitirHolerite(funcionarios, read).forEach(holerite->{ //est�tico - chama sem instanciar ( = new ) / foreach - m�todo de lista
					System.out.println("------------" + holerite.getTipoFolha() + "------------");
					System.out.println("Funcion�rio " + holerite.getFuncionario().getNome());
					System.out.println("Sal�rio R$"+ holerite.getFuncionario().getSalarioBase());
					System.out.println("Compet�ncia: m�s " + holerite.getCompetencia());
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
				System.out.println("Aplica��o encerrada.");
				break;
				
			default:
				System.out.println("Op��o inv�lida");
				break;
			}
		} while (opcao != 3);
		read.close(); // encerra o objeto scanner
	}
}
