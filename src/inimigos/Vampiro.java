package inimigos;

import heroi.Heroi;

public class Vampiro extends Inimigo {
	
	static final int VIDABASE = 70;
	static final int DANOBASE = 20;
	static final String TITULO = "Mestre Vampiro";
	
	public Vampiro() {
		super(TITULO, VIDABASE, DANOBASE);
	}
	@Override
	public void atacar(Heroi jogador) {
		super.atacar(jogador);
		incrementarContadorEspecial();
	}
	
	public void especial(Heroi jogador) {
		int vidaOriginalDoJogador = jogador.vida;
		jogador.vida -= 20;
		
		if(vidaOriginalDoJogador > jogador.vida) {
			vida += 20;
		}
		resetarContador();
	}
}
