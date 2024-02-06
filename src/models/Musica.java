package models;

public class Musica {
    private final String titulo;
    private final String nomeCantor;
    private final Integer tempoMusica;

    
    public Musica(String titulo, String nomeCantor, Integer tempoMusica) {
        this.titulo = titulo;
        this.nomeCantor = nomeCantor;
        this.tempoMusica = tempoMusica;
    }


    public String getTitulo() {
        return titulo;
    }


    public String getNomeCantor() {
        return nomeCantor;
    }


    public Integer getTempoMusica() {
        return tempoMusica;
    }



    
}
