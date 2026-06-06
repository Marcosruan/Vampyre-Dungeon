package aventura;
import personagem.*;

public class Historia {
	public static void introducaoHistoria() {
		System.out.println("Em uma noite escura, criaturas distorcidas observam, pelas frestas da masmorra, um ser acordando no meio da vegetação rasteira. Este ser retoma sua consciência, entretanto, ele perdeu completamente suas memórias do passado e seu senso de identidade. Ele está confuso e observa relutantemente seus arredores. Não reconhece estas paredes de concreto, mas entende seu propósito aqui. Um conhecimento resguardado no seu subconsciente. Ele precisa derrotar o vampiro que controla esta masmorra!");
	}
	
	public static void selecaoPersonagem() {
		System.out.print("""
				Ele olha para baixo e vê seu corpo, o corpo de um: 
				1 - Guerreiro
				2 - Mago
				3 - Ladino
				Qual sua escolha: 
				""");
	}
	
	public static void finalHistoria(Personagem heroi) {
		if(heroi.estaVivo()) {
			System.out.println("Heroi finaliza masmorra");
		} else {
			System.out.println("Masmorra colapsa e sem inguém para impedir seu avanço o mundo se corrompe.");
		}
	}

	public static String introducaoFaseI() {
		return null;
	}
	public static String introducaoFaseII() {
		return null;
	}
	public static String introducaoFaseII_I() {
		return null;
	}
	public static String introducaoFaseII_II() {
		return null;
	}
	public static String introducaoFaseII_III() {
		return null;
	}
	public static String introducaoFaseIII() {
		return "O que é, o que é? Tem mais ou menos um palmo, tem um buraco na ponta e um pouco de cabelo no pé, quem tem usa, quem não tem usa o dedo.\nResposta: ";

	}
	public static String introducaoFaseIV() {
		return null;
	}
	public static String introducaoFaseV() {
		return null;
	}

}	
