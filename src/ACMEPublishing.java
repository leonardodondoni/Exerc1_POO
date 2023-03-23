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
    private Biblioteca colecaoLivros;
    private Grupo colecaoAutores;

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
        colecaoLivros = new Biblioteca();
        colecaoAutores = new Grupo();
    }

    public void executar() {
        int opcao = 0;
        do {
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarLivros();
                case 2:
                    mostraLivrosCadastrados();
                    break;
                case 3:
                    cadastrarAutor();
                    break;
                case 4:
                    mostraAutoresCadastrados();
                    break;
                case 5:
                    adicionaLivroAoAutor();
                    break;
                case 6:
                    mostraLivrosDoAutor();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcao invalida! Redigite.");
            }

        } while (opcao != -1);
    }

    public void cadastrarLivros(){
        String isbn = "";
        int num = -1;
        do {
            isbn = entrada.nextLine();
            String titulo = entrada.nextLine();
            int ano = entrada.nextInt();
            entrada.nextLine();
            Livro l = new Livro(isbn, titulo, ano);
            if (colecaoLivros.cadastraLivro(l))
                System.out.println("1;" + l.getIsbn() + ";" + l.getTitulo() + ";" + l.getAno());
        } while (!isbn.equals("teste")); //TODO corrigir while
    }

    public void mostraLivrosCadastrados(){
        System.out.println("2;" + colecaoLivros.getColecaoLivros().size());
    }

    public void cadastrarAutor(){
        int codigo = 0;
        do {
            codigo = entrada.nextInt();
            String nome = entrada.nextLine();
            String isbn = entrada.nextLine();
            if (colecaoLivros.pesquisaLivro(isbn) == null) {
                Autor a = new Autor(codigo, nome);
                colecaoAutores.cadastraAutor(a);
                System.out.println("3;" + a.getCodigo() + ";" + a.getNome() + ";" + isbn);
            }
        } while (codigo != -1);
    }

    public void mostraAutoresCadastrados(){
        System.out.println("4;" + colecaoAutores.getColecaoAutores().size());
    }

    public void adicionaLivroAoAutor() {
        int codigo = 0;
        do {
            codigo = entrada.nextInt();
            String isbn = entrada.nextLine();
            if (colecaoLivros.pesquisaLivro(isbn) != null) {
                Livro l = colecaoLivros.pesquisaLivro(isbn);
                Autor a = colecaoAutores.pesquisaAutor(codigo);
                a.adicionarLivro(l);
                System.out.println("5;" + a.getCodigo() + ";" + a.getNome() + ";" + isbn + ";" + l.getTitulo() + ";" + l.getAno());
            }
        } while (codigo != -1);
    }

    public void mostraLivrosDoAutor(){
        int codigo = entrada.nextInt();
        Autor a = colecaoAutores.pesquisaAutor(codigo);
        ArrayList<Livro> livrosAutor = colecaoLivros.pesquisaLivroAutor(a);
        if(livrosAutor.size() > 0) {
            for (int i = 0; i < livrosAutor.size(); i++) {
                System.out.println("6;" + a.getCodigo() + ";" + a.getNome() + ";" + livrosAutor.get(i).getTitulo() + ";" + livrosAutor.get(i).getAno());
            }
        }
    }

    public void mostraAutoresDoLivro(){
        String isbn = entrada.nextLine();
        Livro l = colecaoLivros.pesquisaLivro(isbn);
        System.out.println("");
        if(l != null) {
            System.out.print("7;");
            for (int i = 0; i < l.getAutores().size(); i++) {
                System.out.print(l.getAutores().get(i).getNome() + ";");
            }
        }
    }

    public void mostraTitulosLivrosMaisDeUmAutor(){
        for(int i = 0; i < colecaoLivros.getColecaoLivros().size(); i ++){
            if(colecaoLivros.getColecaoLivros().get(i).getAutores().size() > 1){
                System.out.println("8;" + colecaoLivros.getColecaoLivros().get(i).getTitulo());
            }
        }
    }

    public void mostraAutoresMaisDeUmLivro() {
        for(int i = 0; i < colecaoAutores.getColecaoAutores().size(); i++){
            if(colecaoAutores.getColecaoAutores().get(i).getLivros().size() > 1) {
                System.out.println("9;" + colecaoAutores.getColecaoAutores().get(i).getNome());
                System.out.print(colecaoAutores.getColecaoAutores().get(i).getLivros().get(i).getIsbn() + ";");
            }
        }
    }

    public void mostraLivrosDoAno(){
        int ano = entrada.nextInt();
        for(int i = 0; i < colecaoLivros.getColecaoLivros().size(); i ++){
            if(colecaoLivros.getColecaoLivros().get(i).getAno() == ano){
                System.out.println("10;" + colecaoLivros.getColecaoLivros().get(i).getIsbn() + ";" +colecaoLivros.getColecaoLivros().get(i).getTitulo() + ";" +colecaoLivros.getColecaoLivros().get(i).getAno());
            }
        }
    }

}