package Etapa2.classes;

import java.util.Arrays;
import java.util.Random;

public class PrincipalCandidatos implements PCandidatos {
    private static Random rand = new Random((long) (10e6));

    /*
     * Utilize EXCLUSIVAMENTE os métodos de ordenação Inserção
     * Direta e Seleção Direta (com as alterações necessárias) para
     * realizar a ordenação do array de Candidato.
     */

    public static void main(String args[]) {
        int aleatorio = rand.nextInt(1, 100);
        Candidato[] candidatos = new Candidato[aleatorio];

        for (int i = 0; i < candidatos.length; i++) {
            candidatos[i] = obterCandidatoAleatorio();
        }

        Candidato[] listaOrdenada = ordenaCandidatos(candidatos);
        imprimeCandidatos(listaOrdenada);
    }

    public static void imprimeCandidatos(Candidato[] candidatos) {
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println(candidatos[i].nome + " - " + (candidatos[i].getIntencoesVotos()) + " - "
                    + (candidatos[i].getPartido()));
        }
    }

    public static Candidato[] ordenaCandidatosPorNome(Candidato[] listaCands) {
        // Insetion sort

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

    public static Candidato[] ordenaCandidatos(Candidato[] listaCands) {
        Candidato[] copiaLista = Arrays.copyOf(listaCands, listaCands.length);

        Candidato[] ordenado = ordenaCandidatosPorNome(
                ordenaCandidatosPorVotos(ordenaCandidatosPorPartido(copiaLista)));

        return ordenado;

    }

    public static Candidato[] ordenaCandidatosPorVotos(Candidato[] listaCands) {
        // Selection sort

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

    public int pesquisaBinariaCandidatos(Candidato[] candidatos) {
        /* IMPLEMENTAR */
        return 0;
    }

    public static int getRandomInt(int max) {

        int randomNumber = rand.nextInt(0, max);
        return randomNumber;

    }

    public static Candidato obterCandidatoAleatorio() {
        String nomes[] = new String[] { "Amanda", "Lula", "Bolsonaro", "Matheus", "Jonas" };
        String partidos[] = new String[] { "ABL", "PL", "PTBX", "PartidoTopster" };
        Candidato cand = new Candidato(nomes[getRandomInt(nomes.length)], partidos[getRandomInt(partidos.length)],
                getRandomInt(50));
        return cand;
    }
}

interface PCandidatos {
    public int pesquisaBinariaCandidatos(Candidato[] candidatos);
}
