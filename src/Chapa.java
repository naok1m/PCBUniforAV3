import java.util.ArrayList;

class Chapa {
    int largura;
    int altura;
    ArrayList<Espaco> espacosDisponiveis;

    public Chapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        this.espacosDisponiveis = new ArrayList<>();
        // Adiciona o espaço inicial (toda a chapa disponível)
        this.espacosDisponiveis.add(new Espaco(0, 0, largura, altura));
    }

    // Método que tenta cortar uma peça na chapa
    public boolean cortarPeca(Peca peca, ArrayList<String> saidas) {
        for (int i = 0; i < espacosDisponiveis.size(); i++) {
            Espaco espaco = espacosDisponiveis.get(i);
            if (espaco.podeCortar(peca)) {
                // Adiciona a peça à saída no formato correto (tipo, x, y)
                saidas.add(peca.getTipo() + " " + espaco.x + " " + espaco.y);
                // Divide o espaço após o corte
                ArrayList<Espaco> novosEspacos = espaco.dividirEspacos(peca);
                // Remove o espaço atual e adiciona os novos espaços
                espacosDisponiveis.remove(i);
                espacosDisponiveis.addAll(novosEspacos);
                return true;
            }
        }
        return false; // Não conseguiu cortar a peça
    }
}