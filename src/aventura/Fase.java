package aventura;
import inimigos.*;

public class Fase {
    public String introducao;
    public Inimigo[] inimigosDaFase;
    public boolean especial;

    public Fase(String introducao, Inimigo[] inimigosDaFase) {
        this.introducao = introducao;
        this.inimigosDaFase = inimigosDaFase;
        this.especial = false;
    }
    
    public Fase(String introducao) {
    	this.especial = true;
    }

    public String textoIntroducao(){
        return introducao;
    }
    
    public boolean verificarFaseEspecial() {
    	return especial;
    }
}