package aula10.vo;

public class Produto {

		private int idProduto;
		private String nome;
		private String fabricante;
		private double valor;
		private double peso;
		
		
		public Produto(int idProduto, String nome, String fabricante, double valor, double peso) {
			super();
			this.idProduto = idProduto;
			this.nome = nome;
			this.fabricante = fabricante;
			this.valor = valor;
			this.peso = peso;
		}
		public Produto() {
			// TODO Auto-generated constructor stub
		}
		public int getIdProduto() {
			return idProduto;
		}
		public void setIdProduto(int idProduto) {
			this.idProduto = idProduto;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getFabricante() {
			return fabricante;
		}
		public void setFabricante(String fabricante) {
			this.fabricante = fabricante;
		}
		public double getValor() {
			return valor;
		}
		public void setValor(double valor) {
			this.valor = valor;
		}
		public double getPeso() {
			return peso;
		}
		public void setPeso(double peso) {
			this.peso = peso;
		}
		
		@Override
		public String toString() {
		return this.getNome() +" - "+ this.getFabricante()+" - "+ this.getPeso()+" - "+this.getValor();
		}
		
		
}
