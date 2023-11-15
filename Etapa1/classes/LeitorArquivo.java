package Etapa1.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class LeitorArquivo {
    private BufferedReader reader;

    public LeitorArquivo(String caminho) {
        this.reader = this.getFileReader(caminho);
    }

    public BufferedReader getReader() {
        return this.reader;
    }

    private BufferedReader getFileReader(String filename) {
        try {
            String caminho = resolverCaminho(filename);
            File file = Paths.get(caminho).toFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            return reader;
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
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
