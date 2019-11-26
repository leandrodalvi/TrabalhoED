import java.util.ArrayList;

public class arvore {
	public No raiz;
	private int quantNos;

	public arvore() {
		this.raiz = null;
		this.quantNos = 0;
	}

	public No getRaiz() {
		return raiz;
	}

	public int getQuantNos() {
		return quantNos;
	}


	public boolean eVazia (No raiz){
		return(raiz == null);
	}

	public String verificacaoAnteriorInsercao(No novo, No raiz) {
		if(pesquisa(novo.getConteudo().getNome(), "", 'n', raiz) || pesquisa("", novo.getConteudo().getCPF(), 'c', raiz)) {
			return "Usuario com nome ou CPF já cadastrado";
		}else {
			inserir(novo, raiz);
			return "Usuário inserido";
		}
	}

	public void inserir(No novo, No raiz) {
		if(eVazia(raiz)) {
			this.raiz = novo;
			return;
		}
		if(novo.getConteudo().getNome().compareTo(raiz.getConteudo().getNome()) < 0) {
			if(raiz.getEsq() == null) {
				raiz.setEsq(novo);
				this.quantNos++;
			}else {
				inserir(novo, raiz.getEsq());
			}
		}
		if(novo.getConteudo().getNome().compareTo(raiz.getConteudo().getNome()) > 0) {
			if(raiz.getDir() == null) {
				raiz.setDir(novo);
			}else {
				inserir(novo, raiz.getDir());
				this.quantNos++;
			}
		}
	}

	public boolean pesquisa(String nome, String CPF, char seletor, No raiz) {
		if(seletor == 'n') {
			if(eVazia(raiz)) {
				return false;
			}
			if(nome.compareTo(raiz.getConteudo().getNome()) == 0) {
				return true;
			}

			if(nome.compareTo(raiz.getConteudo().getNome()) < 0) {
				return pesquisa(nome, CPF, seletor, raiz.getEsq());
			}

			if(nome.compareTo(raiz.getConteudo().getNome()) > 0) {
				return pesquisa(nome, CPF, seletor, raiz.getDir());
			}
		}
		if(seletor == 'c') {
			if(eVazia(raiz)) {
				return false;
			}
			if(CPF.compareTo(raiz.getConteudo().getCPF()) == 0) {
				return true;
			}

			if(CPF.compareTo(raiz.getConteudo().getCPF()) < 0) {
				return pesquisa(nome, CPF, seletor, raiz.getEsq());
			}

			if(CPF.compareTo(raiz.getConteudo().getCPF()) > 0) {
				return pesquisa(nome, CPF, seletor, raiz.getDir());
			}
		}
		return false;
	}


	public Cliente consulta(String nome) {

		if(nome.compareTo(raiz.getConteudo().getNome()) == 0) {
			return raiz.getConteudo();
		}

		if(nome.compareTo(raiz.getConteudo().getNome()) < 0) {
			return consulta(nome, raiz.getEsq());
		}

		if(nome.compareTo(raiz.getConteudo().getNome()) > 0) {
			return consulta(nome, raiz.getDir());
		}
		return null;
	}

	public Cliente consulta(String nome, No raiz) {
		if(eVazia(raiz)) {
			return null;
		}
		if(nome.compareTo(raiz.getConteudo().getNome()) == 0) {
			return raiz.getConteudo();
		}

		if(nome.compareTo(raiz.getConteudo().getNome()) < 0) {
			return consulta(nome, raiz.getEsq());
		}

		if(nome.compareTo(raiz.getConteudo().getNome()) > 0) {
			return consulta(nome, raiz.getDir());
		}
		return null;
	}

	public String imprimeMeninas() {
		String content = "";

		content += imprimeMeninas(this.raiz);
		
		if(content.isEmpty()) {
			return "Nenhuma cliente foi localizada.";
		}
		else {
			return content;
		}
	}

	public String imprimeMeninas(No raiz) {
		if(!eVazia(raiz)) {
			if(raiz.getConteudo().getSexo() == 'f') {
				return raiz.getConteudo().getNome() + imprimeMeninas(raiz.getEsq()) + imprimeMeninas(raiz.getDir());
			}else {
				return imprimeMeninas(raiz.getEsq()) + imprimeMeninas(raiz.getDir());
			}
		}
		return "";
	}

	public double calculaIdadeMedia() {
		double media = raiz.getConteudo().getIdade();
		int cont = 1;

		media = (raiz.getEsq() != null)? calculaIdadeMedia(raiz.getEsq(), media, cont++) : media;
		media = (raiz.getDir() != null)? calculaIdadeMedia(raiz.getDir(), media, cont++) : media;

		return media;
	}

	public double calculaIdadeMedia(No raiz, double media, int cont ) {		
		media = (media * cont +raiz.getConteudo().getIdade()) / ++cont;

		media = (raiz.getEsq() != null)? calculaIdadeMedia(raiz.getEsq(), media, cont++) : media;
		media = (raiz.getDir() != null)? calculaIdadeMedia(raiz.getDir(), media, cont++) : media;

		return media;
	}

	public double calculaSaldoMedio(No raiz) {		
		double media = raiz.getConteudo().getSaldo();
		int cont = 1;

		media = (raiz.getEsq() != null)? calculaSaldoMedio(raiz.getEsq(), media, cont++) : media;
		media = (raiz.getDir() != null)? calculaSaldoMedio(raiz.getDir(), media, cont++) : media;

		return media;
	}

	public double calculaSaldoMedio(No raiz, double media, int cont ) {		
		media = (media * cont +raiz.getConteudo().getSaldo()) / ++cont;

		media = (raiz.getEsq() != null)? calculaSaldoMedio(raiz.getEsq(), media, cont++) : media;
		media = (raiz.getDir() != null)? calculaSaldoMedio(raiz.getDir(), media, cont++) : media;

		return media;
	}

	public String imprimeAcimaMedia() {
		String content = "";

		content += imprimeAcimaMedia(this.raiz , calculaSaldoMedio(this.raiz));
		
		if(content.isEmpty()) {
			return "Nenhuma cliente foi localizada.";
		}
		else {
			return content;
		}
	}

	public String imprimeAcimaMedia(No raiz, double media) {
		if(!eVazia(raiz)) {
			if(raiz.getConteudo().getSaldo() > media) {
				return raiz.getConteudo().getNome() + " " + imprimeAcimaMedia(raiz.getEsq(), media) + imprimeAcimaMedia(raiz.getDir(), media);
			}else {
				return imprimeAcimaMedia(raiz.getEsq(), media) + imprimeAcimaMedia(raiz.getDir(), media);
			}
		}
		return "";
	}


}



