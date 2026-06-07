package heroi;
import inimigos.*;

public class Guerreiro extends Heroi{
	static final int VIDABASE = 80;
	static final int DANOBASE = 10;

	public Guerreiro(String nome) {
		super(nome, VIDABASE, DANOBASE,VIDABASE);
	}
	@Override
	public void especial(Inimigo inimigo) {
		dano+= inimigo.dano/2 + 2;
		resetarContador();
	}
	
	@Override
	public String efeitoAtaque() {
		return "\nO herói usou o ataque Lâmina Flamejante!";
	}
	
	@Override
	public String efeitoEspecial() {
		return "\nO herói usou o especial Fortalecer e aumentou sua quantidade de ataque!";
	}
	
	@Override
	public String toString() {
		return "Classe: Guerreiro 🤺 | Vida: " + VIDABASE + " | ⚔️ Dano de Ataque: " + DANOBASE + " | ✨ Especial: fortalece o seu ataque usando como base a metade do dano do inimigo.";
	}
}
