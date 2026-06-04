package personagem;
import inimigos.*;

public class Guerreiro extends Personagem{
	static final int VIDABASE = 60;
	static final int DANOBASE = 10;

	public Guerreiro(String nome) {
		super(nome, VIDABASE, DANOBASE,VIDABASE);
	}
	@Override
	public void especial(Inimigo inimigo) {
		super.especial(inimigo);
		dano+= (int) inimigo.dano/2;
	}
}
