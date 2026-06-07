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
		if(heroi.estaVivo()) {
			System.out.println("Heroi finaliza masmorra");
		} else {
			System.out.println("Masmorra colapsa e sem ninguém para impedir seu avanço o mundo se corrompe.");
		}
	}

	public static String introducaoFaseI() {
		return null;
	}
	
	public static String introducaoFaseII_A() {
		return null;
	}
	public static String introducaoFaseII_B() {
		return null;
	}
	
	public static String introducaoFaseIII() {
		return """
				\nParabéns heroi vc conseguiu uma recompensa por ter derrotado o monstro. Escolha sabiamente uma opção:
				1 - Regenerar vida
				2 - Aumentar dano
				3 - Incrementar o acumulador do ataque especial
				Faça a sua escolha:
				""";
	}
	public static String introducaoFaseIV() {
		return null;
	}
}