package aventura;
import inimigos.*;

public class Masmorra {
    public Fase[] fases;
    Fase faseAtual;
    boolean fim = false;
    
    public Masmorra() {
    	this.fases = new Fase[]{
    		new Fase("Fase 1",Historia.introducaoFaseI(),new Esqueleto("Esqueleto Guerreiro")),
    		new Fase("Fase II.1",Historia.introducaoFaseII_I(),new Esqueleto()),
    		new Fase("Fase II.2",Historia.introducaoFaseII_II(),new Zumbi("Zumbi")),
    		new Fase("Enigma do Palindromo",Historia.introducaoFaseIII()),
    		new Fase("NPC com Buffer",Historia.introducaoFaseIV()),
    		new Fase("Fase Boss",Historia.introducaoFaseV(),new Vampiro())
    	};
    	fases[0].adicionarProximasFases(fases[1],fases[2],fases[3]);
    	fases[1].adicionarProximasFases(fases[4]);
    	fases[2].adicionarProximasFases(fases[4]);
    	fases[3].adicionarProximasFases(fases[5]);
    	fases[4].adicionarProximasFases(fases[5]);
		

    	faseAtual = fases[0];

    }
    

    public boolean verificarFinalizacaoDaMasmorra(){
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