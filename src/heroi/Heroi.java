package heroi;

import inimigos.Inimigo;

public class Heroi {
	public String nome;
	public int vida;
	public int dano;
	public int capacidadeMaxima;
	public int contadorEspecial;
	
	public Heroi(String nome, int vida, int dano,int capacidadeMaxima) {
		this.nome = nome;
		this.dano = dano;
		this.vida = vida;
		this.capacidadeMaxima = capacidadeMaxima;
		this.contadorEspecial = 0;
	}
	
	public void atacar(Inimigo inimigo) {
		System.out.println(dano);
		inimigo.vida -= dano;
		incrementarContadorEspecial();
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
