
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class principal {

	public static void main(String[] args) {
		int opcao;
		Scanner scan = new Scanner(System.in);
		arvore arv = new arvore();

		String uPadrao = "101010";
		String sPadrao = "adm";

		String usuario = JOptionPane.showInputDialog("Usuario: ").trim();
		String senha = JOptionPane.showInputDialog("Senha: ").trim();

		if (usuario.equals(uPadrao) && senha.equals(sPadrao)) {
			do {

				opcao = (Integer.parseInt(JOptionPane.showInputDialog("BEM VINDO AO MENU! Pressione::\n" +
						"1. Cadastrar cliente\n" +
						"2. Consultar dados de um cliente \n" +
						"3. Listar clientes do sexo feminino\n" +
						"4. Media de idade dos clientes\n" +
						"5. Listar clientes com saldo maior que a media \n" +
						"0. SAIR")));


				switch (opcao) {

				case 1:
					String nome = JOptionPane.showInputDialog("Informe o nome do cliente: ").trim();
					String cpf = JOptionPane.showInputDialog("Informe o cpf: ").trim();
					int idade = (Integer.parseInt(JOptionPane.showInputDialog("Informe a idade: ")));	
					char sexo = JOptionPane.showInputDialog("Informe o sexo:").charAt(0);
					float saldo = (Float.parseFloat(JOptionPane.showInputDialog("Informe o saldo: ")));

					Cliente novo10 = new Cliente(nome, cpf, idade, sexo, saldo);
					No novo4 = new No(novo10);
					arv.verificacaoAnteriorInsercao(novo4, arv.raiz);
					JOptionPane.showMessageDialog(null, "Cadastro concluido");
					break;

				case 2:				
					if(arv.eVazia(arv.raiz)) {
						JOptionPane.showMessageDialog(null, "Ainda não possui cliente cadastrado.");
					}
					else {
						String nomePesq = JOptionPane.showInputDialog("Informe o nome do cliente: ").trim();
						Cliente c = arv.consulta(nomePesq, arv.raiz);
						
						if(c == null) {
							JOptionPane.showMessageDialog(null, "Cliente não localizado.");
						}
						else {
							JOptionPane.showMessageDialog(null, c.getNome() + " " + c.getIdade() + " " + c.getCPF() + " " + c.getSexo() + " " + c.getSaldo());
						}
					}					
					break;

				case 3:
					if(arv.eVazia(arv.raiz)) {
						JOptionPane.showMessageDialog(null, "Ainda não possui cliente cadastrado.");
					}
					else {
						JOptionPane.showMessageDialog(null, arv.imprimeMeninas());
					}
					break;

				case 4:
					if(arv.eVazia(arv.raiz)) {
						JOptionPane.showMessageDialog(null, "Ainda não possui cliente cadastrado.");
					}
					else {
						JOptionPane.showMessageDialog(null, "média idade = " + arv.calculaIdadeMedia());
					}
					break;

				case 5:
					if(arv.eVazia(arv.raiz)) {
						JOptionPane.showMessageDialog(null, "Ainda não possui cliente cadastrado.");
					}
					else {
						float saldoM = (float) arv.calculaSaldoMedio(arv.raiz);
						String content = "Saldo média igual a "+saldoM+"\n";
						content += arv.imprimeAcimaMedia();
						
						JOptionPane.showMessageDialog(null, content);
					}
					break;

				case 0:
					JOptionPane.showMessageDialog(null, "FIM");
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Opcao invalida");
				}

			} while (opcao != 0);

		} else {
			JOptionPane.showMessageDialog(null, "Usuario e/ou senha incorretos");
			System.exit(0);

		}
	}

}