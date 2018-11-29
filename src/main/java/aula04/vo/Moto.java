package aula04.vo;


public class Moto extends Veiculo {

	private int cilindrada;
	private String tipo;

	public Moto(String marca, String modelo, int idVeiculo, String chassi, int cilindrada, String tipo) {
		super(marca, modelo, idVeiculo, chassi);
		this.cilindrada = cilindrada;
		this.tipo = tipo;
	}

	public Moto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Moto(String marca, String modelo, int idVeiculo, String chassi) {
		super(marca, modelo, idVeiculo, chassi);
		// TODO Auto-generated constructor stub
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Moto [cilindrada=" + cilindrada + ", tipo=" + tipo + "]";
	}

}
