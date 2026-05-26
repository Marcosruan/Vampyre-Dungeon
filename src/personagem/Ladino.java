package personagem;

import inimigos.Inimigo;

public class Ladino extends Personagem {

	public final static int VIDABASE = 45;
	public final static int DANOBASE = 10;
	boolean escondido = false;
	
	
	public Ladino(String nome) {
		super(nome, VIDABASE, DANOBASE);
	}
	
	public void seEsconder() {
		escondido = true;
	}
	
	@Override
	public void atacar(Inimigo inimigo){
		if (escondido) {
			inimigo.vida -= (dano + 10);
			escondido = false;
		} else {
			inimigo.vida -= dano;			
		}
	}
}
