import java.util.ArrayList;


//classe UnitaImmobiliare: mi rappresenta una singola unità immobiliare
public class UnitaImmobiliare {
	private String nome;
	private String tipologia;
	private ArrayList<Stanza> stanze;
	private ArrayList<Sensore> sensori;
	private ArrayList<Attuatore> attuatori;
	private ArrayList<Artefatto> artefatti;
	
	//SCRIVERE COSTRUTTORE
	UnitaImmobiliare(String nome, String tipologia){
		this.nome=nome;
		this.tipologia=tipologia;
		this.stanze=new ArrayList<Stanza>();
		this.sensori=new ArrayList<Sensore>();
		this.attuatori=new ArrayList<Attuatore>();
		this.artefatti=new ArrayList<Artefatto>();
	}
	
	final private static String [] MENUASSOCIAZIONI = {"Associazioni stanze",
	"Associazioni artefatti",
	"Associazioni sensori",
	"Associazioni attuatori"};
	
	
	
	public void aggiungiStanza(String nomeStanza){
		//utilizzo metodo di arrayList per aggiungere nuova Stanza
		boolean f=false;
		
		if(!stanze.isEmpty()) {
			
			for(int i=0; i<stanze.size(); i++) {
				if(stanze.get(i).getNome().equals(nomeStanza)) f=true;
			}
		}
		
		if(f) System.out.println("Stanza già presente.");
		else stanze.add(new Stanza(nomeStanza));
	}
	
	public void visualizzaElencoStanze(){
		//stampa elenco stanze presenti
		if(stanze.isEmpty())
			System.out.println("Non ho stanze in questa unità.");
		else stanze.forEach((stanza)-> System.out.println(stanza.toString()));
	}
	
	public void nuovoSensore(String nomeSensore, String categoria, ImpiantoDomotico impianto){
		
		boolean f=false;
		CategoriaSensore cat = null;
		
		if(!impianto.getCategorieSensori().isEmpty()) {
			
			for(int i=0; i<impianto.getCategorieSensori().size(); i++) {
				if(impianto.getCategorieSensori().get(i).getNome().equals(categoria)) {
					f=true;
					cat=impianto.getCategorieSensori().get(i);
				}
			}	
			
		}
		
		if(f) sensori.add(new Sensore(nomeSensore+"_"+cat.getNome(), cat));
		else System.out.println("Non ho ancora definito alcuna categoria di questo tipo \ndi sensore nel mio impianto, non posso aggiungere sensore.");
		
	}
	
	public void nuovoAttuatore(String nomeAttuatore, String categoria, ImpiantoDomotico impianto){
		boolean f=false;
		CategoriaAttuatore cat=null;
		
		if(!impianto.getCategorieAttuatori().isEmpty()) {
			
			for(int i=0; i<impianto.getCategorieAttuatori().size(); i++) {
				if(impianto.getCategorieAttuatori().get(i).getNome().equals(categoria)) {
					f=true;
					cat=impianto.getCategorieAttuatori().get(i);
				}
			}
		}
		
		if(f) attuatori.add(new Attuatore(nomeAttuatore+"_"+cat.getNome(), cat));
		else System.out.println("Non ho ancora definito alcuna categoria di questo tipo \ndi attuatore nel mio impianto, non posso aggiungere attuatore.");
		
	}
	
	public void nuovoArtefatto(String nomeArtefatto){
		boolean f=false;
		
		if(!artefatti.isEmpty()) {
			for(int i=0; i<artefatti.size(); i++) {
				if(artefatti.get(i).getNome().equals(nomeArtefatto)) f=true;
			}
		}
		
		if(f) System.out.println("L'artefatto è gia presente.");
		else artefatti.add(new Artefatto(nomeArtefatto));
	}
	/*
	public void modificaStanza(Stanza stanza){
		
	}
	
	public void modificaSensore(Sensore sensore){
		
	}
	
	public void modificaAttuatore(Attuatore attuatore){
		
	}
	
	public void modificaArtefatto(Artefatto artefatto){
		
	}
	*/
	public void stampaSensori() {
		if(sensori.isEmpty())
			System.out.println("Non ho alcun sensore registrato.");
		else sensori.forEach((sens)-> System.out.println(sens.toString()));
	}
	
	public void stampaAttuatori() {
		if(attuatori.isEmpty())
			System.out.println("Non ho alcun sensore registrato.");
		else attuatori.forEach((att)-> System.out.println(att.toString()));
	}
	
	
	public String toString() {
		return "Nome unità: "+nome+"\nTipologia: "+tipologia+";"
				+ "\nNumero stanze: "+stanze.size()+";\nNumero artefatti: "+artefatti.size()+"\n";
		
	}

	void visualizzaAssociazioni() {
		MyMenu sceltaAssoc=new MyMenu("Scegli quali associazioni visualizzare dell'unità '"+nome+"': ", MENUASSOCIAZIONI);
		int sceltaInt;
		
		do {
			sceltaInt=sceltaAssoc.scegli();
			System.out.println(" ");
			
			switch(sceltaInt) {
			case 1:
				if(!stanze.isEmpty()) {
					System.out.println("- stanze: ");
					for(int i=0; i<stanze.size(); i++) {
						System.out.println(stanze.get(i).toString());
						System.out.println("\n\tSensori associati: ");
						stanze.get(i).visualizzaSensori();
						System.out.println("\n\tAttuatori associati: ");
						stanze.get(i).visualizzaAttuatori();
						System.out.println("\n\tArtefatti associati: ");
						stanze.get(i).visualizzaArtefatti();
					}
				}
				else System.out.println("Non sono ancora state inserite stanze.");
				break;
				
			case 2: 
				if(!artefatti.isEmpty()) {
					System.out.println("- artefatti: ");
					for(int i=0; i<artefatti.size(); i++) {
						System.out.println(artefatti.get(i).toString());
						System.out.println("\n\tSensori associati: ");
						artefatti.get(i).visualizzaSensoriCollegati();
						System.out.println("\n\tAttuatori associati: ");
						artefatti.get(i).visualizzaAttuatoriCollegati();
					}
				}
				else System.out.println("- Non sono ancora stati inseriti artefatti.");
				break;
				
			default: 
				System.out.println("\nScelta non disponibile.");
			}
				
			
		}while(sceltaInt!=0);
		
	}

	public String getNome() {
		return nome;
	}

	public String getTipologia() {
		return tipologia;
	}

	public ArrayList<Stanza> getStanze() {
		return stanze;
	}


	public ArrayList<Sensore> getSensori() {
		return sensori;
	}

	public ArrayList<Attuatore> getAttuatori() {
		return attuatori;
	}


	public ArrayList<Artefatto> getArtefatti() {
		return artefatti;
	}
	
}
