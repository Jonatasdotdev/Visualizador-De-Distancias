# Visualizador de Distâncias

Este projeto é um aplicativo Java Swing que permite visualizar e manipular distâncias entre cidades. Ele lê dados de um arquivo CSV e fornece funcionalidades para exibir, ordenar e identificar a menor e a maior distância entre as cidades.

## Funcionalidades

- **Exibir Todas**: Mostra todas as distâncias no formato `origem -> destino: distância km`.
- **Ordenar**: Ordena as distâncias e exibe no formato `origem -> destino: distância km`.
- **Menor Distância**: Exibe a menor distância entre as cidades.
- **Maior Distância**: Exibe a maior distância entre as cidades.

## Estrutura do Projeto

O projeto é composto pelos seguintes arquivos principais:

- **`Distancia.java`**: Define a classe `Distancia` que representa a distância entre duas cidades e implementa a interface `Comparable` para ordenar as distâncias.
- **`Main.java`**: Contém o método principal que inicializa a interface gráfica do aplicativo.
- **`MainFrame.java`**: Define a interface gráfica, incluindo botões e área de texto para interação com o usuário.
- **`Utils.java`**: Fornece um método utilitário para ler o arquivo CSV e criar objetos `Distancia`.

## Requisitos

- JDK 11 ou superior.
- Biblioteca Swing (incluída no JDK).

## Como Usar

1. Compile o projeto:
   ```sh
   javac *.java
   ```

2. Execute o aplicativo:
   ```sh
   java Main
   ```

3. A interface gráfica será exibida. Certifique-se de que o arquivo `cidades.csv` esteja no mesmo diretório do aplicativo ou ajuste o caminho no código.

## Formato do Arquivo CSV

O arquivo `cidades.csv` deve ter o seguinte formato:
```
origem,destino,distância
CidadeA,CidadeB,10.5
CidadeB,CidadeC,20.3
...
```

## Notas

- Certifique-se de que o arquivo `cidades.csv` esteja formatado corretamente para evitar erros na leitura.
- O aplicativo exibe mensagens de erro se houver problemas ao ler o arquivo.

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

![Screenshot (467)](https://github.com/user-attachments/assets/e5b259bf-4c7e-4454-aa48-327d4f2d087f)
