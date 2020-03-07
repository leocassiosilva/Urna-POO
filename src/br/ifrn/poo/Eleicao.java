package br.ifrn.poo;
import java.util.Scanner;
public class Eleicao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		GerenciadorTSE gerenciando = new GerenciadorTSE();
		Menus todosMenus = new Menus();
		
		boolean recebendoVotar; 
		
		/**
		 * Variavei usadas
		 */
		int cadastroTSE = 1;
		int opcoesTSE = 0;
		int opcoesVoto;
		int qtdOpcoesMesario = 1; 
		int opcoesMesario = 0;
		
		/**
		 * Menu apenas para o cadastro do TSE (URNAS E ELEITORES)
		 */
		do {
			todosMenus.menuTse();
			 opcoesTSE = Integer.parseInt(input.nextLine());
			switch (opcoesTSE) {
			case 1:
				//Chama Cadastrar Urna
				System.out.println("Ola");
				break;
			case 2:
				//Chama Cadastrar eleitores
				break;
			case 3: 
				//Iniciar Votação
				
				cadastroTSE = -1;
				break;
			default:
				//Encerra o cadastro do TSE
				cadastroTSE = -1;
				break;
			}
			
		} while (cadastroTSE > 0);	
		
		/**
		 * MENU PARA MESARIO E VOTAÇÂO
		 */
		
		do {
			todosMenus.menuMesario(); //chama da classe o menus do mesario
			opcoesMesario  = Integer.parseInt(input.nextLine());
			String numCandidato;
			switch (opcoesMesario) {
			case 1:
				//Novo voto
				System.out.println("Digite o numero do titulo do eleitor: ");
				String titulo = input.nextLine();
				
				//Chamando o metodo de vrificar se o eleitor está cadastrado e retornando um booleano
				boolean verificando = gerenciando.verificar(titulo);
				
				//Ao verificar e se for verdadeiro entra no if para pedir voto ao candidato
				if (verificando == true) {
					
					todosMenus.opcoesEleitor(); //chamando da classe menus o metodo de menu do eleitor
					opcoesVoto = Integer.parseInt(input.nextLine());
					
					if (opcoesVoto == 1) { //Se ele escolher um deseja votar em algum dos dois candidatos
						System.out.println("Entre com o numero do candidato: ");
						numCandidato = input.nextLine();
						recebendoVotar = gerenciando.votar(titulo, numCandidato);
					}else if (opcoesVoto == 2) { //Se ele escolher dois deseja votar em branco
						numCandidato = "branco";
						gerenciando.votarBranco(titulo);
					}else {
						System.out.println("Erro!");
					}
					
				}else {
					//Caso não esteja cadastrado
					System.out.println("Titulo invalido!");
				}
				break;
			case 2:
				//Emitir boletim de cada urna
				System.out.println("---------------BOLETIM DE URNAS---------------");
				gerenciando.exibirBoletimTodasUrnas(); //Chamando o metodo exibirboletim
				System.out.println("----------------------------------------------");
				break;
			case 3:
				System.out.println("----------APURAÇÃO DA ELEIÇÃO 2018------------");
				gerenciando.apurar();//Chamando o metodo apuração da eleição
				qtdOpcoesMesario = -1;
			default:
				//quando digitar um numero distinto dos demais
				System.out.println("Numero não condiz com as opções!");
				break;
			}
		} while (qtdOpcoesMesario > 0);
		
	}

}
