package Etapa1.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class Labirinto {

    public static void main(String[] args) throws IOException {
        Labirinto lab = new Labirinto(20, 13);
        Labirinto.printLabirinto(lab);
        // BufferedReader reader = Labirinto.getFileReader("lab.txt");
        // String line;
        // while ((line = reader.readLine()) != null) {
        // System.out.println(line);
        // }
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

    private static void printLabirinto(Labirinto lab) {

    }

    protected boolean percorreLabirinto(int row, int col) {

        if (this.maze[row][col] == 'S') {
            return true;
        } else {
            return percorreLabirinto(1, 1);
        }

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
}
