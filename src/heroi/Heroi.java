package heroi;

import inimigos.Inimigo;

public class Heroi {
	public String nome;
	public int vida;
	public int dano;
	public int capacidadeMaxima;
	public int energia;
	
	public Heroi(String nome, int vida, int dano,int capacidadeMaxima) {
		this.nome = nome;
		this.dano = dano;
		this.vida = vida;
		this.capacidadeMaxima = capacidadeMaxima;
		this.energia = 0;
	}
	
	public void atacar(Inimigo inimigo) {
		inimigo.vida -= dano;
		incrementarEnergia();
	}
	
	public void especial(Inimigo inimigo) {
	}
	
	public boolean estaVivo() {
		return this.vida > 0;
	}
	public void regenerarVida() {
		vida = capacidadeMaxima; 
	}
	public void aumentarDanoDeAtaque() {
		dano += 15;
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
	public void resetarEnergia() {
		energia = 0;
	}	
	
	public String ataqueLog() {
		return "";
	}
	
	public String especialLog() {
		return "";
	}
}
