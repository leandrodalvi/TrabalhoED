
public class No {
	private No esq;
	private No dir;
	private Cliente conteudo;
	
	public No(Cliente novo) {
		this.conteudo = novo;
		this.dir = this.esq = null;
	}
	
	public int soma() {
        return conteudo.getIdade()
                + (dir == null ? 0 : dir.soma())
                + (esq == null ? 0 : esq.soma());
    }
	
	
	public No getEsq() {
		return esq;
	}
	public void setEsq(No esq) {
		this.esq = esq;
	}
	public No getDir() {
		return dir;
	}
	public void setDir(No dir) {
		this.dir = dir;
	}
	public Cliente getConteudo() {
		return conteudo;
	}
	public void setConteudo(Cliente conteudo) {
		this.conteudo = conteudo;
	}
}
