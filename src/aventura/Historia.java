package aventura;
import heroi.*;

public class Historia {
	
	public static void introducaoHistoria() {
		System.out.println("""	
				Em uma noite escura, criaturas distorcidas observam, pelas frestas da masmorra, 
				um ser acordando no meio da vegetação rasteira. Este ser retoma sua consciência, 
				entretanto, ele perdeu completamente suas memórias do passado e seu senso de identidade. 
				Ele está confuso e observa relutantemente seus arredores. Não reconhece estas paredes de concreto,
				mas entende seu propósito aqui. Um conhecimento resguardado no seu subconsciente. 
				Ele precisa derrotar o vampiro que controla esta masmorra!""");
	}
	
	public static void selecaoPersonagem() {
		System.out.print("""
				\nEle olha para baixo e vê seu corpo, o corpo de um: 
				1 - Guerreiro
				2 - Mago
				3 - Ladino
				Qual sua escolha: 
				""");
	}
	
	public static void finalHistoria(Heroi heroi) {
		int tamanhoLinha = 140;
		String textoFinalizacao;
		System.out.println("=".repeat(tamanhoLinha));
		if(heroi.estaVivo()) {
			textoFinalizacao = "🏆 VITÓRIA!";
			int quantidadeEspacos = (tamanhoLinha - textoFinalizacao.length())/2;
			System.out.println("Heroi finaliza masmorra.");
			System.out.println(" ".repeat(quantidadeEspacos)+textoFinalizacao);
		} else {
			textoFinalizacao = "🪦 GAME OVER";
			int quantidadeEspacos = (tamanhoLinha - textoFinalizacao.length())/2;
			System.out.println("Masmorra colapsa e sem ninguém para impedir seu avanço o mundo se corrompe.");
			System.out.println(" ".repeat(quantidadeEspacos)+textoFinalizacao);
		}
		System.out.println("=".repeat(tamanhoLinha));
	}

	public static String introducaoFaseI() {
		return """
				\nO herói ultrapassa a entrada da masmorra e adentra a escuridão do local. 
				Após entrar na sala, no meio das trevas, revela-se a figura de um esqueleto pronto para atacá-lo.
				""";
	}
	
	public static String introducaoFaseII_A() {
		return """
				\nAo seguir pelo caminho à esquerda, o desbravador da masmorra se depara 
				com mais um desafio: um novo esqueleto, desta vez com uma aparência fortificada 
				e muito mais ameaçadora.
				""";
	}
	public static String introducaoFaseII_B() {
		return """				
				\nAo seguir pelo caminho à direita, o desbravador da masmorra 
				encontra mais um desafio. Em meio à escuridão da sala, revela-se 
				a figura de um zumbi em decomposição, que avança lentamente 
				em sua direção, pronto para atacá-lo.
				""";
	}
	
	public static String introducaoFaseIII() {
		return """
				\nParabéns herói, você conseguiu uma recompensa por ter derrotado o monstro. Escolha sabiamente uma opção:
				1 - Regenerar vida
				2 - Aumentar dano
				3 - Incrementar energia
				Faça a sua escolha:
				""";
	}
	public static String introducaoFaseIV() {
		return """
				\nAo atravessar os grandes portões da última sala, o herói finalmente 
				encontra o maior desafio da masmorra. Em meio às sombras, 
				surge um vampiro de olhar ameaçador e presença imponente. Seu poder é claramente 
				superior ao dos inimigos enfrentados anteriormente. Chegou a hora da batalha final.
				""";
	}
	
	public static String introducaoCaminhos() {
		return "\nO herói se depara com 3 caminhos distintos: \n1 - Ir pela esquerda \n2 - Ir pela direita \n3 - Seguir em frente.";
	}
	
	public static String introducaoEnigma() {
		return """				
				\nAo atravessar a porta, o herói se depara com uma sala misteriosa 
				que contém um altar com uma mensagem escrita sobre ele. A mensagem diz: 
				""";
	}
}