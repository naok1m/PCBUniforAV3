import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CorteBidimensionalPOO {

    public static void main(String[] args) throws IOException {
        // Lendo o arquivo de entrada
    	File inputFile = new File("C:\\Users\\thiago\\OneDrive\\Área de Trabalho\\input.txt");
        if (!inputFile.exists()) {
            System.out.println("Arquivo input.txt não encontrado!");
            return;
        }

        Scanner fileScanner = new Scanner(inputFile);

        // Primeira linha: dimensões da chapa
        int chapaLargura = fileScanner.nextInt();
        int chapaAltura = fileScanner.nextInt();

        // Segunda linha: número de peças
        int numPecas = fileScanner.nextInt();

        // Linhas restantes: informações de cada peça
        ArrayList<Peca> pecas = new ArrayList<>();
        for (int i = 0; i < numPecas; i++) {
            int tipo = fileScanner.nextInt();
            int largura = fileScanner.nextInt();
            int altura = fileScanner.nextInt();
            pecas.add(new Peca(tipo, largura, altura));
        }

        fileScanner.close();

        // Criando a chapa
        Chapa chapa = new Chapa(chapaLargura, chapaAltura);

        // Lista para armazenar as saídas
        ArrayList<String> saidas = new ArrayList<>();

        // Processamento do corte das peças
        for (Peca peca : pecas) {
            boolean cortou = chapa.cortarPeca(peca, saidas);
            if (!cortou) {
                System.out.println("Não foi possível cortar a peça tipo " + peca.getTipo());
            }
        }

        // Criando o arquivo de saída
        File outputFile = new File("C:\\\\Users\\\\thiago\\\\OneDrive\\\\Área de Trabalho\\\\output.txt");
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (String saida : saidas) {
                writer.write(saida + "\n");
            }
        }

        System.out.println("Arquivo output.txt gerado com sucesso!");
    }
}
