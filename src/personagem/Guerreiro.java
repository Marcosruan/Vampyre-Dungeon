package personagem;

public class Guerreiro extends Personagem{
	static final int VIDABASE = 60;
	static final int DANOBASE = 5;

	public Guerreiro(String nome) {
		super(nome, VIDABASE, DANOBASE);
	}

}
