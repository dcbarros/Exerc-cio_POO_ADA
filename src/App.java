import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Disco;
import models.Musica;
import models.PlayerMusica;

public class App {

    public static void main(String[] args) throws Exception {

        Random rand = new Random();
        PlayerMusica tocador = new PlayerMusica();

        List<Musica> albumD1 = new ArrayList<>();
        albumD1.add(new Musica("Debochando Legal", "Cleitinho do Reggea", rand.nextInt(100,200)));
        albumD1.add(new Musica("Cabeça de Gelo", "Joãozinho do Reggea", rand.nextInt(120,200)));
        albumD1.add(new Musica("Briza", "Pedrinho do Reggea", rand.nextInt(140,200)));
        Disco d1 = new Disco("Só pedrada", "Only", "Reggea", 2023, albumD1);

        List<Musica> albumD2 = new ArrayList<>();
        albumD2.add(new Musica("Forrozada", "Soldados do Forró", rand.nextInt(140,200)));
        albumD2.add(new Musica("Valeu o Boi", "Cuzcuz com Ovo", rand.nextInt(140,200)));
        albumD2.add(new Musica("Meu chapéu", "Banda Exelentissimos", rand.nextInt(140,200)));
        Disco d2 = new Disco("Só Forró", "Radio Radioativo", "Forro", 2023, albumD2);

        List<Musica> albumD3 = new ArrayList<>();
        albumD3.add(new Musica("Eu vou puxar o seu pé", "Corpos de canibais", rand.nextInt(140,200)));
        albumD3.add(new Musica("Matar todo mundo", "Extermínio", rand.nextInt(140,200)));
        albumD3.add(new Musica("Silêncio sepulcral", "Roedores do Sotão", rand.nextInt(140,200)));
        Disco d3 = new Disco("Só DeathMetal", "Only", "Metal", 2023, albumD3);

        tocador.inserirDisco(d1);
        tocador.inserirDisco(d2);
        tocador.inserirDisco(d3);

        while(true){
            if(tocador.getBandeja().isEmpty()){
                System.out.println("Não tem discos na bandeija");
                break;
            }
            tocador.reproduzir();
        }

    }

}
