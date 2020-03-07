package br.ifrn.poo;

import java.util.Arrays;

public class GerenciadorTSE {
	private Candidato candidato1;
	private Candidato candidato2;
	private Urna urnas[] = new Urna[2];
	private Eleitor eleitores [] = new Eleitor[3]; 
	private int qtdUrnas = 0;
	private int qtdEleitores = 0;
	
	/**
	 * Construtor
	 */
	public GerenciadorTSE() {
		
		Eleitor eleitor1 = new Eleitor("Pedro \n", new TituloEleitor("111112", "1", "José da Penha"));
		Eleitor eleitor2 = new Eleitor("Maria \n", new TituloEleitor("111113", "1", "José da Penha"));
		Eleitor eleitor3 = new Eleitor("Livia \n", new TituloEleitor("111114", "2", "Luis Gomes"));
		this.eleitores[this.qtdEleitores++] = eleitor1;
		this.eleitores[this.qtdEleitores++] = eleitor2;
		this.eleitores[this.qtdEleitores++] = eleitor3;
		this.candidato1 = new Candidato("Haddad", new TituloEleitor("222222", "1", "José da Penha"), "PT", "13", "Presidente");
		this.candidato2 = new Candidato("Bolsonaro" , new TituloEleitor("333333", "1", "José da Penha"), "PT", "15", "Presidente");
		
		Urna urna1 = new Urna("1", candidato1, candidato2);
		Urna urna2 = new Urna("2", candidato1, candidato2);
		this.urnas[this.qtdUrnas++] = urna1;
		this.urnas[this.qtdUrnas++] = urna2;
	}
	
	
	/**
	 * Metodos gets e sets
	 * @return
	 */
	public Candidato getCandidato1() {
		return candidato1;
	}

	public void setCandidato1(Candidato candidato1) {
		this.candidato1 = candidato1;
	}

	public Candidato getCandidato2() {
		return candidato2;
	}

	public void setCandidato2(Candidato candidato2) {
		this.candidato2 = candidato2;
	}
	
	public int getQtdEleitores() {
		return qtdEleitores;
	}

	public void setQtdEleitores(int qtdEleitores) {
		this.qtdEleitores = qtdEleitores;
	}
	
	public int getQtdUrnas() {
		return qtdUrnas;
	}

	public void setQtdUrnas(int qtdUrnas) {
		this.qtdUrnas = qtdUrnas;
	}

	
	/**
	 * Metodo usado para verificar se um determinado eleitor está cadastrado
	 * @param numero
	 * @return
	 */
	public boolean verificar(String numero) {
		 for (int i = 0; i < this.qtdEleitores; i++) {
			 if (eleitores[i].getTituloEleitor().getNumeroTitulo().equals(numero)) {
				System.out.println("Titulo encontrado");
				 return  true;
			 }
		 }
		 return false;
	}
	
	/**
	 * Metodo Votar que chama o metodo votar da classe urna e ele recebe como parametros o numero do titulo e o numero do candidato
	 * @param numeroTitulo
	 * @param numCandidato
	 * @return
	 */
	public boolean votar (String numeroTitulo, String numCandidato) {
		for (int i = 0; i < this.qtdEleitores; i++) {
			Eleitor eleitor = eleitores[i];
			if (eleitor.getTituloEleitor().getNumeroTitulo().equals(numeroTitulo)) {
				for (int j = 0; j < this.qtdUrnas; j++) {
					Urna todasUrnas = urnas[j];
					if (eleitores[i].getTituloEleitor().getNumeroUrna().equals(todasUrnas.getNumero())) {
						todasUrnas.votar(numCandidato);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Metodos usado para votar em branco no qual pega apenas o numero do titulo do eleitor
	 * @param numeroTitulo
	 */
	public void votarBranco (String numeroTitulo) {
		for (int i = 0; i < this.qtdEleitores; i++) {
			Eleitor eleitor = eleitores[i];
			if (eleitor.getTituloEleitor().getNumeroTitulo().equals(numeroTitulo)) {
				for (int j = 0; j < this.qtdUrnas; j++) {
					Urna todasUrnas = urnas[j];
					if (eleitores[i].getTituloEleitor().getNumeroUrna().equals(todasUrnas.getNumero())) {
						todasUrnas.votarBranco();
					}
				}
			}
		}
	}
	
	/**
	 * Metodo para exibir o boletim de cada urna
	 */
	public void exibirBoletimTodasUrnas() {
		for (int i = 0; i < this.qtdUrnas; i++) {
			urnas[i].emitirBoletimUrna();
			System.out.println(urnas[i].getQtdCandidato1());
		}
	}
	
	/**
	 * Metodo para apurar o resultado da eleição
	 */
	public void apurar() {
		int totalCandidato1 = 0;
		int totalCandidato2 = 0;
		int totalVotosBrancos = 0;
		int totalVotosNulos = 0;
		int totalDeVotosValidos = 0;
		int totalDeTodosVotos = 0;
		
		for (int i = 0; i < this.qtdUrnas; i++) {
			totalCandidato1 += urnas[i].getQtdCandidato1();
			totalCandidato2 += urnas[i].getQtdCandidato2();
			totalVotosBrancos += urnas[i].getQtdVotoBrancos();
			totalVotosNulos += urnas[i].getQtdVotosNulos(); 
 		}
		
		totalDeVotosValidos += totalCandidato1 + totalCandidato2;
		totalDeTodosVotos += totalDeVotosValidos + totalVotosBrancos + totalVotosNulos;
		
		System.out.println("----------------RESULTADO FINAL---------------------");
		System.out.println("Total " + getCandidato1().getNome() + " : " + totalCandidato1);
		System.out.println("Total " + getCandidato2().getNome() + " : " + totalCandidato2);
		System.out.println("Total Votos Brancos: " + totalVotosBrancos);
		System.out.println("Total Votos Nulos: " + totalVotosNulos);
		System.out.println("Total de Votos Validos: " + totalDeVotosValidos + "\n");
		System.out.println("Total de Votos: " + totalDeTodosVotos + "\n");
		
		System.out.println("----------------------------------------------------");
		System.out.println("-----------------------VENCEDOR---------------------");
		if (totalCandidato1 > totalCandidato2) {
			System.out.println(getCandidato1());
		}
	}
}
