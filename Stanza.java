import java.util.ArrayList;

public class Stanza {
	private String nome;
	private ArrayList<Artefatto> artefatti;
	private ArrayList<Sensore> sensori;
	private ArrayList<Attuatore> attuatori;
	
	Stanza(String nome){
		this.nome=nome;
		this.artefatti=new ArrayList<Artefatto>();
		this.sensori=new ArrayList<Sensore>();
		this.attuatori=new ArrayList<Attuatore>();
	}
	
	public void aggiungiArtefatto(String nomeArtefatto, UnitaImmobiliare unita){
		
		boolean f=false;
		ArrayList<Artefatto> lista=unita.getArtefatti();
		Artefatto artef=null;
		
		
		for(int i=0; i<lista.size(); i++) {
			
			if(lista.get(i).getNome().equals(nomeArtefatto)) {
				artef=lista.get(i);
			}
		}
		
		if(artef==null) System.out.println("L'artefatto non esiste nell'unità immobiliare.");
		else {
			if(!artefatti.isEmpty()) {
				for(int i=0; i<artefatti.size(); i++) 
					if(artefatti.get(i).equals(artef)) f=true;
				
			}
			if(f) System.out.println("L'artefatto è gia presente nella stanza");
			else artefatti.add(artef);
			
		}
		
	}
	
	public void aggiungiSensore(String nomeSensore, UnitaImmobiliare unita){
		
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
			if(!sensori.isEmpty()) {
				for(int i=0; i<sensori.size(); i++) {
					if(sensori.get(i).equals(sensor)) f=true;
				}
				
				if(f) System.out.println("Il sensore è gia collegato");
				else {
					for(int j=0; j<sensori.size(); j++) 
						if(sensori.get(j).getCategoria().equals(sensor.getCategoria()))  c=true;	
				}
				
				
			}
			if(!f && c) System.out.println("Non posso aggiungere più di un sensore della stessa categoria");
			else sensori.add(sensor);
		}
		
	}
	
	public void aggiungiAttuatore(String nomeAttuatore, UnitaImmobiliare unita){
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
			if(!attuatori.isEmpty()) {
				for(int i=0; i<attuatori.size(); i++) {
					if(attuatori.get(i).equals(attuator)) f=true;
				}
				
				if(f) System.out.println("L'attuatore è gia collegato");
				else {
					for(int j=0; j<attuatori.size(); j++) 
						if(attuatori.get(j).getCategoria().equals(attuator.getCategoria())) c=true;	
				}
			}
			
			if(!f && c) System.out.println("Non posso aggiungere più di un attuatore della stessa categoria");
			else attuatori.add(attuator);
		}
	}
	
	public void visualizzaArtefatti(){
		if(artefatti.isEmpty())
			System.out.println("Non ho artefatti nella stanza.");
		else artefatti.forEach((art)-> System.out.println(art.toString()));
	}
	
	public void visualizzaSensori(){
		if(sensori.isEmpty())
			System.out.println("Non ho sensori collegati nella stanza.");
		else sensori.forEach((sens)-> System.out.println(sens.toString()));
	}
	
	public void visualizzaAttuatori(){
		if(attuatori.isEmpty())
			System.out.println("Non ho attuatori collegati nella stanza.");
		else attuatori.forEach((att)-> System.out.println(att.toString()));
	}
	
	public String getNome() {
		return nome;
	}
	
	public ArrayList<Sensore> getSensori(){
		return sensori;
	}
	
	public String toString() {
		return "Nome stanza: "+nome+";\nNumero attuatori: "+attuatori.size()+"\n"
				+"Numero sensori: "+sensori.size()+";\nNumero artefatti: "+artefatti.size()+"\n";
	}
}
