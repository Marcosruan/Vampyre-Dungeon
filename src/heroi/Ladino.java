package heroi;

import inimigos.Inimigo;

public class Ladino extends Heroi {

	static final int VIDABASE = 75;
	static final int DANOBASE = 15;
	boolean escondido = false;
	
	
	public Ladino(String nome) {
		super(nome, VIDABASE, DANOBASE,VIDABASE);
	}
	
	@Override
	public void atacar(Inimigo inimigo){
		super.incrementarContadorEspecial();
		if (escondido) {
			escondido = false;
			inimigo.vida -= dano * 2;
		} else {
			inimigo.vida -= dano;
		}
	}
	
	@Override
	public void especial(Inimigo inimigo) {
		inimigo.resetarContador();
		escondido = true;
		inimigo.vida -= dano;
		resetarContador();
	}
}
