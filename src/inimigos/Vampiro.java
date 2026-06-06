package inimigos;

import personagem.Personagem;

public class Vampiro extends Inimigo {
	
	static final int VIDABASE = 70;
	static final int DANOBASE = 30;
	static final String TITULO = "Mestre Vampiro";
	
	public Vampiro() {
		super(TITULO, VIDABASE, DANOBASE);
	}
	@Override
	public void atacar(Personagem jogador) {
		super.atacar(jogador);
		incrementarContadorEspecial();
	}
	@Override
	public void especial(Personagem jogador) {
		super.especial(jogador);
		int vidaOriginalDoJogador = jogador.vida;
		jogador.vida -= 20;
		
		if(vidaOriginalDoJogador > jogador.vida) {
			vida += 20;
		}
	}
}
