package personagem;

import inimigos.Inimigo;

public class Mago extends Personagem {
	
	static final int VIDABASE = 40;
	static final int DANOBASE = 15;
	
	public Mago(String nome) {
		super(nome, VIDABASE, DANOBASE,VIDABASE);
	}
	
	@Override
	public void especial(Inimigo inimigo) {
		super.especial(inimigo);
		inimigo.vida -= inimigo.dano;
	}
}
