import heroi.*;
import inimigos.*;
import util.ExibeBarras;
import aventura.*;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Historia.introducaoHistoria();
        Heroi heroi = null;
        int classeSelecionada;
        boolean continuarMenu = true;

        do {
            Historia.selecaoPersonagem();
            classeSelecionada = scanner.nextInt();
            scanner.nextLine();
            System.out.print("\nDigite o nome do heroi: ");
            String nomeHeroi = scanner.nextLine();

            switch (classeSelecionada) {
                case 1:
                    heroi = new Guerreiro(nomeHeroi);
                    continuarMenu = false;
                    break;
                case 2:
                    heroi = new Mago(nomeHeroi);
                    continuarMenu = false;
                    break;
                case 3:
                    heroi = new Ladino(nomeHeroi);
                    continuarMenu = false;
                    break;
                default:
                    System.out.println("Classe inválida. Tente novamente!");
                    break;
            }
        } while (continuarMenu);
        
        System.out.println(heroi);
        
        Masmorra masmorra = new Masmorra();

        iniciarAventuraPelaMasmorra(masmorra, heroi);

        Historia.finalHistoria(heroi);
    }
    
    public static void iniciarAventuraPelaMasmorra(Masmorra masmorra,Heroi heroi) {

        while (heroi.estaVivo()) { 
            Fase faseAtual = masmorra.faseAtual();
            System.out.println(faseAtual.textoIntroducao());

            if (faseAtual.verificarFaseEspecial()) {
                
                if (faseAtual.nomeFase.equals("Enigma")) {
                	System.out.println(faseAtual.enigma.pergunta);
                    String resposta = scanner.nextLine();
                    if (faseAtual.enigma.respostaCerta(resposta)) {
                        System.out.println("\nResposta correta!");
                        heroi.regenerarVida();
                        heroi.aumentarDanoDeAtaque();
                        heroi.incrementarContadorEspecial();
                    } else {
                        System.out.println("\nResposta errada! Você não ganha nenhum bônus.");
                    }
                }
                
                else if(faseAtual.nomeFase.equals("NPC com Buffs")) {
                	if(heroi.estaVivo()) {
                		int opcao;
                		do {
	                		opcao = scanner.nextInt();
	                		scanner.nextLine();
	                		switch(opcao) {
		                		case 1:
		                            heroi.regenerarVida();
		                            break;
		                		case 2:
		                			heroi.aumentarDanoDeAtaque();
		                			break;
		                		case 3:
		                            heroi.incrementarContadorEspecial();
		                            break;
		                        default:
		                        	System.out.println("Opcao invalida.Tente de novo!");	                        	

	                		} 	
                		} while(opcao < 1 || opcao > 3);	

                	}
                	
                }
                

            } else {
                turnoBatalha(faseAtual, heroi);
            }

            if (!heroi.estaVivo()) {
                break;
            }
            
            if(masmorra.verificarFinalizacaoDaMasmorra()) {
            	break;
            }

            if(faseAtual.proximasFases.length > 0) {
                if (faseAtual.proximasFases.length == 1) {
                    masmorra.avancarNaFase(faseAtual.proximasFases[0]);
                } else {
                    int opcao;
                    int quantidadeCaminhos = faseAtual.proximasFases.length;
                    do {
                    	System.out.println(Historia.introduzirCaminhos());
                        System.out.print("Faça sua escolha: ");
                        opcao = scanner.nextInt();
                        scanner.nextLine(); 
                            
                        if (opcao <= 0 || opcao > quantidadeCaminhos) {
                            System.out.println("Opção inválida. Tente de novo.");                    		
                        	continue;
                        }
                        masmorra.avancarNaFase(faseAtual.proximasFases[opcao - 1]);
                    } while(opcao <= 0 || opcao > quantidadeCaminhos);
                }
            } else {
                break;
            }

        }
    }

    public static void turnoBatalha(Fase faseAtual, Heroi heroi) {
        Inimigo inimigoAtual = faseAtual.inimigoDaFase;
        int vidaMaximaHeroi = heroi.capacidadeMaxima;
        int vidaMaximaInimigo = inimigoAtual.vida;
        
        System.out.println(inimigoAtual);

        while (heroi.estaVivo() && inimigoAtual.estaVivo()) {
        	ExibeBarras.exibeBarraVida(heroi, vidaMaximaHeroi, inimigoAtual, vidaMaximaInimigo);
        	ExibeBarras.exibeContadorEspecial(heroi.contadorEspecial);
            System.out.println("1 - Atacar");
            System.out.println("2 - Especial");
            System.out.print("Escolha sua ação: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao < 1 || opcao > 2) {
                System.out.println("Escolha inválida. Tente novamente!");
                continue;
            }
            if(opcao == 2 && !heroi.analisarAtivarcaoEspecial()) {
            	System.out.println("Heroi não possui energia suficiente para ativar especial!");
            	continue;
            }

            Batalha.iniciaBatalha(heroi, inimigoAtual, opcao);
            
        }

        if (heroi.estaVivo()) {
            System.out.printf("\nO %s foi derrotado\n",inimigoAtual.nome);
        } else {
            System.out.printf("\n%s teve um fim trágico durante sua jornada.\n", heroi.nome);
        }
        ExibeBarras.exibeBarraVida(heroi, vidaMaximaHeroi, inimigoAtual, vidaMaximaInimigo);
    }
}