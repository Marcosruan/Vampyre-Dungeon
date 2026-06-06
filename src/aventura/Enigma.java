package aventura;

public class Enigma {
	String pergunta;
	String resposta;
	
	public boolean respostaCerta(String tentativa) {
		if (tentativa.equalsIgnoreCase(resposta)) {
			return true;
		}
		return false;
	}
}
