package aventura;

public class Enigma {
	String pergunta;
	String resposta;
	
	public Enigma(String pergunta, String resposta) {
		this.pergunta = pergunta;
		this.resposta = resposta;
	}
	
	public boolean respostaCerta(String tentativa) {
		if (tentativa.equalsIgnoreCase(resposta)) {
			return true;
		}
		return false;
	}
}
