import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import models.Disco;
import models.Musica;
import models.PlayerMusica;

public class App {

    public static void main(String[] args) throws Exception {

        Random rand = new Random();
        PlayerMusica tocador = new PlayerMusica();
        List<Disco> discos = new ArrayList<>();

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

        discos.add(d1);
        discos.add(d2);
        discos.add(d3);

        Scanner scanner = new Scanner(System.in);
        boolean manterProgramaAberto = true;
        while(manterProgramaAberto){
            System.out.printf("%15s Player de Discos %15s\n","","");
            System.out.printf(
                "1 - Adicionar Disco %10s 2 - Remover Disco\n3 - Passar Música %12s 4 - Voltar Música\n5 - Mudar disco %14s 6 - Reproduzir\n7 - Pausar %19s 8 - Parar Música\n9 - Discos da Badeja %9s 10 - Sair\n",
                "","","","","");
            System.out.print("Selecione uma opção: ");
            Integer opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    limparConsole();
                    int auxiliarCase1 = 1;
                    for (Disco disco : discos) {
                        System.out.printf("%s - %s\n", auxiliarCase1, disco.getNome());
                        auxiliarCase1++;
                    }
                    System.out.print("Qual disco você quer adicionar: ");
                    Integer indiceCase1 = scanner.nextInt() - 1;    
                    tocador.inserirDisco(discos.get(indiceCase1));    
                    limparConsole();            
                    break;
                case 2:
                    limparConsole();
                    if(tocador.getBandeja().isEmpty()){
                        System.out.println("Não tem discos na bandeja, por favor adicione algum\n");
                    }else{
                        int auxiliarCase2 = 1;
                        for (Disco disco : tocador.getBandeja()) {
                            System.out.printf("%s - %s\n", auxiliarCase2, disco.getNome());
                            auxiliarCase2++;
                        }
                        System.out.print("Qual disco você quer remover: ");
                        Integer indiceCase2 = scanner.nextInt() - 1;
                        if(indiceCase2 > tocador.getBandeja().size() - 1){
                            System.out.println("Disco não encontrado");
                            break;
                        }   
                        tocador.removerDisco(indiceCase2);
                        limparConsole();
                    }
                    break;
                case 3:
                    limparConsole();
                    tocador.avancarFaixa();
                    tocador.reproduzir();
                    break;
                case 4:
                    limparConsole();
                    tocador.retrocederFaixa();
                    tocador.reproduzir();                  
                    break;
                case 5:
                    limparConsole();
                    if(tocador.getBandeja().isEmpty()){
                        System.out.println("Não tem discos na bandeja, por favor adicione algum\n");
                    }else{
                        int auxiliarCase5 = 1;
                        for (Disco disco : tocador.getBandeja()) {
                            System.out.printf("%s - %s\n", auxiliarCase5, disco.getNome());
                            auxiliarCase5++;
                        }
                        System.out.print("Qual disco você quer remover: ");
                        Integer indiceCase5 = scanner.nextInt() - 1; 
                        if(indiceCase5 > tocador.getBandeja().size() - 1){
                            System.out.println("Disco não encontrado");
                            break;
                        }     
                        tocador.selecionarDisco(indiceCase5);
                        limparConsole();
                    }
                    break;
                case 6:
                    limparConsole();
                    tocador.reproduzir();
                    tocador.avancarFaixa();
                    break;
                case 7:
                    limparConsole();
                    tocador.pausa();
                    tocador.timeMusica(tocador.getFaixaSelecionada().getTempoMusica());
                    System.out.print("Digite qualquer tecla para sair da pausa.");
                    scanner.nextLine();
                    scanner.nextLine();
                    tocador.reproduzir();
                    break;
                case 8:
                    limparConsole();
                    tocador.parar();
                    tocador.timeMusica(0);
                    System.out.print("Digite qualquer tecla para sair da parada.");
                    scanner.nextLine();
                    scanner.nextLine();
                    tocador.reproduzir();
                    break;     
                case 9:
                    limparConsole();
                    int auxiliarCase10 = 1;
                    for (Disco disco : tocador.getBandeja()) {
                        System.out.printf("%s - %s\n", auxiliarCase10, disco.getNome());
                        auxiliarCase10++;
                    }
                    System.out.print("Digite qualquer tecla para sair.");
                    scanner.nextLine();
                    scanner.nextLine();
                    limparConsole();
                    break; 

                case 10:
                    manterProgramaAberto = false;
                    limparConsole();
                    System.out.println("Obrigado pelo acesso!");
                    break; 
                default:
                    limparConsole();
                    System.out.println("Escolha não identificada.\n");
                    break;
            }

        }
        scanner.close();
    }
    
    
    private static void limparConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
