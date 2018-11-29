package aula04.vo;

public class Caminhao extends Veiculo {

	private int numArticulacao;
	private int capacidadeDeCarga;
	private Carroceria carroceria;

	public Caminhao(int id, String modelo, String chassi, String marca) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Caminhao(int numArticulacao, int capacidadeDeCarga, Carroceria carroceria) {
		super();
		this.numArticulacao = numArticulacao;
		this.capacidadeDeCarga = capacidadeDeCarga;
		this.carroceria = carroceria;
	}

	public int getNumArticulacao() {
		return numArticulacao;
	}

	public void setNumArticulacao(int numArticulacao) {
		this.numArticulacao = numArticulacao;
	}

	public int getCapacidadeDeCarga() {
		return capacidadeDeCarga;
	}

	public void setCapacidadeDeCarga(int capacidadeDeCarga) {
		this.capacidadeDeCarga = capacidadeDeCarga;
	}

	public Carroceria getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(Carroceria carroceria) {
		this.carroceria = carroceria;
	}

	@Override
	public String toString() {
		return "Caminhao [numArticulacao=" + numArticulacao + ", capacidadeDeCarga=" + capacidadeDeCarga
				+ ", carroceria=" + carroceria + "]";
	}

}
