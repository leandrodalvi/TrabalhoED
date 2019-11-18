
public class no {
	private no esq;
	private no dir;
	private cliente conteudo;
	
	public no(cliente novo) {
		this.conteudo = novo;
		this.dir = this.esq = null;
	}
	
	
	
	public no getEsq() {
		return esq;
	}
	public void setEsq(no esq) {
		this.esq = esq;
	}
	public no getDir() {
		return dir;
	}
	public void setDir(no dir) {
		this.dir = dir;
	}
	public cliente getConteudo() {
		return conteudo;
	}
	public void setConteudo(cliente conteudo) {
		this.conteudo = conteudo;
	}
}
