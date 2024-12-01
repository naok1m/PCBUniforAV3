import java.util.ArrayList;

class Espaco {
    int x, y, largura, altura;

    public Espaco(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    // Método que verifica se uma peça cabe nesse espaço
    public boolean podeCortar(Peca peca) {
        return peca.getLargura() <= this.largura && peca.getAltura() <= this.altura;
    }

    // Método que cria novos espaços após cortar uma peça
    public ArrayList<Espaco> dividirEspacos(Peca peca) {
        ArrayList<Espaco> novosEspacos = new ArrayList<>();
        if (this.largura > peca.getLargura()) {
            // Cria um novo espaço à direita
            novosEspacos.add(new Espaco(this.x + peca.getLargura(), this.y, this.largura - peca.getLargura(), peca.getAltura()));
        }
        if (this.altura > peca.getAltura()) {
            // Cria um novo espaço abaixo
            novosEspacos.add(new Espaco(this.x, this.y + peca.getAltura(), this.largura, this.altura - peca.getAltura()));
        }
        return novosEspacos;
    }
}