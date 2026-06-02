package inimigos;

import personagem.Personagem;

public class Vampiro extends Inimigo {
	
	static final int VIDABASE = 100;
	static final int DANOBASE = 40;
	static final String TITULO = "Mestre Vampiro";
	
	public Vampiro() {
		super(TITULO, VIDABASE, DANOBASE);
	}
	
	public void drenarVida(Personagem jogador) {
		int vidaOriginalDoJogador = jogador.vida;
		jogador.vida -= 20;
		
		if(vidaOriginalDoJogador > jogador.vida) {
			vida += 20;
		}
	}
}
