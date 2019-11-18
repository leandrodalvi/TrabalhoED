
public class principal {

	public static void main(String[] args) {
		arvore arv = new arvore();
		cliente elder = new cliente("Elder", "164.789.456-78", 22, 'm', 92);
		cliente ricardo = new cliente("Ricardo", "789.789.789-87", 92, 'm', 43);
		cliente adriana = new cliente("Adriana", "456.456.456-98", 17, 'f', 75);
		cliente guilherme = new cliente("Guilherme", "164.789.456-79", 38, 'm', 14);
		no novo = new no(elder);
		no novo1 = new no(ricardo);
		no novo2 = new no(adriana);
		no novo3 = new no(guilherme);
		
		arv.verificacao_anterior_a_insercao(novo, arv.raiz);
		arv.verificacao_anterior_a_insercao(novo1, arv.raiz);
		arv.verificacao_anterior_a_insercao(novo2, arv.raiz);
		arv.verificacao_anterior_a_insercao(novo3, arv.raiz);
		arv.calcula_idade_media(arv.raiz);
	}

}
