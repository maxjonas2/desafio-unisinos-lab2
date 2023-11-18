
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {
    private static Random rand = new Random();

    static private int recursionCount = 0;

    public static void main(String args[]) {
        int aleatorio = rand.nextInt(1, 100);
        Candidato[] candidatos = new Candidato[aleatorio];

        for (int i = 0; i < candidatos.length; i++) {
            candidatos[i] = obterCandidatoAleatorio();
        }

        Candidato[] listaOrdenada = ordenaCandidatos(candidatos);

        imprimeCandidatos(listaOrdenada);

        String inputUsuario = lerInput("Digite o nome do candidato a procurar:");

        int pos = pesquisaBinariaCandidatos(listaOrdenada, inputUsuario);

        if (pos >= 0) {
            Candidato cand = listaOrdenada[pos];
            printSep();
            print("Encontrado candidato " + cand.getNome() + " do partido " + cand.getPartido() + " na posicao " + pos);
        } else {
            printSep();
            print("Nenhum candidato encontrado.");
        }
    }

    private static String lerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        print(prompt);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public static void imprimeCandidatos(Candidato[] candidatos) {
        print("Lista de candidatos:\n");
        for (int i = 0; i < candidatos.length; i++) {
            print(candidatos[i].getNome() + " - " + (candidatos[i].getIntencoesVotos()) + " - "
                    + (candidatos[i].getPartido()));
        }
        printSep();
    }

    // pesquisa binaria de candidatos
    public static int pesquisaBinariaCandidatos(Candidato[] candidatos, String nomeProcurado) {

        Candidato[] cands = ordenaCandidatosPorNome(candidatos);
        return pesquisaBinariaCandidatos(nomeProcurado, cands, 0, cands.length - 1);
    }

    private static int pesquisaBinariaCandidatos(String nomeProcurado, Candidato[] candidatos, int inf, int sup) {
        if (++recursionCount > 100) {
            throw new StackOverflowError("Numero maximo de buscas excedido.");
        }

        if (inf > sup)
            return -1;

        int mid = (int) Math.floor((inf + sup) / 2);

        if (candidatos[mid].getNome().toLowerCase().equals(nomeProcurado.toLowerCase())) {
            return mid;
        } else {
            if (isNomeMaior(nomeProcurado, candidatos[mid].getNome())) {
                return pesquisaBinariaCandidatos(nomeProcurado, candidatos, mid + 1, sup);
            } else {
                return pesquisaBinariaCandidatos(nomeProcurado, candidatos, inf, mid - 1);
            }
        }
    }

    private static boolean isNomeMaior(String a, String b) {
        return a.toLowerCase().compareTo(b.toLowerCase()) > 0;
    }

    // ordena candidatos na ordem de criterios solicitada, aninhando as chamadas dos
    // metodos de acordo
    public static Candidato[] ordenaCandidatos(Candidato[] listaCands) {
        Candidato[] copiaLista = Arrays.copyOf(listaCands, listaCands.length);

        Candidato[] ordenado = ordenaCandidatosPorNome(
                ordenaCandidatosPorVotos(ordenaCandidatosPorPartido(copiaLista)));

        return ordenado;

    }

    // insertion sort para ordenar por nome e usando 'compareTo' de String para
    // verificar a relacao alfabetica
    // (maior ou menor)
    public static Candidato[] ordenaCandidatosPorNome(Candidato[] listaCands) {

        Candidato[] copiaLista = Arrays.copyOf(listaCands, listaCands.length);

        for (int i = 0; i < copiaLista.length; i++) {
            Candidato atual = copiaLista[i];
            int index = i;

            while (index > 0 && atual.getNome().compareTo(copiaLista[index - 1].getNome()) < 0) {
                copiaLista[index] = copiaLista[index - 1];
                copiaLista[index - 1] = atual;
                index--;
            }

        }

        return copiaLista;
    }

    // selection sort para ordenar por votos
    // itera sobre a lista, encontra o menor valor (indice minIndex) e joga para o
    // indice 'i' (atual)
    public static Candidato[] ordenaCandidatosPorVotos(Candidato[] listaCands) {

        Candidato[] copiaLista = Arrays.copyOf(listaCands, listaCands.length);

        for (int i = 0; i < copiaLista.length; i++) {
            int minIndex = i;

            for (int j = i; j < copiaLista.length; j++) {
                if (copiaLista[j].getIntencoesVotos() > copiaLista[minIndex].getIntencoesVotos()) {
                    minIndex = j;
                }
            }

            Candidato temp = copiaLista[i];
            copiaLista[i] = copiaLista[minIndex];
            copiaLista[minIndex] = temp;

        }

        return copiaLista;
    }

    // selection sort para ordenar candidatos por partido
    public static Candidato[] ordenaCandidatosPorPartido(Candidato[] listaCands) {

        Candidato[] copiaLista = Arrays.copyOf(listaCands, listaCands.length);

        for (int i = 0; i < copiaLista.length; i++) {
            int minIndex = i;

            for (int j = i; j < copiaLista.length; j++) {
                if (copiaLista[j].getPartido().compareTo(copiaLista[minIndex].getPartido()) < 0) {
                    minIndex = j;
                }
            }

            Candidato temp = copiaLista[i];
            copiaLista[i] = copiaLista[minIndex];
            copiaLista[minIndex] = temp;

        }

        return copiaLista;
    }

    // metodos auxiliares para gerar candidatos aleatorios usando objeto "random"
    public static int getRandomInt(int max) {

        int randomNumber = rand.nextInt(0, max);
        return randomNumber;

    }

    public static Candidato obterCandidatoAleatorio() {
        String nomes[] = new String[] { "Amanda", "Patricia", "George", "Michael", "Vinicius" };
        String partidos[] = new String[] { "ABL", "PLT", "PTB", "XLL" };
        Candidato cand = new Candidato(nomes[getRandomInt(nomes.length)], partidos[getRandomInt(partidos.length)],
                getRandomInt(50));
        return cand;
    }

    private static void print(Object o) {
        System.out.println(o);
    }

    private static void printSep() {
        print("----------------------");
    }
}
