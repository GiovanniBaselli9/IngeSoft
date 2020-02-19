
public class Rilevazione {
	private String nome, unitaDiMisura;
	private int min, max;
	
	public Rilevazione(String nome, String unitaDiMisura, int min, int max){
		this.nome=nome;
		this.unitaDiMisura=unitaDiMisura;
		this.min=min;
		this.max=max;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String valoreRilevato() {
		return (Math.random()*(max-min)+min)+" "+unitaDiMisura;
	}
}
