package models;

import java.util.ArrayList;
import java.util.List;

public class PlayerMusica {

    private List<Disco> bandeja = new ArrayList<Disco>();
    private Integer volume;

    private Musica faixaSelecionada;
    private Disco discoSelecionado;
    private Integer indexFaixa;
    private Integer indexDisco;
    

    public PlayerMusica() {
        this.volume = 20;
        this.faixaSelecionada = null;
        this.discoSelecionado = null;
    }

    public void inserirDisco(Disco disco){
        this.bandeja.add(disco);
        this.discoSelecionado = this.bandeja.get(this.bandeja.size()-1);
        this.faixaSelecionada = this.discoSelecionado.getMusicasAlbum().get(0);
        this.indexFaixa = 0;
        this.indexDisco = this.bandeja.size()-1;
    }

    public void removerDisco(int posicaoDisco){
        if(!this.bandeja.isEmpty() || (this.bandeja.size()-1) < posicaoDisco){
            this.bandeja.remove(posicaoDisco);
            this.discoSelecionado = this.bandeja.get(0);
            this.faixaSelecionada = this.discoSelecionado.getMusicasAlbum().get(0);
            this.indexFaixa = 0;
            this.indexDisco = 0;
        }
    }

    public void selecionarDisco(int disco){
        if(!this.bandeja.isEmpty() || (this.bandeja.size()-1) < disco){
            this.discoSelecionado = this.bandeja.get(disco);
            this.faixaSelecionada = this.discoSelecionado.getMusicasAlbum().get(0);     
            this.indexFaixa = 0;
            this.indexDisco = disco;
        }
    }

    public void avancarFaixa(){
        this.indexFaixa++;
        this.faixaSelecionada = this.discoSelecionado.getMusicasAlbum().get(this.indexFaixa); 
    }

    public void retrocederFaixa(){
        this.indexFaixa--;
        if(this.indexFaixa < 0){
            this.indexFaixa = this.discoSelecionado.getMusicasAlbum().size()-1;
        }
        this.faixaSelecionada = this.discoSelecionado.getMusicasAlbum().get(this.indexFaixa); 
    }

    public void aumentarVolume(){
        this.volume =+ 1;
    }

    public void aumentarVolume(int volume){
        this.volume =+ volume;
    }

    public void reduzirVolume(){
        this.volume =- 1;
    }

    public void reduzirVolume(int volume){
        this.volume =- volume;
    }

    public void reproduzir(){
        limparConsole();
        Musica faixa = discoSelecionado.getMusicasAlbum().get(this.indexFaixa);
        System.out.println("Player em Execução");
        System.out.printf("%d-%d Tocando: %s - %s\n", 
                            this.indexFaixa + 1,
                            discoSelecionado.getMusicasAlbum().size(), 
                            faixa.getTitulo(), 
                            faixa.getNomeCantor());
        timeMusica(faixa.getTempoMusica());
        pausarSegundo();
        if(this.indexFaixa < this.discoSelecionado.getMusicasAlbum().size() - 1){
            avancarFaixa();
        }else{
            this.indexDisco++;
            this.indexDisco = this.indexDisco%this.bandeja.size();
            selecionarDisco(indexDisco);
        }
    }

    public List<Disco> getBandeja() {
        return bandeja;
    }

    public Integer getVolume() {
        return volume;
    }

    public Musica getFaixaSelecionada() {
        return faixaSelecionada;
    }

    public Disco getDiscoSelecionado() {
        return discoSelecionado;
    }

    public Integer getIndexFaixa() {
        return indexFaixa;
    }

    public Integer getIndexDisco() {
        return indexDisco;
    }

    public void setIndexDisco(Integer indexDisco) {
        this.indexDisco = indexDisco;
    }

    private void timeMusica(int tempo){
        int tempoHoras = tempo/3600;
        int tempoMinutos = tempo%3600/60;
        int tempoSegundos = tempo%60;

        System.out.printf("%02d:%02d:%02d\n",
                            tempoHoras,
                            tempoMinutos,
                            tempoSegundos);
    }
    
    private void pausarSegundo() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void limparConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

