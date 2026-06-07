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
		escondido = true;
		inimigo.vida -= dano;
		resetarContador();
	}
	
	@Override
	public String efeitoAtaque() {
		if(escondido) {
			return "\nO herói está camuflado e usou o ataque Corte Preciso, deferindo um ataque em dobro!";
		} else {
			return "\nO herói usou o ataque Relâmpago!";
		}
	}
	
	@Override
	public String efeitoEspecial() {
		return "\nO herói usou o especial Furtividade e causou dano ao seu inimigo!";
	}
	
	@Override
	public String toString() {
		return "Classe: Ladino 🥷 | ❤️ Vida: " + VIDABASE + " | ⚔️ Dano de Ataque: " + DANOBASE + " | ✨ Especial: Ativa o modo furtivo e dá o dobro de dano no próximo ataque.";
	}
}
