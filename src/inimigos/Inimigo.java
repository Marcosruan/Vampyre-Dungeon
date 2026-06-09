package inimigos;

import heroi.Heroi;

public class Inimigo {
	public String nome;
	public int vida;
	public int dano;
	public int energia;

	
	public Inimigo(String nome, int vida, int dano) {
		this.nome = nome;
		this.vida = vida;
		this.dano = dano;
		this.energia = 0;
	}
	
	public void atacar(Heroi jogador) {
		jogador.vida -= dano;
	}

	public boolean estaVivo() {
		return vida > 0;
	}
	
	public void especial(Heroi heroi) {
		
	}
	
	public void incrementarEnergia() {
		if(energia < 2) {
			energia++;
		}
	}
	public boolean energiaSuficiente() {
		if(energia < 2) {
			return false;
		}
		return true;
	}
	public void resetarContador() {
		energia = 0;
	}
	
	public String ataqueLog() {
		return "";
	}
	
	public String especialLog() {
		return "";
	}
	
}
