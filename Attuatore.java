import java.util.ArrayList;

public class Attuatore {
	private String nome;
	private CategoriaAttuatore categoria;
	private boolean stato; 
	private ArrayList<ModOperativa> modalita;
	
	
	Attuatore(String nome, CategoriaAttuatore categoria){
		this.nome=nome;
		this.categoria=categoria;
		this.stato=true; //attivo sempre
		this.modalita=categoria.getModalita();
	}
	
	
	
	public void aziona(){
		stato=true;
	}
	
	public void blocca(){
		stato=false;
	}
	
	public String getNome() {
		return nome;
	}
	
	public CategoriaAttuatore getCategoria() {
		return categoria;
	}
	
	public String toString() {
		return "Nome attuatore: "+nome+"\nStato attuatore: "+stato+"\nCategoria del sensore: "+categoria.getNome();
	}
}

