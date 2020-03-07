package br.ifrn.poo;


public class TituloEleitor{
	private String numeroTitulo;
	private String numeroUrna;
	private String cidade;
	
	/**
	 * Construtores
	 */
	public TituloEleitor() {
		
	}
	public TituloEleitor(String numeroTitulo, String numeroUrna, String cidade) {
		this.numeroTitulo = numeroTitulo;
		this.numeroUrna = numeroUrna;
		this.cidade = cidade;
	}
	
	
	/**
	 * Metodos GETS E SETS
	 * @return
	 */
	public String getNumeroTitulo() {
		return numeroTitulo;
	}

	public void setNumeroTitulo(String numeroTitulo) {
		this.numeroTitulo = numeroTitulo;
	}

	public String getNumeroUrna() {
		return numeroUrna;
	}

	public void setNumeroUrna(String numeroUrna) {
		this.numeroUrna = numeroUrna;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	@Override
	public String toString() {
	
		return numeroTitulo + numeroUrna+ cidade;
	}
}

