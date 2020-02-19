
public class Sensore {
	private String nome;
	private boolean stato;
	private CategoriaSensore categoria;
	
	Sensore(String nome, CategoriaSensore categoria){
		this.nome=nome;
		this.categoria=categoria;
		this.stato=true;
	}
	/*
	public void leggiInformazioni(){
		
	}
	*/
	public String getNome() {
		return nome;
	}
	
	public CategoriaSensore getCategoria() {
		return categoria;
	}
	
	public String toString() {
		return "Nome sensore: "+nome+"\nStato del sensore: "+stato+"\nCategoria del sensore: "+categoria.getNome();
	}
}
