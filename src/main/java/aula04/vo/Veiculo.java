package aula04.vo;

public abstract class Veiculo {

	//constante
	//public static final int num_rodas = 2;

	private String marca;
	private String modelo;
	private int idVeiculo;
	private String chassi;
	
	public Veiculo(String marca, String modelo, int idVeiculo, String chassi) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.idVeiculo = idVeiculo;
		this.chassi = chassi;
	}
	public Veiculo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	
	
}
