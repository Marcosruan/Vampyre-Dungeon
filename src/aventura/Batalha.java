package aventura;
import heroi.*;
import inimigos.*;

public class Batalha {

    public static void iniciaBatalha(Heroi heroi, Inimigo inimigo, int opcaoEscolhida) {

        switch (opcaoEscolhida) {
            case 1:
            	System.out.println(heroi.efeitoAtaque());
                heroi.atacar(inimigo);
                break;
            case 2:
            	System.out.println(heroi.efeitoEspecial());
                heroi.especial(inimigo);
                break;
        }

        if (inimigo.estaVivo() && heroi.estaVivo()) {
        	if(inimigo.analisarAtivarAcaoEspecial()) {
        		System.out.println(inimigo.efeitoEspecial());
        		inimigo.especial(heroi);
        	} else {
        		System.out.println(inimigo.efeitoAtaque());
    			inimigo.atacar(heroi);
        	}
    	}
    }
}
