
public class Principal {

	public static void main(String[] args) {
		Arvore arv = new Arvore();
		Cliente elder = new Cliente("Elder", "164.789.456-78", 10, 'm', 100);
		Cliente ricardo = new Cliente("Ricardo", "789.789.789-87", 10, 'm', 100);
		Cliente adriana = new Cliente("Adriana", "456.456.456-98", 20, 'f', 80);
		Cliente guilherme = new Cliente("Guilherme", "164.789.456-79", 20, 'm', 80);
		
		No novo = new No(elder);
		No novo1 = new No(ricardo);
		No novo2 = new No(adriana);
		No novo3 = new No(guilherme);
		
		arv.verificacaoAnteriorInsercao(novo, arv.raiz);
		arv.verificacaoAnteriorInsercao(novo1, arv.raiz);
		arv.verificacaoAnteriorInsercao(novo2, arv.raiz);
		arv.verificacaoAnteriorInsercao(novo3, arv.raiz);
		
		System.out.println("média saldo = "+arv.calculaSaldoMedio());
		System.out.println("média idade = "+arv.calculaIdadeMedia());
	}

}
