package aventura;
import heroi.*;
import inimigos.*;

public class Batalha {

    public static void iniciaBatalha(Heroi heroi, Inimigo inimigo, int opcaoEscolhida) {

        switch (opcaoEscolhida) {
            case 1:
            	System.out.println(heroi.ataqueLog());
                heroi.atacar(inimigo);
                break;
            case 2:
            	System.out.println(heroi.especialLog());
                heroi.especial(inimigo);
                break;
        }

        if (inimigo.estaVivo() && heroi.estaVivo()) {
        	if(inimigo.energiaSuficiente()) {
        		System.out.println(inimigo.especialLog());
        		inimigo.especial(heroi);
        	} else {
        		System.out.println(inimigo.ataqueLog());
    			inimigo.atacar(heroi);
        	}
    	}
    }
}
