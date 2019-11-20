import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int opcao;
		Scanner scan = new Scanner(System.in);
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

		System.out.println("média saldo = " + arv.calculaSaldoMedio());
		System.out.println("média idade = " + arv.calculaIdadeMedia());

		do {
			System.out.println("=====MENU=====");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Consultar dados de um cliente");
			System.out.println("3 - Listar clientes do sexo feminino");
			System.out.println("4 - Media de idade dos clientes");
			System.out.println("5 - Listar clientes com saldo maior que a media");
			System.out.println("0 - Sair");
			opcao = scan.nextInt();

			switch (opcao) {

			case 1:
				System.out.println("Informe o nome do cliente: ");
				String nome = scan.next();
				System.out.println("Informe o cpf: ");
				String cpf = scan.next();
				System.out.println("Informe a idade: ");
				int idade = scan.nextInt();
				System.out.println("Informe o sexo: ");
				char sexo = scan.next().charAt(0);
				System.out.println("Informe o saldo: ");
				float saldo = scan.nextFloat();
				Cliente novo10 = new Cliente(nome, cpf, idade, sexo, saldo);
				No novo4 = new No(novo10);
				arv.verificacaoAnteriorInsercao(novo4, arv.raiz);
				System.out.println("Cadastro concluido");
				break;

			case 2:
				System.out.println("Informe o nome do cliente: ");
				String nomePesq = scan.next();
				arv.consulta(nomePesq, arv.raiz);
				break;

			case 3:
				arv.imprimeMeninas(arv.raiz);
				break;

			case 4:
				System.out.println("média idade = " + arv.calculaIdadeMedia());
				break;

			case 5:
				System.out.println("média saldo = " + arv.calculaSaldoMedio());
				break;

			case 0:
				System.out.println("FIM");
				break;

			default:
				System.out.println("Opcao invalida");
			}

		} while (opcao != 0);

	}

}
