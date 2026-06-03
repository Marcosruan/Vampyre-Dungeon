package aventura;
import inimigos.*;

public class Fase {
    public String introducao;
    public Inimigo[] inimigosDaFase;

    public Fase(String introducao, Inimigo[] inimigosDaFase) {
        this.introducao = introducao;
        this.inimigosDaFase = inimigosDaFase;
    }

    public String textoIntroducao(){
        return introducao;
    }
}