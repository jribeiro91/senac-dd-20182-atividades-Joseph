package aula04.vo;



public class Carro extends Veiculo {

	private int numPortas;
	private int numPassageiros;

	public Carro(String marca, String modelo, int idVeiculo, String chassi, int numPortas, int numPassageiros) {
		super(marca, modelo, idVeiculo, chassi);
		this.numPortas = numPortas;
		this.numPassageiros = numPassageiros;
	}

	public Carro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carro(String marca, String modelo, int idVeiculo, String chassi) {
		super(marca, modelo, idVeiculo, chassi);
		// TODO Auto-generated constructor stub
	}

	public int getNumPortas() {
		return numPortas;
	}

	public void setNumPortas(int numPortas) {
		this.numPortas = numPortas;
	}

	public int getNumPassageiros() {
		return numPassageiros;
	}

	public void setNumPassageiros(int numPassageiros) {
		this.numPassageiros = numPassageiros;
	}

	@Override
	public String toString() {
		return "Carro [numPortas=" + numPortas + ", numPassageiros=" + numPassageiros + "]";
	}

}
