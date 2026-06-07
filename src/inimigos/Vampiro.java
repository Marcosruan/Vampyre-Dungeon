package inimigos;

import heroi.Heroi;

public class Vampiro extends Inimigo {
	
	static final int VIDABASE = 85;
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
		jogador.vida -= dano;
		vida += dano;
		resetarContador();
	}
	
	@Override
	public String efeitoAtaque() {
		return "O inimigo usou o ataque Rajada de Sangue!";
	}
	
	@Override
	public String efeitoEspecial() {
		return "O inimigo usou o especial Drenagem Vital, roubando a vida do jogador!";
	}
}
