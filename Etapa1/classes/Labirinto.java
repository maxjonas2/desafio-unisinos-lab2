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

        while ((line = reader.readLine()) != null) {
            rowCount++;
            colCount = Math.max(line.length(), colCount);
        }

        reader.close();
        reader = (new LeitorArquivo(filename)).getReader();

        this.maze = new char[rowCount][colCount];

        int currentRow = 0;

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

    protected boolean percorreLabirinto(int row, int col, char[][] maze) throws Exception {

        Labirinto.tentativas++;

        if (Labirinto.tentativas > 1000)
            throw new Exception("Numero maximo de tentativas excedido.");

        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length || maze[row][col] == 'V'
                || maze[row][col] == 'X') {

            return false;
        }

        if (this.maze[row][col] == 'D') {
            System.out.printf("Encontrou saida na celula [%d][%d] após %d movimentos", row + 1, col + 1, tentativas);
            return true;
        }

        this.maze[row][col] = 'V';

        if (percorreLabirinto(row + 1, col, maze) || percorreLabirinto(row - 1, col, maze)
                || percorreLabirinto(row, col + 1, maze) || percorreLabirinto(row, col - 1, maze)) {
            return true;
        }

        return false;
    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
