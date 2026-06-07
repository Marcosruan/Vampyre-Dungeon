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
	
	@Override
	public String efeitoAtaque() {
		return "\nO herói usou o ataque Energia Arcana!";
	}
	
	@Override
	public String efeitoEspecial() {
		return "\nO herói usou o especial Convergência e refletiu o dano do seu inimigo!";
	}
	
	@Override
	public String toString() {
		return "Vida: " + VIDABASE + " | Dano de Ataque: " + DANOBASE + " | Especial: Reflete o dano do inimigo.";
	}
}
