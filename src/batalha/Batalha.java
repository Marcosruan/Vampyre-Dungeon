package batalha;
import heroi.*;
import inimigos.*;

public class Batalha {

    public static void iniciaBatalha(Heroi heroi, Inimigo inimigo, int opcaoEscolhida) {

        switch (opcaoEscolhida) {
            case 1:
                heroi.atacar(inimigo);
                break;
            case 2:
                heroi.especial(inimigo);
                break;
        }

        if (inimigo.estaVivo() && heroi.estaVivo()) {
        	if(inimigo.analisarAtivarcaoEspecial()) {
        		inimigo.especial(heroi);
        	} else {
    			inimigo.atacar(heroi);
        	}
    	}
    }
}
