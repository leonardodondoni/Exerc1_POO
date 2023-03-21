// Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ACMEPublishing {
    private Scanner entrada = null;
    private Biblioteca biblioteca;
    private Grupo grupo;

    public ACMEPublishing() {
        entrada = new Scanner(System.in);
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("dados.txt"));
            entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
            PrintStream streamSaida = new PrintStream(new File("saida.txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        entrada.useLocale(Locale.ENGLISH);
        // Implemente aqui o seu codigo adicional do construtor
        biblioteca = new Biblioteca();
        grupo = new Grupo();
    }

    public void executar() {
        int opcao = 0;
        do {
            menuOpcoes();
            System.out.print("Digite a opcao desejada: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcao invalida! Redigite.");
            }

        } while (opcao != 0);
    }
    private void menuOpcoes() {
        System.out.println("=====================================");
        System.out.println("Menu de opcoes");
        System.out.println("[1] Cadastrar livros");
        System.out.println("[2] Mostrar quantos livros foram cadastrados");
        System.out.println("[3] Cadastrar autores");
        System.out.println("[4] Mostrar quantos autores foram cadastrados");
        System.out.println("[5] Adicionar livro a um autor");
        System.out.println("[6] Mostrar os livros de um determinado autor");
        System.out.println("[7] Mostrar os nomes dos autores de um determinado livro");
        System.out.println("[8] Mostrar os títulos dos livros que possuem mais de um autor");
        System.out.println("[9] Mostrar os nomes dos autores com mais de um livro");
        System.out.println("[10] Mostrar os livros de um determinado ano");

    }

    public void cadastrarLivros(){
        String isbn = entrada.nextLine();
        String titulo = entrada.nextLine();
        entrada.nextLine();
        int ano = entrada.nextInt();
        Livro l = new Livro(isbn, titulo, ano);
        if (biblioteca.cadastraLivro(l))
            System.out.println("1;" + l.getIsbn() + ";" + l.getTitulo() + ";" + l.getAno());
    }

    public void mostraLivrosCadastrados(){
        System.out.println("2;" + biblioteca.livrosCadastrados());
    }

    public void cadastrarAutor(){
        int codigo = entrada.nextInt();
        String nome = entrada.nextLine();
        entrada.nextLine();
        int isbn = entrada.nextInt();
    }

    public void mostraAutoresCadastrados(){
        System.out.println("4;" + grupo.autoresCadastrados());
    }



}