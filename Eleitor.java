
public class Eleitor {
	private String nome;
	private TituloEleitor tituloEleitor;
	
	public Eleitor(String nome, TituloEleitor tituloEleitor) {
		this.nome = nome;
		this.tituloEleitor = tituloEleitor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TituloEleitor getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(TituloEleitor tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}


	@Override
	public String toString() {
		return nome + tituloEleitor;
				
	}
	

}
