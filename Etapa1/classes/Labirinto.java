package Etapa1.classes;

import java.io.BufferedReader;
import java.io.IOException;

public class Labirinto {

    static int tentativas = 0;
    protected char[][] maze = null;

    public static void main(String[] args) throws IOException {
        Labirinto lab = new Labirinto();
        lab.criaLabirinto("lab.txt");
        Labirinto.printLabirinto(lab);
        if (!lab.percorreLabirinto()) {
            print("Labirinto sem saída.");

        }
    }

    public Labirinto() {
    }

    // Construtor opcional para passar o nome do arquivo diretamente
    public Labirinto(String filename) throws IOException {
        this.criaLabirinto(filename);
    }

    public void criaLabirinto(String filename) throws IOException {
        if (this.maze != null)
            throw new IllegalStateException("Labirinto já criado via construtor.");

        BufferedReader reader = (new LeitorArquivo(filename)).getReader();
        String line;

        int rowCount = 0;
        int colCount = 0;

        // Le arquivo para contar linhas e numero maximo de colunas
        while ((line = reader.readLine()) != null) {
            rowCount++;
            colCount = Math.max(line.length(), colCount);
        }

        reader.close();
        reader = (new LeitorArquivo(filename)).getReader();

        // Inicializa estrutura que armazena o labirinto, uma matriz de char
        this.maze = new char[rowCount][colCount];

        int currentRow = 0;

        // Iterara sobre o arquivo e joga os chars lidos para dentro da variavel
        // labirinto
        while ((line = reader.readLine()) != null) {
            int lineLength = line.length();
            char lineChars[] = new char[colCount];
            for (int i = 0; i < lineChars.length; i++) {
                if (i < lineLength) {
                    lineChars[i] = line.charAt(i);
                } else {
                    lineChars[i] = ' ';
                }
            }
            this.maze[currentRow] = lineChars;
            currentRow++;
        }

        reader.close();
    }

    // metodo auxilar para imprimir labirinto
    public static void printLabirinto(Labirinto lab) {
        for (char[] line : lab.maze) {
            print(String.valueOf(line));
        }
    }

    public boolean percorreLabirinto() {

        try {
            return percorreLabirinto(0, 0, this.maze);
        } catch (Exception e) {
            print(e.getMessage());
            return false;
        }
    }

    // metodo que percorre o labirinto usando recursao
    private boolean percorreLabirinto(int row, int col, char[][] maze) throws Exception {

        // manter numero de tentativas em variavel estatica
        Labirinto.tentativas++;

        if (Labirinto.tentativas > 1000)
            throw new Exception("Numero maximo de tentativas excedido.");

        // verifica condicoes que retornam falso na recursao atual
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] == 'V'
                || maze[row][col] == 'X') {

            return false;
        }

        // encontra saida e reporta a celula (linha/coluna) e numero de movimentos
        // (recursoes) usadas
        if (this.maze[row][col] == 'D') {
            System.out.printf("Encontrou saida na celula [%d][%d] após %d movimentos", row + 1, col + 1, tentativas);
            return true;
        }

        // marca a atual celula como visitada
        this.maze[row][col] = 'V';

        // inicia recursao se movemento uma casa em cada direcao
        // se uma recursao retorna falso, vai para o proximo movimento possivel
        if (percorreLabirinto(row + 1, col, maze) || percorreLabirinto(row - 1, col, maze)
                || percorreLabirinto(row, col + 1, maze) || percorreLabirinto(row, col - 1, maze)) {
            return true;
        }

        // caso nenuma condicao seja satisfeita, retorna falso (labirinto sem saida)
        return false;
    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
