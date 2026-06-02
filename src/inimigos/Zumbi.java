package inimigos;

public class Zumbi extends Inimigo{
	public final static int VIDABASE = 35;
	public final static int DANOBASE = 20;

	public Zumbi(String nome) {
		super(nome, VIDABASE, DANOBASE);
	}
	
}
