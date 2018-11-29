package aula10.vo;

public class Funcionario {
	
	private int idFuncionario;
	private String nome;
	private String numeroMatricula;
	private String cpf;
	
	
	public Funcionario(int idFuncionario, String nome, String numeroMatricula, String cpf) {
		super();
		this.idFuncionario = idFuncionario;
	 	this.nome = nome;
		this.numeroMatricula = numeroMatricula;
		this.cpf = cpf;
	}
	
	public Funcionario(String nome, String numeroMatricula, String cpf, int idFuncionario) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
		this.cpf = cpf;
	}
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumeroMatricula() {
		return numeroMatricula;
	}
	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		
		return this.getIdFuncionario() +" " + this.getNome() + " - " + this.getCpf() + " - "+ this.getNumeroMatricula() ;
	}
	
}
