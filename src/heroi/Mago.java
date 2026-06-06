package heroi;

import inimigos.Inimigo;

public class Mago extends Heroi {
	
	static final int VIDABASE = 60;
	static final int DANOBASE = 20;
	
	public Mago(String nome) {
		super(nome, VIDABASE, DANOBASE,VIDABASE);
	}
	
	@Override
	public void especial(Inimigo inimigo) {
		inimigo.vida -= inimigo.dano;
		vida += inimigo.dano;
		resetarContador();
	}
}
