
public class arvore {
	private no raiz;
	private int quantNos;

	public arvore() {
		this.raiz = null;
		this.quantNos = 0;
	}

	public no getRaiz() {
		return raiz;
	}

	public int getQuantNos() {
		return quantNos;
	}
	
	
	public boolean eVazia (no raiz){
		return(raiz== null);
	}
	
	public void verificacao_anterior_a_insercao(no novo, no raiz) {
		if(pesquisa(novo.getConteudo().getNome(), "", 'n', raiz) && pesquisa("", novo.getConteudo().getCPF(), 'c', raiz)) {
			System.out.println("Usuario com nome ou CPF já cadastrado");
		}else {
			inserir(novo, raiz);
		}
	}

	public void inserir(no novo, no raiz) {
		if(eVazia(raiz)) {
			this.raiz = novo;
		}
		if(novo.getConteudo().getNome().compareTo(raiz.getConteudo().getNome()) < 0) {
			if(raiz.getEsq() == null) {
				raiz.setEsq(novo);
			}else {
				inserir(novo, raiz.getEsq());
			}
		}
		if(novo.getConteudo().getNome().compareTo(raiz.getConteudo().getNome()) > 0) {
			if(raiz.getDir() == null) {
				raiz.setDir(novo);
			}else {
				inserir(novo, raiz.getDir());
			}
		}
	}
	
	public boolean pesquisa(String nome, String CPF, char seletor, no raiz) {
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
			if(CPF.compareTo(raiz.getConteudo().getNome()) == 0) {
				return true;
			}
			
			if(CPF.compareTo(raiz.getConteudo().getNome()) < 0) {
				return pesquisa(nome, CPF, seletor, raiz.getEsq());
			}
			
			if(CPF.compareTo(raiz.getConteudo().getNome()) > 0) {
				return pesquisa(nome, CPF, seletor, raiz.getDir());
			}
		}
		return false;
	}
}
/*
	public no remover (String nome, no arv){
		if(nome.compareTo(arv.getConteudo().getNome()) < 0){
			arv.setEsq(remover (nome, arv.getEsq()));
		}else{if()
	}
}*/