import batalha.*;
import inimigos.*;
import personagem.*;

public class Main {
	public static void main(String[] args) {
		Esqueleto e = new Esqueleto("laud");
		Ladino ladino = new Ladino("Jonnas");
		e.atacar(ladino);
		
		System.out.println("Vida: " + ladino.vida + "\nDano: " + ladino.dano);
	}
}
