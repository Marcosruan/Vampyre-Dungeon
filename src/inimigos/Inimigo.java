package inimigos;

import personagem.Personagem;

public class Inimigo {
	public String nome;
	public int vida;
	public int dano;
	public int contadorEspecial;

	
	public Inimigo(String nome, int vida, int dano) {
		this.nome = nome;
		this.vida = vida;
		this.dano = dano;
		this.contadorEspecial = 0;
	}
	
	public void atacar(Personagem jogador) {
		jogador.vida -= dano;
	}

	public boolean estaVivo() {
		return vida > 0;
	}
	
	public void especial(Personagem jogador) {
		resetarContador();
	}
	
	public void incrementarContadorEspecial() {
		if(contadorEspecial < 2) {
			contadorEspecial++;
		}
	}
	public boolean analisarAtivarcaoEspecial() {
		if(contadorEspecial < 2) {
			return false;
		}
		return true;
	}
	public void resetarContador() {
		contadorEspecial = 0;
	}
}
