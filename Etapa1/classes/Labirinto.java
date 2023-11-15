package Etapa1.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class Labirinto {

    static int attempts = 0;

    public static void main(String[] args) throws IOException {
        Labirinto lab = new Labirinto(22, 13);
        // Labirinto.printLabirinto(lab);
        // BufferedReader reader = Labirinto.getFileReader("lab.txt");
        // String line;
        // while ((line = reader.readLine()) != null) {
        // System.out.println(line);
        // }

        print(lab.percorreLabirinto() ? "Encontrou saída" : "Nope!");
    }

    protected char[][] maze;

    public Labirinto(int tamanhoX, int tamanhoY) throws IOException {
        this.maze = new char[tamanhoY][tamanhoX];
        BufferedReader reader = getFileReader("lab.txt");
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

        Labirinto.attempts++;

        print("Attempt number " + Labirinto.attempts + ". Row " + row + " | Col " + col);

        if (Labirinto.attempts > 500)
            throw new Exception("Exceeded max number of attempts");

        if (maze[row][col] == 'V' || maze[row][col] == 'X' || row < 0 || col < 0 || row >= maze.length
                || col >= maze[0].length
                || maze[row][col] == 'V')
            return false;

        if (this.maze[row][col] == 'D') {
            System.out.printf("Encontrou saida na celula [%d][%d]", row + 1, col + 1);
            return true;
        }

        this.maze[row][col] = 'V';

        if (percorreLabirinto(row + 1, col, maze) || percorreLabirinto(row - 1, col, maze)
                || percorreLabirinto(row, col + 1, maze) || percorreLabirinto(row, col - 1, maze)) {
            return true;
        }

        return false;
    }

    private static BufferedReader getFileReader(String filename) {
        try {
            String caminho = resolverCaminho(filename);
            File file = Paths.get(caminho).toFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            return reader;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static String resolverCaminho(String filename) {
        String dir = System.getProperty("user.dir");
        String sep = File.separator;
        String[] path = new String[] { sep, "Etapa1", sep, "classes", sep, filename };

        for (String part : path) {
            dir += part;
        }

        return dir;
    }

    private static void print(Object o) {
        System.out.println(o);
    }
}
