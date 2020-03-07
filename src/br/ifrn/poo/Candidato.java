package br.ifrn.poo;


public class Candidato extends Eleitor{
	private String partido;
	private String numero;
	private String cargo;
	
	public Candidato() {
		
	}
	
	

	public Candidato(String nome, TituloEleitor tituloEleitor, String partido, String numero, String cargo) {
		super(nome, tituloEleitor);
			this.partido = partido;
			this.numero = numero;
			this.cargo = cargo;

	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	@Override
	public String toString() {
		return "Candidato [partido=" + partido + ", numero=" + numero + ", cargo=" + cargo + "]";
	}
	
}

