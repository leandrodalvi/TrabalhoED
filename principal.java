
public class principal {

	public static void main(String[] args) {
		Arvore arv = new Arvore();
		Cliente elder = new Cliente("Elder", "164.789.456-78", 22, 'm', 92);
		Cliente ricardo = new Cliente("Ricardo", "789.789.789-87", 92, 'm', 43);
		Cliente adriana = new Cliente("Adriana", "456.456.456-98", 17, 'f', 75);
		Cliente guilherme = new Cliente("Guilherme", "164.789.456-79", 38, 'm', 14);
		No novo = new No(elder);
		No novo1 = new No(ricardo);
		No novo2 = new No(adriana);
		No novo3 = new No(guilherme);
		
		arv.verificacaoAnteriorInsercao(novo, arv.raiz);
		arv.verificacaoAnteriorInsercao(novo1, arv.raiz);
		arv.verificacaoAnteriorInsercao(novo2, arv.raiz);
		arv.verificacaoAnteriorInsercao(novo3, arv.raiz);
		arv.calculaIdadeMedia(arv.raiz);
	}

}
