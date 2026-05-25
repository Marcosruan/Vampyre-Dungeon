import personagem.Ladino;

public class Main {
	public static void main(String[] args) {
		Ladino ladino = new Ladino("Jonnas");

		System.out.println("Vida: " + ladino.vida + "\nDano: " + ladino.dano);
		ladino.seEsconder();
		System.out.println("Vida: " + ladino.vida + "\nDano: " + ladino.dano);
	}
}
