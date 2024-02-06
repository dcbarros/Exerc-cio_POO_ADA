package models;

import java.util.List;

public class Disco{
    private final String nome;
    private final String gravadora;
    private final String genero;
    private final Integer anoLancamento;
    private final List<Musica> musicasAlbum;

    public Disco(String nome, String gravadora, String genero, Integer anoLancamento, List<Musica> musicasAlbum) {
        this.nome = nome;
        this.gravadora = gravadora;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.musicasAlbum = musicasAlbum;
    }

    public String getNome() {
        return nome;
    }

    public String getGravadora() {
        return gravadora;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public List<Musica> getMusicasAlbum() {
        return musicasAlbum;
    }

}