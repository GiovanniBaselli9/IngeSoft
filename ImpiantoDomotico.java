import java.util.ArrayList;

public class ImpiantoDomotico {

	private ArrayList<UnitaImmobiliare> unitaImmobiliari;
	private ArrayList<CategoriaSensore> categorieSensori;
	private ArrayList<CategoriaAttuatore> categorieAttuatori;
	
	//SCRIVERE COSTRUTTORE
	ImpiantoDomotico(){
		this.unitaImmobiliari=new ArrayList<UnitaImmobiliare>();
		this.categorieSensori=new ArrayList<CategoriaSensore>();
		this.categorieAttuatori=new ArrayList<CategoriaAttuatore>();
	}
	
	public UnitaImmobiliare aggiungiUnitaImmobiliare(String nome,String tipologia){
		UnitaImmobiliare unita = new UnitaImmobiliare(nome, tipologia);
		unitaImmobiliari.add(unita);
		return unita;
	}
	
	public void visualizzaElencoUnitaImmobiliari() {
		if(unitaImmobiliari.isEmpty())
			System.out.println("Non ho unità immobiliari registrate.");
		else unitaImmobiliari.forEach((unita)-> System.out.println(unita.toString()));		
	}
	
	public CategoriaSensore aggiungiCategoriaSensori(String nome, String descrizione){
		boolean f=false;
		
		if(!categorieSensori.isEmpty()) {
			for(int i=0; i<categorieSensori.size(); i++) {
				if(categorieSensori.get(i).getNome().equals(nome)) f=true;
			}
		}
		
		if(f) System.out.println("Categoria già presente.");
		else {
			CategoriaSensore nuova= new CategoriaSensore(nome, descrizione);
			categorieSensori.add(nuova);
			return nuova;
		}
		return null;
	}
	
	public void visualizzaElencoCategorieSensori() {
		if(categorieSensori.isEmpty())
			System.out.println("Non ho alcuna categoria di sensori registrata.");
		else categorieSensori.forEach((cat)-> System.out.println(cat.toString()));
	}
	
	public CategoriaAttuatore aggiungiCategoriaAttuatori(String nome, String descrizione) {
		boolean f=false;
		
		if(!categorieAttuatori.isEmpty()) {
			for(int i=0; i<categorieAttuatori.size(); i++) {
				if(categorieAttuatori.get(i).getNome().equals(nome)) f=true;
			}
		}
		
		if(f) System.out.println("Categoria già presente.");
		else {
			CategoriaAttuatore nuova=new CategoriaAttuatore(nome, descrizione);
			categorieAttuatori.add(nuova);
			return nuova;
		}
		return null;
	}
	
	public void visualizzaElencoCategorieAttuatori() {
		if(categorieAttuatori.isEmpty())
			System.out.println("Non ho alcuna categoria di attuatori registrata.");
		else categorieAttuatori.forEach((cat)-> System.out.println(cat.toString()));
	}
	
	/*
	public void modificaUnitaImmobiliare(UnitaImmobiliare unita){
		
	}
	*/
	
	public ArrayList<CategoriaSensore> getCategorieSensori() {
		return categorieSensori;
	}

	public void setCategorieSensori(ArrayList<CategoriaSensore> categorieSensori) {
		this.categorieSensori = categorieSensori;
	}

	public ArrayList<CategoriaAttuatore> getCategorieAttuatori() {
		return categorieAttuatori;
	}

	public void setCategorieAttuatori(ArrayList<CategoriaAttuatore> categorieAttuatori) {
		this.categorieAttuatori = categorieAttuatori;
	}

}
	
	
	

