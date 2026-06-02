package inimigos;

import personagem.Personagem;

public class Inimigo {
	public String nome;
	public int vida;
	public int dano;
	
	public Inimigo(String nome, int vida, int dano) {
		this.nome = nome;
		this.vida = vida;
		this.dano = dano;
	}
	
	public void atacar(Personagem jogador) {
		jogador.vida -= dano;
	}
}
