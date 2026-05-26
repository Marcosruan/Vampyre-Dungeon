package personagem;

import inimigos.Inimigo;

public class Mago extends Personagem {
	
	static final int VIDABASE = 30;
	static final int DANOBASE = 15;
	
	public Mago(String nome) {
		super(nome, VIDABASE, DANOBASE);
	}
	
	public void reduzirDanoInimigo(Inimigo inimigo) {
		inimigo.dano -= 10;
	}
}
