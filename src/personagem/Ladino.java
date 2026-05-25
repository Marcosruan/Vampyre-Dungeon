package personagem;

import inimigos.Inimigo;

public class Ladino extends Personagem {

	static final int vidaLadino = 45;
	static final int danoLadino = 10;
	boolean escondido = false;
	
	
	public Ladino(String nome) {
		super(nome, vidaLadino, danoLadino);
	}
	
	public void seEsconder() {
		escondido = true;
		dano += 10;
	}
	
	@Override
	public void atacar(Inimigo inimigo){
		inimigo.vida -= dano;
		if (escondido) {
			escondido = false;
			dano -= 10;
		} 
	}
	
	@Override
	public void especial(Inimigo inimigo) {
		inimigo.vida -= dano*2;
		if (escondido) {
			escondido = false;
			dano -= 10;
		} 
	}
}
