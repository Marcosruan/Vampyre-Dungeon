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
}
