package util;

import heroi.Heroi;
import inimigos.Inimigo;

public class ExibeBarras {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static void exibeBarraVida(Heroi heroi, int vidaHeroiMaxima, Inimigo inimigo, int vidaInimigoMaxima) {
		String barraVidaHeroi = geraBarraVida(heroi.vida, vidaHeroiMaxima, false);
		String barraVidaVilao = geraBarraVida(inimigo.vida, vidaInimigoMaxima, true);
		
		String nomeHeroiComCor = ANSI_CYAN + heroi.nome + ANSI_RESET;
		String nomeVilaoComCor = ANSI_RED + inimigo.nome + ANSI_RESET;
		
		System.out.printf("%s => %s%40s%s <= %s\n", nomeHeroiComCor, barraVidaHeroi, " ", barraVidaVilao, nomeVilaoComCor);
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
