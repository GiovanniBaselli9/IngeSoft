import java.io.*;

public class MainApp {

	final private static String NEWCATEGORY = "Inserisci il nome: ";
	final private static String DESCRIZIONE = "Inserisci la descrizione: ";
	final private static String FILECATEGORIE ="ElencoCat.txt";
	
	final private static String [] MENUSCELTA = {"Manutentore",
			"Fruitore"};
	
	final private static String [] MENUMANUT = {"Aggiungi nuova categoria di sensori",
			 "Aggiungi nuova categoria di attuatori",
			 "Crea unita immobiliare",
			 "Aggiungi nuovo sensore",
			 "Aggiungi nuovo attuatore",
			 "Aggiungi nuova stanza",
			 "Aggiungi nuovo artefatto",
			 "Associa sensore a stanze / artefatti",
			 "Associa attuatore a stanze / artefatti",
			 "Visualizza elenco delle categorie di sensori",
			 "Visualizza elenco delle categorie di attuatori",
			 "Visualizza elenco unità immobiliari",
			 "Visualizza descrizione unità immobiliare"};
	
	final private static String [] MENUFRUIT = {"Visualizza elenco delle categorie di sensori",
			 "Visualizza elenco delle categorie di attuatori",
			 "Visualizza descrizione unità immobiliare",
			 "Visualizza valori rilevati dai sensori"};
			
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		MyMenu manutentore=new MyMenu("Menu Manutentore", MENUMANUT);
		MyMenu fruitore=new MyMenu("Menu Fruitore", MENUFRUIT);
		MyMenu scelta=new MyMenu("Scegliere la modalità di accesso", MENUSCELTA);
		
		ImpiantoDomotico impianto = new ImpiantoDomotico();
		UnitaImmobiliare unita = null;
		CategoriaSensore memSens= null;
		CategoriaAttuatore memAtt = null;
		
		
		leggiFile(impianto);
		
		PrintWriter b=new PrintWriter(new FileWriter(FILECATEGORIE, true));
		
		int sceltaInt;
		do {
			sceltaInt=scelta.scegli();
			System.out.println("");
			
			switch(sceltaInt) {
				case 0: 
					System.out.println("\nFINE.");
					break;
				case 1:
					int sceltaManu;
					
					do {
						sceltaManu=manutentore.scegli();
						
						switch(sceltaManu) {
							case 0:  //esci dal menu del Manutentore
								System.out.println("\nTORNO AL MENU' PRINCIPALE");
								break;
								
							case 1: //aggiungo categoria di sensori
								memSens=impianto.aggiungiCategoriaSensori(InputDati.leggiStringaNonVuota(NEWCATEGORY), 
																		InputDati.leggiStringaNonVuota(DESCRIZIONE));
								if(memSens!=null)  {
									b.write(memSens.toString());
									b.flush();
								}
								
								break;
								
							case 2: //aggiungo categoria di attuatori
								memAtt= impianto.aggiungiCategoriaAttuatori(InputDati.leggiStringaNonVuota(NEWCATEGORY), 
																		InputDati.leggiStringaNonVuota(DESCRIZIONE));
								
								if(memAtt!=null) {
									b.write(memAtt.toString());
									b.flush();
								}
								
								break;
								
							case 3:  //aggiungo unita immobiliare
								unita = impianto.aggiungiUnitaImmobiliare(InputDati.leggiStringaNonVuota(NEWCATEGORY), 
																	InputDati.leggiStringaNonVuota(DESCRIZIONE));
								break;
								
							case 4:  //aggiungo nuovo sensore (se ho già creato unità immobiliare)
								if(unita!=null)
								unita.nuovoSensore(InputDati.leggiStringaNonVuota(NEWCATEGORY+"(nuovo sensore) "), 
										InputDati.leggiStringaNonVuota("Inserisci la categoria del sensore: "),
											impianto);
								else System.out.println("\nDevi prima creare un impianto.");
								break;
								
							case 5:   //aggiungo nuovo attuatore (se ho già creato unità immobiliare)
								//devo aver dato l'OK da parte del fruitore però..
								if(unita!=null)
								unita.nuovoAttuatore(InputDati.leggiStringaNonVuota(NEWCATEGORY+" (nuovo attuatore)"), 
															InputDati.leggiStringaNonVuota("Inserisci la categoria dell'attuatore: "), impianto);
								else System.out.println("\nDevi prima creare un impianto.");
								break;
								
							case 6:
								if(unita!=null)
									unita.aggiungiStanza(InputDati.leggiStringaNonVuota("Inserisci il nome della stanza: "));
								else System.out.println("Devi prima aver inserito una unità immobiliare.");
								break;
								
							case 7:
								if(unita!=null)
									unita.nuovoArtefatto(InputDati.leggiStringaNonVuota("Inserisci nuovo artefatto: "));
								else System.out.println("Devi prima aver inserito una unità immobiliare.");
								break;
								
							case 8: //associa sensori
								if(!unita.getSensori().isEmpty()) {
									int associa1=InputDati.leggiIntero("Scegli a cosa associare i sensori:\n1-Stanze\n2-Artefatti\n", 1, 2);
									
									switch(associa1) {
										case 1: 
											associaAStanze(unita, sceltaManu);
											break;
										case 2:
											associaAArtefatti(unita, sceltaManu);
											break;
									}
								}
								else System.out.println("Non sono ancora presenti sensori registrati.");
								break;
									
							case 9:
								if(!unita.getAttuatori().isEmpty()) {
									int associa1=InputDati.leggiIntero("Scegli a cosa associare gli attuatori:\n1-Stanze\n2-Artefatti\n", 1, 2);
									
									switch(associa1) {
										case 1: 
											associaAStanze(unita, sceltaManu);
											break;
										case 2:
											associaAArtefatti(unita, sceltaManu);
											break;
									}
								}
								else System.out.println("Non sono ancora presenti attuatori registrati.");
								break;
								
							case 10:
									impianto.visualizzaElencoCategorieSensori();
									break;
							case 11: 
									impianto.visualizzaElencoCategorieAttuatori();
									break;
							case 12:
									impianto.visualizzaElencoUnitaImmobiliari();
									break;
							case 13: 
								descrizioneUnita(unita);
								break;
							default: 
								System.out.println("\nScelta non disponibile.");
							}
						
						}while(sceltaManu!=0);
					
					break;
					
				case 2:
					int sceltaFruit;
					
					do {
						sceltaFruit=fruitore.scegli();
						
						switch(sceltaFruit) {
						case 0:  //esci dal menu del Manutentore
							System.out.println("\nTORNO AL MENU' PRINCIPALE");
							break;
						case 1:
							impianto.visualizzaElencoCategorieSensori();
							break;
						case 2:
							impianto.visualizzaElencoCategorieAttuatori();
							break;
						case 3:
							descrizioneUnita(unita);
							break;
						case 4:
							visualizzaValoriSensori(unita);
							break;
						default: 
							System.out.println("\nScelta non disponibile.");
						}
					}while(sceltaFruit!=0);
					
					break;
					
				default: 
					System.out.println("\nScelta non disponibile.");
			}
			
		} while(sceltaInt!=0);
		
		b.close();
	}
	
	
	
public static void visualizzaValoriSensori(UnitaImmobiliare unita) {
	/*int caso=InputDati.leggiIntero("1-Rilevazioni da sensori associati ad una stanza\n2-Rilevazioni da sensori associati ad un artefatto\n-> ", 1, 2);
	String nomeS=" ";
	
	if(caso==1) {
		nomeS=InputDati.leggiStringaNonVuota("Inserisci la stanza che ti interessa: "); 
		for(int i=0; i<unita.getStanze().size(); i++)
			if(unita.getStanze().get(i).getNome().equals(nomeS)) flag2=true;
	}
	else if(caso==2){
		nomeS=InputDati.leggiStringaNonVuota("Inserisci l'artefatto che ti interessa: "); 
		for(int i=0; i<unita.getArtefatti().size(); i++)
			if(unita.getArtefatti().get(i).getNome().equals(nomeS)) flag2=true;*/
	if(!unita.getSensori().isEmpty()) {
		String sensor=InputDati.leggiStringaNonVuota("Inserisci il nome del sensore di cui vuoi sapere il valore rilevato");
		
		for(int i=0; i<unita.getSensori().size(); i++) {
			if(unita.getSensori().get(i).getNome().equals(sensor)) {
				Sensore temp2=unita.getSensori().get(i);
				
				for(int j=0; j<unita.getStanze().size(); j++) {
					
					if(unita.getStanze().get(j).getSensori().contains(unita.getSensori().get(i))) {
						Stanza temp1=unita.getStanze().get(j);
						
						System.out.println("Il sensore inserito nella stanza "+temp1.getNome()+" ha rilevato il seguente valore: ");
						System.out.println(temp2.getCategoria().aggiungiRilevazione(temp1.getNome()+"-"+temp2.getNome(), 0, 20).valoreRilevato()); //VERIFICARE QUESTIONE MIN MAX
					}
				}
				
				for(int j=0; j<unita.getArtefatti().size(); j++) {
					if(unita.getArtefatti().get(j).getSensoriCollegati().contains(unita.getSensori().get(i))) {
						Stanza temp1=unita.getStanze().get(j);
						
						System.out.println("Il sensore inserito nella stanza "+temp1.getNome()+" ha rilevato il seguente valore: ");
						System.out.println(temp2.getCategoria().aggiungiRilevazione(temp1.getNome()+"-"+temp2.getNome(), 0, 20).valoreRilevato()); //VERIFICARE QUESTIONE MIN MAX
					}
				}
			}
		}
	}
	else System.out.println("Non sono presenti sensori.");
}
		
	public static void leggiFile(ImpiantoDomotico impianto) throws IOException { 
		System.out.println("Cerco file categorie "+FILECATEGORIE+" ...");
		File f=new File(FILECATEGORIE);
		
		if ( !f.exists() ) { 
			System.out.println(FILECATEGORIE+" non esiste.");
			f.createNewFile();
			System.out.println("Il file " + FILECATEGORIE + " è stato creato");
			return;
		}
		else
		System.out.println("File trovato! Carico le categorie.");
		
		FileReader r=new FileReader(FILECATEGORIE);
		BufferedReader re = new BufferedReader(r);
		String linea, categoria=" ", descrizione;
		boolean flag = false;
		try {
			do {
				linea = re.readLine();
				if(linea!=null) {
					if(linea.contains("Categoria di sensori: ")){
						categoria=linea.substring(22);
						flag=true;
					}
					
					if(linea.contains("Descrizione: ") && flag) {
						descrizione=linea.substring(13);
						if(!categoria.equals(" ")) impianto.aggiungiCategoriaSensori(categoria, descrizione);
					}
					
					if(linea.contains("Categoria di attuatori: ")){
						categoria=linea.substring(24);
						flag=false;
					}
					
					if(linea.contains("Descrizione: ") && !flag) {
						descrizione=linea.substring(13);
						if(!categoria.equals(" ")) impianto.aggiungiCategoriaAttuatori(categoria, descrizione);
					}
				}
			}while (linea != null);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		r.close();
		
		}

	public static void associaAStanze(UnitaImmobiliare unita, int caso) {
		boolean flag=false, flag2=false;
		String nomeS=" ";
		
		if(caso==8) {
			nomeS=InputDati.leggiStringaNonVuota("Inserisci il sensore che vuoi associare: "); 
			for(int i=0; i<unita.getSensori().size(); i++)
				if(unita.getSensori().get(i).getNome().equals(nomeS)) flag2=true;
		}
		else if(caso==9){
			nomeS=InputDati.leggiStringaNonVuota("Inserisci l'attuatore che vuoi associare: "); 
			for(int i=0; i<unita.getAttuatori().size(); i++)
				if(unita.getAttuatori().get(i).getNome().equals(nomeS)) flag2=true;
		}
		
			
		if(flag2) {
			String stanzaS;
			int ciclo=1;
			do{
				Stanza trovata=null;
				stanzaS=InputDati.leggiStringaNonVuota("Inserisci la stanza a cui associare: ");
				for(int j=0; j<unita.getStanze().size(); j++)
						if(unita.getStanze().get(j).getNome().equals(stanzaS)) {
							flag=true;
							trovata=unita.getStanze().get(j);
						}
				
				if(flag && caso==8) trovata.aggiungiSensore(nomeS, unita);
				else if(flag && caso==9)	trovata.aggiungiAttuatore(nomeS, unita);
				else System.out.println("Non sono presenti stanze con questo nome.");
				
				ciclo=InputDati.leggiIntero("Se vuoi associare un'altra stanza premi 1, altrimenti 0: ");
				
			}while(ciclo==1);
		}
		else if(caso==8 && !flag2) System.out.println("Il sensore inserito non è ancora stato aggiunto.");
		else System.out.println("L'attuatore inserito non è ancora stato aggiunto.");
	}
	
	
	
	public static void associaAArtefatti(UnitaImmobiliare unita, int caso) {
		boolean flag=false, flag2=false;
		String nomeS=" ";
		
		if(caso==8) {
			nomeS=InputDati.leggiStringaNonVuota("Inserisci il sensore che vuoi associare: "); 
			for(int i=0; i<unita.getSensori().size(); i++)
				if(unita.getSensori().get(i).getNome().equals(nomeS)) flag2=true;
		}
		else if(caso==9){
			nomeS=InputDati.leggiStringaNonVuota("Inserisci l'attuatore che vuoi associare: "); 
			for(int i=0; i<unita.getAttuatori().size(); i++)
				if(unita.getAttuatori().get(i).getNome().equals(nomeS)) flag2=true;
		}
			
		if(flag2) {
			String stanzaS;
			int ciclo=1;
			do{
				Artefatto trovata=null;
				stanzaS=InputDati.leggiStringaNonVuota("Inserisci la stanza a cui associare: ");
				for(int j=0; j<unita.getArtefatti().size(); j++)
						if(unita.getArtefatti().get(j).getNome().equals(stanzaS)) {
							flag=true;
							trovata=unita.getArtefatti().get(j);
						}
				
				if(flag && caso==8) trovata.collegaSensore(nomeS, unita);
				else if(flag && caso==9) trovata.collegaAttuatore(nomeS, unita);
				else System.out.println("Non sono presenti artefatti con questo nome.");
				
				ciclo=InputDati.leggiIntero("Se vuoi associare un altro artefatto premi 1, altrimenti 0: ");
			}while(ciclo==1);
		}
		else if(caso==8 && !flag2) System.out.println("Il sensore inserito non è ancora stato aggiunto.");
		else System.out.println("L'attuatore inserito non è ancora stato aggiunto");
		
	}
	
	public static void descrizioneUnita(UnitaImmobiliare unita) {
		if(unita!=null) {
			System.out.println(unita.toString()+"\n");
			unita.visualizzaAssociazioni();
			System.out.println("Elenco Sensori registrati: ");
			unita.stampaSensori();
			System.out.println("Elenco Attuatori registrati: ");
			unita.stampaAttuatori();
		}
		else System.out.println("Unità non ancora presente.");
	}
}
