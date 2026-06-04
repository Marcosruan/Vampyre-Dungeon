package aventura;
import inimigos.*;

public class Fase {
	public String nomeFase;
    public String introducao;
    public Inimigo inimigoDaFase;
    public boolean especial;
    public Fase[] proximasFases;

    public Fase(String nomeFase,String introducao, Inimigo inimigoDaFase) {
    	this.nomeFase = nomeFase;
    	this.introducao = introducao;
        this.inimigoDaFase = inimigoDaFase;
        this.especial = false;
        this.proximasFases = new Fase[0];
    }
    
    public Fase(String nomeFase,String introducao) {
    	this.nomeFase = nomeFase;
    	this.introducao = introducao;
    	this.inimigoDaFase = null;
    	this.especial = true;
    	this.proximasFases = new Fase[0];
    }
    public void adicionarProximasFases(Fase... fases) {
    	this.proximasFases = fases;
    }

    public String textoIntroducao(){
        return introducao;
    }
    
    public boolean verificarFaseEspecial() {
    	return especial;
    }
}