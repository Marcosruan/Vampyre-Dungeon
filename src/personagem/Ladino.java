package personagem;

public class Ladino extends Personagem {

	public static final int vidaLadino = 45;
	public static final int danoLadino = 10;
	boolean escondido = false;
	
	
	public Ladino(String nome) {
		super(nome, vidaLadino, danoLadino);
	}
	
	public void seEsconder() {
		escondido = true;
		dano += 10;
	}
	
	
}
