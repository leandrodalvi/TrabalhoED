
public class Arvore {
	public No raiz;
	private int quantNos;

	public Arvore() {
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
	
	public void verificacaoAnteriorInsercao(No novo, No raiz) {
		if(pesquisa(novo.getConteudo().getNome(), "", 'n', raiz) || pesquisa("", novo.getConteudo().getCPF(), 'c', raiz)) {
			System.out.println("Usuario com nome ou CPF já cadastrado");
		}else {
			inserir(novo, raiz);
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
	
	public void consulta(String nome, No raiz) {
		if(eVazia(raiz)) {
			System.out.println("Não encontrado");
			return;
		}
		if(nome.compareTo(raiz.getConteudo().getNome()) == 0) {
			System.out.println(raiz.getConteudo().getNome() + " " + raiz.getConteudo().getCPF() + " " + raiz.getConteudo().getIdade() + " " + raiz.getConteudo().getSaldo() + " " + raiz.getConteudo().getSexo());
			return;
		}
		
		if(nome.compareTo(raiz.getConteudo().getNome()) < 0) {
			consulta(nome, raiz.getEsq());
		}
		
		if(nome.compareTo(raiz.getConteudo().getNome()) > 0) {
			consulta(nome, raiz.getDir());
		}
	}
	
	public void imprimeMeninas(No raiz) {
		if(!eVazia(raiz)) {
			imprimeMeninas(raiz.getEsq());
			if(raiz.getConteudo().getSexo() == 'f') {
				System.out.println(raiz.getConteudo().getNome());
			}
			imprimeMeninas(raiz.getDir());
		}
	}
	
	public void calculaIdadeMedia(No raiz, float media) {
		if(!eVazia(raiz)) {
			media = media + raiz.getConteudo().getIdade();
			calculaIdadeMedia(raiz.getEsq(), media);
			calculaIdadeMedia(raiz.getDir(), media);
		}
	}
	
	public void calculaIdadeMedia(No raiz) {
		float media = 1;
		calculaIdadeMedia(raiz, media);
		media /= this.quantNos;
		System.out.println(media);
	}
	
	public void calculaSaldoMedio(No raiz, float media) {
		if(!eVazia(raiz)) {
			media = media + raiz.getConteudo().getSaldo();
			calculaSaldoMedio(raiz.getEsq(), media);
			calculaSaldoMedio(raiz.getDir(), media);
		}
	}
	
	public float calculaSaldoMedio(No raiz) {
		float media = 0;
		calculaSaldoMedio(raiz, media);
		media /= this.quantNos;
		return media;
	}
	
	public void acimaMedia(No raiz, float media) {
		if(!eVazia(raiz)) {
			if(raiz.getConteudo().getSaldo() > media) {
				System.out.println(raiz.getConteudo().getNome());
			}
			acimaMedia(raiz.getEsq(), media);
			acimaMedia(raiz.getDir(), media);
		}
	}
	
	public void imprime(No raiz) {
		if(!eVazia(raiz)) {
			imprime(raiz.getEsq());
			System.out.println(raiz.getConteudo().getNome());
			imprime(raiz.getDir());
		}
	}
	
}


