import batalha.*;
import inimigos.*;
import personagem.*;
import aventura.*;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Historia.introducaoHistoria();
        Personagem heroi = null;
        int classeSelecionada;
        boolean continuarMenu = true;

        do {
            Historia.selecaoPersonagem();
            classeSelecionada = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o nome do heroi: ");
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

        Masmorra masmorra = new Masmorra();

        iniciarAventuraPelaMasmorra(masmorra, heroi);

        Historia.finalHistoria(heroi);
    }
    
    public static void iniciarAventuraPelaMasmorra(Masmorra masmorra,Personagem heroi) {

        while (heroi.estaVivo()) { 
            Fase faseAtual = masmorra.faseAtual();
            System.out.println(faseAtual.textoIntroducao());

            if (faseAtual.verificarFaseEspecial()) {
                
                if (faseAtual.nomeFase.equals("Enigma do Palindromo")) {
                    String resposta = scanner.nextLine();
                    if (resposta.equalsIgnoreCase("agulha")) {
                        System.out.println("\nResposta correta!");
                        heroi.regenerarVida();
                        heroi.aumentarOfensiva();
                        heroi.incrementarContadorEspecial();
                    } else {
                        System.out.println("\nResposta errada! Você não ganha nenhum bônus.");
                    }
                }
                
                else if(faseAtual.nomeFase.equals("NPC com Buffer")) {
                	if(heroi.estaVivo()) {
                		int opcao;
                		do {
	                		System.out.println("""
	                				Parabéns heroi vc conseguiu uma recompensa por ter derrotado o monstro.Escolha sabiamente uma opção:
	                				1 - Regenerar vida
	                				2 - Aumentar dano
	                				3 - Incrementar o acumulador do ataque especial
	                				Faça a sua escolha:
	                				""");
	                		opcao = scanner.nextInt();
	                		scanner.nextLine();
	                		switch(opcao) {
		                		case 1:
		                            heroi.regenerarVida();
		                            break;
		                		case 2:
		                			heroi.aumentarOfensiva();
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
                    	System.out.println("\nEscolha qual caminho deseja seguir:");
                        for (int i = 0; i < quantidadeCaminhos; i++) {
                            System.out.printf("%d - %s\n" ,(i+1),faseAtual.proximasFases[i].nomeFase);
                        }
                        System.out.print("Faça sua escolha: ");
                        opcao = scanner.nextInt();
                        scanner.nextLine(); 
                            
                        if (opcao <= 0 || opcao > quantidadeCaminhos) {
                            System.out.println("Opção inválida.Tente de novo.");                    		
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

    public static void turnoBatalha(Fase faseAtual, Personagem heroi) {
        Inimigo inimigoAtual = faseAtual.inimigoDaFase;

        while (heroi.estaVivo() && inimigoAtual.estaVivo()) {
            System.out.printf("\n--- Turno do Herói [%s - Vida: %d] vs %s [Vida: %d] ---\n", 
                    heroi.nome, heroi.vida, inimigoAtual.nome, inimigoAtual.vida);
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
            System.out.printf("\nO %s foi derrotado",inimigoAtual.nome);
        } else {
            System.out.printf("\n%s teve um fim trágico durante sua jornada.\n", heroi.nome);
        }
    }
}