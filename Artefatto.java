import java.util.*;

public class Artefatto {
	private String nome;
	private ArrayList<Attuatore> attuatoriCollegati;
	private ArrayList<Sensore> sensoriCollegati;
	
	
	Artefatto(String nome){
		this.nome=nome;
		this.attuatoriCollegati=new ArrayList<Attuatore>();
		this.sensoriCollegati=new ArrayList<Sensore>();
	}
	
	//posso collegare al max un sensore di una certa categoria
	public void collegaSensore(String nomeSensore, UnitaImmobiliare unita){
		boolean f=false, c=false;
		ArrayList<Sensore> lista=unita.getSensori();
		Sensore sensor=null;
		
		
		for(int i=0; i<lista.size(); i++) {
			
			if(lista.get(i).getNome().equals(nomeSensore)) {
				sensor=lista.get(i);
			}
		}
		
		if(sensor==null) System.out.println("Il sensore non esiste nell'unità immobiliare.");
		else {
			if(!sensoriCollegati.isEmpty()) {
				for(int i=0; i<sensoriCollegati.size(); i++) {
					if(sensoriCollegati.get(i).equals(sensor)) f=true;
				}
				
				if(f) System.out.println("Il sensore è gia collegato");
				else {
					for(int j=0; j<sensoriCollegati.size(); j++) 
						if(sensoriCollegati.get(j).getCategoria().equals(sensor.getCategoria()))  c=true;	
				}
				
				
			}
			if(!f && c) System.out.println("Non posso aggiungere più di un sensore della stessa categoria");
			else sensoriCollegati.add(sensor);
			
		
		}
		
	}
	
	public void collegaAttuatore(String nomeAttuatore, UnitaImmobiliare unita){
		boolean f=false, c=false;
		ArrayList<Attuatore> lista= unita.getAttuatori();
		Attuatore attuator=null;
		
		
		for(int i=0; i<lista.size(); i++) {
			
			if(lista.get(i).getNome().equals(nomeAttuatore)) {
				attuator=lista.get(i);
			}
		}
		
		if(attuator==null) System.out.println("L'attuatore non esiste nell'unità immobiliare.");
		else {
			if(!attuatoriCollegati.isEmpty()) {
				for(int i=0; i<attuatoriCollegati.size(); i++) {
					if(attuatoriCollegati.get(i).equals(attuator)) f=true;
				}
				
				if(f) System.out.println("L'attuatore è gia collegato");
				else {
					for(int j=0; j<attuatoriCollegati.size(); j++) 
						if(attuatoriCollegati.get(j).getCategoria().equals(attuator.getCategoria())) c=true;	
				}
			}
			
			if(!f && c) System.out.println("Non posso aggiungere più di un attuatore della stessa categoria");
			else attuatoriCollegati.add(attuator);
			
		
		}
	}
	
	public void visualizzaSensoriCollegati(){
		if(sensoriCollegati.isEmpty())
			System.out.println("Non ho sensori collegati all'artefatto.");
		else sensoriCollegati.forEach((sens)-> System.out.println(sens.toString()));
	}
	
	public void visualizzaAttuatoriCollegati(){
		if(attuatoriCollegati.isEmpty())
			System.out.println("Non ho attuatori collegati all'artefatto.");
		else attuatoriCollegati.forEach((att)-> System.out.println(att.toString()));
	}
	
	public String getNome() {
		return nome;
	}
	
	public ArrayList<Sensore> getSensoriCollegati(){
		return sensoriCollegati;
	}
	
	public String toString() {
		return "Nome artefatto: "+nome+"\nNumero sensori collegati: "+sensoriCollegati.size()+"\n"
				+ "Numero attuatori collegati: "+attuatoriCollegati.size();
	}
	
}
