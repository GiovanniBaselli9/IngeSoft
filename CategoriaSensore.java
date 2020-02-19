import java.util.ArrayList;

public class CategoriaSensore {

	private String nome, descrizione, unita="ueeella"; //METTERE UNITA GIUSTA
	private boolean stato;
	private ArrayList<Rilevazione> informazioni;
	
	
	CategoriaSensore(String nome, String descrizione){
		this.nome=nome;
		this.descrizione=descrizione;
		this.informazioni=new ArrayList<Rilevazione>();
		this.stato=true;
	}
	
	public Rilevazione aggiungiRilevazione(String nome, int min, int max) {
		boolean f=false;
		Rilevazione rilevazione=null;
		
		if(!informazioni.isEmpty()) {
			for(int i=0; i<informazioni.size(); i++)
				if(informazioni.get(i).getNome().equals(nome))	f=true;
		}
		
		if(f) System.out.println("Questo tipo di rilevazione è già disponibile.");
		else {
			rilevazione=new Rilevazione(nome, unita, min, max);
			informazioni.add(rilevazione);
			return rilevazione;
		}
		
		return null;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public String toString() {
		return "Categoria di sensori: "+nome+"\nDescrizione: "+descrizione+"\nStato: "+stato+"\n";
	}
}
