package inimigos;

public class Esqueleto extends Inimigo{
	public final static int VIDABASE = 60;
	public final static int DANOBASE = 5;
	public final static int VIDAAUMENTADA = 45;
	public final static int DANOAUMENTADA = 10;
	
	public Esqueleto(String nome) {
		super(nome, VIDABASE, DANOBASE);
	}
	
	public Esqueleto() {
		super("Esqueleto de Elite", VIDAAUMENTADA, DANOAUMENTADA);
	}
	
	@Override
	public String efeitoAtaque() {
		return "O inimigo usou o ataque Aremesso de Osso!";
	}
}
