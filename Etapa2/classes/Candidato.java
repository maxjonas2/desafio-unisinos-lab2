package Etapa2.classes;

public class Candidato {
    protected String nome;
    protected String partido;
    protected int intencoesVotos;

    public Candidato(String nome, String partido, int intencoesVotos) {
        this.nome = nome;
        this.partido = partido;
        this.intencoesVotos = intencoesVotos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public int getIntencoesVotos() {
        return intencoesVotos;
    }

    public void setIntencoesVotos(int intencoesVotos) {
        this.intencoesVotos = intencoesVotos;
    }

    @Override
    public String toString() {
        return "Candidato [nome=" + nome + ", partido=" + partido + ", intencoesVotos=" + intencoesVotos + "]";
    }

}