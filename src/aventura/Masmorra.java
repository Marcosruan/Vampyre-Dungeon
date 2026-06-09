package aventura;
import java.util.Random;

import inimigos.*;

public class Masmorra {
    public Fase[] fases;
    Fase faseAtual;
    boolean fim = false;
    public Enigma[] enigmas;
    
    public Masmorra() {
    	inicializarVetorDeEnigmas();
    	int indice = escolherEnigmaAleatorio();
    	
    	this.fases = new Fase[]{
    		new Fase("Fase 1", Historia.introducaoFaseI(), new Esqueleto("Esqueleto Guerreiro")),
    		new Fase("Fase II.1", Historia.introducaoFaseII_A(), new Esqueleto()),
    		new Fase("Fase II.2", Historia.introducaoFaseII_B(), new Zumbi("Zumbi")),
    		new Fase("Enigma", Historia.introducaoEnigma(), enigmas[indice]),
    		new Fase("NPC com Buffs", Historia.introducaoFaseIII()),
    		new Fase("Fase Boss", Historia.introducaoFaseIV(), new Vampiro())
    	};
    	fases[0].adicionarProximasFases(fases[1],fases[2],fases[3]);
    	fases[1].adicionarProximasFases(fases[4]);
    	fases[2].adicionarProximasFases(fases[4]);
    	fases[3].adicionarProximasFases(fases[5]);
    	fases[4].adicionarProximasFases(fases[5]);
		

    	faseAtual = fases[0];

    }
    

    int escolherEnigmaAleatorio() {
    	Random gerador = new Random();
		return gerador.nextInt(5);
	}


	void inicializarVetorDeEnigmas() {
		enigmas = new Enigma[5];
		
		enigmas[0] = new Enigma(
				"Eu falo, mas não tenho boca. Eu ouço, mas não tenho ouvidos. Não tenho corpo, mas vivo com o vento. O que eu sou?",
				"eco");
		enigmas[1] = new Enigma(
				"Quanto mais você tira de mim, maior eu fico. O que eu sou?",
				"buraco");
		enigmas[2] = new Enigma(
				"Sou cheio de furos, mas ainda assim consigo reter muita água. O que eu sou?",
				"esponja");
		enigmas[3] = new Enigma(
				"O que é que anda com os pés na cabeça?",
				"piolho");
		enigmas[4] = new Enigma(
				"Se você me tem, quer me compartilhar. Se você me compartilha, você não me tem mais. O que eu sou?",
				"segredo");
	}


	public boolean fimDaMasmorra(){
    	return fim;
    }

    public void avancarNaFase(Fase proximaFaseDaAtual){
        this.faseAtual = proximaFaseDaAtual;
        if(proximaFaseDaAtual.proximasFases.length == 0) {
        	this.fim = true;
        }
    }

    public Fase faseAtual(){
        return faseAtual;
    }
}