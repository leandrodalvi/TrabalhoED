
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
	
	public void consulta(String nome, no raiz) {
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
	
	public void imprime_meninas(no raiz) {
		if(!eVazia(raiz)) {
			imprime_meninas(raiz.getEsq());
			if(raiz.getConteudo().getSexo() == 'f') {
				System.out.println(raiz.getConteudo().getNome());
			}
			imprime_meninas(raiz.getDir());
		}
	}
	
	public void calcula_idade_media(no raiz, float media) {
		if(!eVazia(raiz)) {
			media = media + raiz.getConteudo().getIdade();
			calcula_idade_media(raiz.getEsq(), media);
			calcula_idade_media(raiz.getDir(), media);
		}
	}
	
	public float calcula_idade_media(no raiz) {
		float media = 0;
		calcula_idade_media(raiz, media);
		media /= this.quantNos;
		return media;
	}
	
	public void calcula_saldo_medio(no raiz, float media) {
		if(!eVazia(raiz)) {
			media = media + raiz.getConteudo().getSaldo();
			calcula_saldo_medio(raiz.getEsq(), media);
			calcula_saldo_medio(raiz.getDir(), media);
		}
	}
	
	public float calcula_saldo_medio(no raiz) {
		float media = 0;
		calcula_saldo_medio(raiz, media);
		media /= this.quantNos;
		return media;
	}
	
	public void acima_media(no raiz, float media) {
		if(eVazia(raiz)) {
			if(raiz.getConteudo().getSaldo() > media) {
				System.out.println(raiz.getConteudo().getNome());
			}
			acima_media(raiz.getEsq(), media);
			acima_media(raiz.getDir(), media);
		}
	}
	
}


