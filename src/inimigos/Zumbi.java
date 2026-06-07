package inimigos;

public class Zumbi extends Inimigo{
	public final static int VIDABASE = 55;
	public final static int DANOBASE = 15;

	public Zumbi(String nome) {
		super(nome, VIDABASE, DANOBASE);
	}
	
	@Override
	public String efeitoAtaque() {
		return "O inimigo usou o ataque Mordida Voraz!";
	}
}
