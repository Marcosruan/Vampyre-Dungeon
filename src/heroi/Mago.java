package heroi;

import inimigos.Inimigo;

public class Mago extends Heroi {
	
	static final int VIDABASE = 40;
	static final int DANOBASE = 15;
	
	public Mago(String nome) {
		super(nome, VIDABASE, DANOBASE,VIDABASE);
	}
	
	@Override
	public void especial(Inimigo inimigo) {
		inimigo.vida -= inimigo.dano;
		resetarContador();
	}
}
