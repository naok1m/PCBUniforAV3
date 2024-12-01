
public class Peca{
	private int tipo;
	private int largura;
	private int altura;
	
	public Peca(int tipo, int largura, int altura) {
		this.tipo = tipo;
		this.altura = altura;
		this.largura = largura;
	
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
}
