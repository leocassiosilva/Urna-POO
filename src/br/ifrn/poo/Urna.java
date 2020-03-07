package br.ifrn.poo;

public class Urna{
	
	private String numero; 
	private Candidato candidato1; 
	private Candidato candidato2;
	private int qtdTotalVotos;
	private int qtdCandidato1; 
	private int qtdCandidato2;
	private int qtdVotoBrancos; 
	private int qtdVotosNulos;
	private String branco; 
	
	/**
	 * Construtor não parametrizado
	 */
	public Urna () {
		 
	}
	
	/**
	 * Construtor parametrizado
	 * @param numero
	 * @param candidato1
	 * @param candidato2
	 */
	public Urna(String numero, Candidato candidato1, Candidato candidato2) {
		this.numero = numero; 
		this.candidato1 = new Candidato("Haddad", new TituloEleitor("222222", "1", "José da Penha"), "PT", "13", "Presidente");
		this.candidato2 = new Candidato("Bolsonaro" , new TituloEleitor("333333", "1", "José da Penha"), "PT", "17", "Presidente");
	}

	/**
	 * Metodos Gets e Sets
	 * @return
	 */
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

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

	public int getQtdTotalVotos() {
		return qtdTotalVotos;
	}

	public void setQtdTotalVotos(int qtdTotalVotos) {
		this.qtdTotalVotos = qtdTotalVotos;
	}

	public int getQtdCandidato1() {
		return qtdCandidato1;
	}

	public void setQtdCandidato1(int qtdCandidato1) {
		this.qtdCandidato1 = qtdCandidato1;
	}

	public int getQtdCandidato2() {
		return qtdCandidato2;
	}

	public void setQtdCandidato2(int qtdCandidato2) {
		this.qtdCandidato2 = qtdCandidato2;
	}

	public int getQtdVotoBrancos() {
		return qtdVotoBrancos;
	}

	

	public int getQtdVotosNulos() {
		return qtdVotosNulos;
	}

	public void setQtdVotosNulos(int qtdVotosNulos) {
		this.qtdVotosNulos = qtdVotosNulos;
	}
	
	/**
	 * Metodo para calcular a quantidade de votos do candidato 1
	 */
	public void qtdVotosCandidato1() {
		System.out.println("HADDAD : " + getQtdCandidato1() + " Validos.");
	}
	/**
	 * Metodo para calcular a quantidade de votos do candidato 1
	 */
	public void qtdVotosCandidato2() {
		System.out.println("BOLSONARO : " + getQtdCandidato2() + " Validos.");
	}
	
	/**
	 * Metodo para calcular a quantidade de votos do brancos
	 */
	public void qtdVotosBrancos() {
		System.out.println("Votos Brancos: " + getQtdVotoBrancos());
	}
	/**
	 * Metodo para calcular a quantidade de votos nulos
	 */
	public void qtdVotosNulos() {
		System.out.println("Votos Nulos: " + getQtdVotosNulos());
	}
	/**
	 * Metodo para calcular a quantidade total de votos
	 */
	public void qtdTotalVotos() {
		 getQtdTotalVotos();
	}	
	
	/**
	 * Metodo votar em branco
	 */
	public void votarBranco() {
		qtdVotoBrancos++;
		qtdTotalVotos = qtdVotoBrancos; //Aqui a quantidade total de votos vai receber os votos brancos
	}

	//Metodo de votar
	public void votar(String numCandidato) {
		if (getCandidato1().getNumero().equals(numCandidato)) {
			System.out.println("Haddad");
			qtdCandidato1++;
		}else if (getCandidato2().getNumero().equals(numCandidato)) {
			System.out.println("Bolsonaro");
			qtdCandidato2++;
		}else{
			System.out.println("Voto Nulo");
			qtdVotosNulos++;
		}
		//Vai fazer a soma dos candidatos e votos nulos
		qtdTotalVotos = getQtdCandidato1() + getQtdCandidato2() + getQtdVotosNulos();
	}
	
	/**
	 * Metodo emitir boletim
	 */
	public void emitirBoletimUrna() {
		
		System.out.println("--------------------------------------------");
		System.out.println("Urna : " + getNumero());
		System.out.println("Haddad: " + getQtdCandidato1());
		System.out.println("Bolsonaro: " + getQtdCandidato2());
		System.out.println("Votos Brancos: " + getQtdVotoBrancos());
		System.out.println("Votos Nulos: " + getQtdVotosNulos());
		System.out.println("Total votos: " + getQtdTotalVotos());
		System.out.println("--------------------------------------------");
	}
}
