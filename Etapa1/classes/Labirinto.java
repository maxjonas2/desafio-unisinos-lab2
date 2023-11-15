package Etapa1.classes;

import java.io.BufferedReader;
import java.io.IOException;

public class Labirinto {

    static int tentativas = 0;
    protected char[][] maze;

    public static void main(String[] args) throws IOException {
        Labirinto lab = new Labirinto(22, 13);

        lab.percorreLabirinto();
    }

    public Labirinto(int tamanhoX, int tamanhoY) throws IOException {
        this.maze = new char[tamanhoY][tamanhoX];
        BufferedReader reader = (new LeitorArquivo("lab.txt")).getReader();
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            this.maze[count++] = line.toCharArray();
        }
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

        // print("Attempt number " + Labirinto.tentativas + ". Row " + row + " | Col " +
        // col);

        if (Labirinto.tentativas > 1000)
            throw new Exception("Numero maximo de tentativas excedido.");

        if (row < 0 || col < 0 || maze[row][col] == 'V' || maze[row][col] == 'X' || row >= maze.length
                || col >= maze[0].length
                || maze[row][col] == 'V') {

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
