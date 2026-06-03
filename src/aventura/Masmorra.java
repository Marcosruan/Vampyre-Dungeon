package aventura;
import inimigos.*;

public class Masmorra {
    public static int numDaFase = 0;

    public static final Fase[] fases = {
        new Fase(Historia.introducaoFaseI(), new Inimigo[]{ 
            new Esqueleto("Esqueleto")
        }),
        new Fase(Historia.introducaoFaseII(), new Inimigo[]{
            new Esqueleto(),
            new Zumbi("Zumbi"),
        }),
        new Fase(Historia.introducaoFaseIII(), new Inimigo[]{
                new Vampiro()
        })
    };

    public boolean verificarFinalizacaoDaMasmorra(){
        return numDaFase == fases.length;
    }

    public void incrementarAvancoDasFases(){
        if(!this.verificarFinalizacaoDaMasmorra()){
            numDaFase++;
        }
    }

    public Fase faseAtual(){
        if (this.verificarFinalizacaoDaMasmorra()) {
            return null;
        }
        return fases[numDaFase];
    }
}