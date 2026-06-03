import batalha.*;
import inimigos.*;
import personagem.*;
import aventura.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Historia.introducaoHistoria();
        Personagem heroi = null;
        int classeSelecionada;
        boolean continuarMenu = true;

        do {
            Historia.selecaoPersonagem();
            classeSelecionada = sc.nextInt();
            sc.nextLine();
            System.out.print("Digite o nome do heroi: ");
            String nomeHeroi = sc.nextLine();

            switch (classeSelecionada) {
                case 1:
                    heroi = new Guerreiro(nomeHeroi);
                    continuarMenu = false;
                    break;
                case 2:
                    heroi = new Ladino(nomeHeroi);
                    continuarMenu = false;
                    break;
                case 3:
                    heroi = new Mago(nomeHeroi);
                    continuarMenu = false;
                    break;
                default:
                    System.out.println("Classe inválida. Tente novamente!");
                    break;
            }
        } while (continuarMenu);

        Masmorra masmorra = new Masmorra();

        while (heroi.estaVivo() && !masmorra.verificarFinalizacaoDaMasmorra()) {

            Fase faseAtual = masmorra.faseAtual();
            System.out.println(faseAtual.textoIntroducao());

            for (Inimigo inimigoAtual : faseAtual.inimigosDaFase) {

                while (heroi.estaVivo() && inimigoAtual.estaVivo()) {
                    System.out.println("\n--- Turno do Herói vs " + inimigoAtual.nome + " ---");

                    System.out.println("1 - Atacar");
                    System.out.println("2 - Especial");

                    int opcao = sc.nextInt();
                    sc.nextLine();

                    if (opcao < 1 || opcao > 2) {
                        System.out.println("Escolha inválida. Tente novamente!");
                        continue;
                    }

                    Batalha.iniciaBatalha(heroi, inimigoAtual, opcao);
                }
                if (heroi.estaVivo()) {
                    System.out.println("Você derrotou o " + inimigoAtual.nome);
                } else {
                    break;
                }
            }

            if (heroi.estaVivo()) {
                masmorra.incrementarAvancoDasFases();
            }
        }

        Historia.finalHistoria(heroi);
    }
}