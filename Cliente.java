
public class Cliente {
	private String nome;
	private String CPF;
	private int idade;
	private char sexo;
	private float saldo;
	
	public Cliente(String nome, String CPF, int idade, char sexo, float saldo) {
		this.nome = nome;
		this.CPF = CPF;
		this.idade = idade;
		this.sexo = sexo;
		this.saldo = saldo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
}
