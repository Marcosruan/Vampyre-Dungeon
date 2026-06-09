package util;

import heroi.Heroi;
import inimigos.Inimigo;

public class ExibeBarras {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_CYAN = "\u001B[36m";
	
	public static void exibeBarraVida(Heroi heroi, int vidaHeroiMaxima, Inimigo inimigo, int vidaInimigoMaxima) {
		String barraVidaHeroi = geraBarraVida(heroi.vida, vidaHeroiMaxima, false);
		String barraVidaVilao = geraBarraVida(inimigo.vida, vidaInimigoMaxima, true);
		
		String nomeHeroiComCor = ANSI_BLUE + heroi.nome + ANSI_RESET;
		String nomeVilaoComCor = ANSI_RED + inimigo.nome + ANSI_RESET;
		System.out.println("-".repeat(140));
		System.out.printf("%s => %s%30s%s <= %s\n", nomeHeroiComCor, barraVidaHeroi, " ", barraVidaVilao, nomeVilaoComCor);
	}
	
	public static void exibeEnergia(int contador) {
		int quantMaxima = 2;
		String barras = "[ " + "▰".repeat(contador) + "▱".repeat(quantMaxima - contador) + " ] ";
		System.out.printf("%s%s%s\n", ANSI_CYAN, barras, ANSI_RESET);
		System.out.println("-".repeat(140));
	}
	
	private static String geraBarraVida(int vidaAtual, int vidaMaxima, boolean vilao) {
		final int quantTotalBarras = 20;
		
		int vidaChecada = Math.max(0, vidaAtual);
		double proporcao = (double) vidaChecada / vidaMaxima;
		int barrasCheias = (int) Math.round(proporcao * quantTotalBarras);
		int barrasVazias = quantTotalBarras - barrasCheias;
		
		String cor = corDoEstadoAtual(barrasCheias);
		
		if (vilao) {
			return cor + vidaChecada + "/" + vidaMaxima + " [ " + "░".repeat(barrasVazias) + "█".repeat(barrasCheias) + " ] HP" + ANSI_RESET;
		}
		
		return cor + "HP [ " + "█".repeat(barrasCheias) + "░".repeat(barrasVazias) + " ] " + vidaChecada + "/" + vidaMaxima + ANSI_RESET;
	}
	
	private static String corDoEstadoAtual(int quantidade) {
		if (quantidade < 6) {
			return ANSI_RED;
		} else if (quantidade < 12) {
			return ANSI_YELLOW;
		}
		return ANSI_GREEN;
	}
}
