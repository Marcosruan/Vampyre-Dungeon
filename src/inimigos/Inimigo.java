package inimigos;

import personagem.Personagem;

public class Inimigo {
	public String nome;
	public int vida;
	public int dano;
	
	public void atacar(Personagem jogador) {
		jogador.vida -= dano;
	}
}
