package inimigos;

public class Esqueleto extends Inimigo{
	public final static int VIDABASE = 50;
	public final static int DANOBASE = 5;
	
	public Esqueleto(String nome) {
		super(nome,VIDABASE,DANOBASE);
	}
}
