package personagem;

import inimigos.Inimigo;

public class Personagem {
	public String nome;
	public int vida;
	public int dano;
	
	public Personagem(String nome, int vida, int dano) {
		this.nome = nome;
		this.dano = dano;
		this.vida = vida;
	}
	
	public void atacar(Inimigo inimigo) {
		inimigo.vida -= dano;
	}
	
	public void especial(Inimigo inimigo) {
		
	}
	public boolean estaVivo() {
		return this.vida > 0;
	}
}
