package personagem;

import inimigos.Inimigo;

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
	
	@Override
	public void atacar(Inimigo inimigo){
		if (escondido) {
			inimigo.vida -= dano + 10;
			escondido = false;
		} else {
			inimigo.vida -= dano;			
		}
	}
	
	@Override
	public void especial(Inimigo inimigo) {
		if(escondido) {
			inimigo.vida -= (dano + 10)*2;
		} else {
			inimigo.vida -= dano*2;
		}
	}
}
