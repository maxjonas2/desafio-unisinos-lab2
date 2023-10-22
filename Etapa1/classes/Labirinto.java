package Etapa1.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class Labirinto {

    public static void main(String[] args) throws IOException {
        // Labirinto lab = new Labirinto();

    }

    protected char[][] maze = new char[10][10];

    public Labirinto() throws IOException {
        BufferedReader reader = getFileReader("lab.txt");
        String line;
        while ((line = reader.readLine()) != null) {
            this.maze[0] = line.toCharArray();
        }
    }

    protected boolean percorreLabirinto(int row, int col) {

        if (this.maze[row][col] == 'S') {
            return true;
        } else {
            return percorreLabirinto(1, 1);
        }

    }

    private BufferedReader getFileReader(String filename) {
        try {
            // File file = new File(Folder);
            String resolvedPath = resolvePath(filename);
            File file = Paths.get(resolvedPath).toFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            return reader;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private String resolvePath(String filename) {
        String dir = System.getProperty("user.dir");
        String sep = File.separator;
        String[] path = new String[] { sep, "Etapa1", sep, "classes", sep, filename };

        for (String part : path) {
            dir += part;
        }

        return dir;
    }
}
