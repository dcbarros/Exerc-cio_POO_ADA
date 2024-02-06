# Pacote models
## Classe Disco

Representa um disco musical.

### Atributos
```
**nome:** String - O nome do disco.
**gravadora:** String - O nome da gravadora do disco.
**genero:** String - O gênero musical do disco.
**anoLancamento:** Integer - O ano de lançamento do disco.
**musicasAlbum:** List<Musica> - Lista de músicas presentes no disco.
```


### Métodos
```
**Disco(String nome, String gravadora, String genero, Integer anoLancamento, List<Musica> musicasAlbum): Construtor da classe.**
**getNome():** String: Retorna o nome do disco.
**getGravadora():** String: Retorna o nome da gravadora do disco.
**getGenero():** String: Retorna o gênero musical do disco.
**getAnoLancamento():** Integer: Retorna o ano de lançamento do disco.
**getMusicasAlbum():** List<Musica>: Retorna a lista de músicas do disco.
```
## Classe Musica
Representa uma música.

### Atributos
```
**titulo:** String - O título da música.
**nomeCantor:** String - O nome do cantor da música.
**tempoMusica:** Integer - O tempo da música em segundos.
```
### Métodos
```
**Musica(String titulo, String nomeCantor, Integer tempoMusica): Construtor da classe.**
**getTitulo():** String: Retorna o título da música.
**getNomeCantor():** String: Retorna o nome do cantor da música.
**getTempoMusica():** Integer: Retorna o tempo da música em segundos.
```

## Classe PlayerMusica
Representa um player de música.

### Atributos
```
**bandeja:** List<Disco> - Lista de discos na bandeja do player.
**volume:** Integer - Volume do player.
**faixaSelecionada:** Musica - Música atualmente selecionada.
**discoSelecionado:** Disco - Disco atualmente selecionado.
**indexFaixa:** Integer - Índice da faixa atual.
**indexDisco:** Integer - Índice do disco atual.
```

### Métodos
```
**PlayerMusica(): Construtor da classe.**
**inserirDisco(Disco disco):** Insere um disco na bandeja do player.
**removerDisco(int posicaoDisco):** Remove um disco da bandeja do player.
**selecionarDisco(int disco):** Seleciona um disco da bandeja do player.
**avancarFaixa():** Avança para a próxima faixa do disco.
**retrocederFaixa():** Retrocede para a faixa anterior do disco.
**aumentarVolume():** Aumenta o volume do player em 1 unidade.
**aumentarVolume(int volume):** Aumenta o volume do player.
**reduzirVolume():** Reduz o volume do player em 1 unidade.
**reduzirVolume(int volume):** Reduz o volume do player.
**executor():** Executa a música atualmente selecionada.
**getBandeja():** List<Disco>: Retorna a bandeja do player.
**getVolume():** Integer: Retorna o volume do player.
**getFaixaSelecionada():** Musica: Retorna a música atualmente selecionada.
**getDiscoSelecionado():** Disco: Retorna o disco atualmente selecionado.
**getIndexFaixa():** Integer: Retorna o índice da faixa atual.
**getIndexDisco():** Integer: Retorna o índice do disco atual.
**setIndexDisco(Integer indexDisco):** Define o índice do disco atual.
**timeMusica(int tempo):** Exibe o tempo da música no formato HH:MM:SS.
**pausarSegundo():** Pausa a execução por 2 segundos.
**limparConsole():** Limpa o console.
```