package Etapa2.classes;

import java.util.Random;

public class PrincipalCandidatos {
    private static Random rand = new Random((long) (10e6));

    public static void main(String args[]) {
        int aleatorio = rand.nextInt(20, 100);
        Candidato[] candidatos = new Candidato[aleatorio];

        for (int i = 0; i < candidatos.length; i++) {
            candidatos[i] = obterCandidatoAleatorio();
        }

        Candidato[] listaOrdenada = ordenaCandidatosPorNome(candidatos);
        imprimeCandidatos(listaOrdenada);
    }

    public static void imprimeCandidatos(Candidato[] candidatos) {
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println(candidatos[i].nome + " - " + (candidatos[i].partido) + " - "
                    + Integer.toString(candidatos[i].intencoesVotos));
        }
    }

    public static Candidato[] ordenaCandidatosPorNome(Candidato[] listaCands) {

        // Candidato[] listaOrdenada = new Candidato[listaCands.length];

        for (int i = 0; i < listaCands.length - 1; i++) {
            boolean flipped = false;

            for (int j = 0; j < listaCands.length - 1; j++) {
                if (listaCands[i].nome.compareTo(listaCands[i + 1].nome) > 0) {

                    Candidato temp = listaCands[i];
                    listaCands[i] = listaCands[i + 1];
                    listaCands[i + 1] = temp;
                    flipped = true;
                }
            }

            if (flipped == false)
                break;

        }

        return listaCands;
    }

    public static int getRandomInt(int max) {

        int randomNumber = rand.nextInt(0, max);
        return randomNumber;

    }

    public static Candidato obterCandidatoAleatorio() {
        String nomes[] = new String[] { "Jose", "Amanda", "Lula", "Bolsonaro", "Matheus", "Jonas" };
        String partidos[] = new String[] { "PL", "PT", "PTB", "P1", "P2" };
        Candidato cand = new Candidato(nomes[getRandomInt(5)], partidos[getRandomInt(4)], getRandomInt(500));
        return cand;
    }
}
