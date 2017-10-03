package modelo;

public class Ficha {
	private int num;
	private String tipo;

	public Ficha(int num, String tipo) {
		super();
		this.num = num;
		this.tipo = tipo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Ficha [num=" + num + ", tipo=" + tipo + "]";
	}

}
