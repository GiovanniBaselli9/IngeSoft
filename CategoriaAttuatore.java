import java.util.ArrayList;

public class CategoriaAttuatore {
	private String nome, descrizione;
	private boolean stato=true;
	private ArrayList<ModOperativa> modalita;
	
	CategoriaAttuatore(String nome, String descrizione){
		this.nome=nome;
		this.descrizione=descrizione;
		this.modalita=new ArrayList<ModOperativa>();
	}
	
	public void aggiungiModOperativa(String nomeMod /*, int parametro*/) {
		modalita.add(new ModOperativa(nomeMod));
	}
	
	public String getNome() {
		return nome;
	}
	
	public ArrayList<ModOperativa> getModalita(){
		return modalita;
	}
	
	public String toString() {
		return "Categoria attuatori: "+nome+"\nDescrizione: "+descrizione+"\nStato: "+stato+"\n";
	}
}
