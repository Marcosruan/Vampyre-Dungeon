package personagem;

public class Ladino extends Personagem {

	public final int vida = 45;
	public final int dano = 10;
	boolean escondido = false;
	
	
	public Ladino(String nome) {
		super(nome, vida, dano);
	}
	
	public void seEsconder() {
		escondido = true;
		dano += 10;
	}
	
	
}
