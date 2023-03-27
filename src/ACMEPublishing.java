// Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class
ACMEPublishing {
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
        while(true) {
            opcao = entrada.nextInt();
            if(opcao == -1) break;
            entrada.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarLivros();
                    break;
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
                    mostraAutoresDoLivro();
                    break;
                case 8:
                    mostraTitulosLivrosMaisDeUmAutor();
                    break;
                case 9:
                    mostraAutoresMaisDeUmLivro();
                    break;
                case 10:
                    mostraLivrosDoAno();
                    break;
                default:
                    System.out.println("Opcao invalida! Redigite.");
                    break;
            }

        }
    }

    public void cadastrarLivros(){
        String isbn = "";
        while(true) {
            isbn = entrada.nextLine();
            boolean condition = !isbn.equals("-1");
            if (!condition) return;
            String titulo = entrada.nextLine();
            int ano = entrada.nextInt();
            entrada.nextLine();
            Livro l = new Livro(isbn, titulo, ano);
            if (colecaoLivros.cadastraLivro(l))
                System.out.println("1;" + l.getIsbn() + ";" + l.getTitulo() + ";" + l.getAno());
        }
    }

    public void mostraLivrosCadastrados(){
        System.out.println("2;" + colecaoLivros.getColecaoLivros().size());
    }

    public void cadastrarAutor(){
        int codigo = 0;
        while(true) {
           codigo = entrada.nextInt();
           if(codigo == -1) return;
           if(colecaoAutores.pesquisaAutor(codigo) != null){
                entrada.nextLine();
                String aux = entrada.nextLine();
                String aux2 = entrada.nextLine();
           }
           entrada.nextLine();
           String nome = entrada.nextLine();
           String isbn = entrada.nextLine();
           //entrada.nextLine();
           if(colecaoLivros.pesquisaLivro(isbn) != null){
               Autor a = new Autor(codigo, nome, colecaoLivros.pesquisaLivro(isbn));
               Livro l = colecaoLivros.pesquisaLivro(isbn);
               l.adicionaAutor(a);
               a.adicionarLivro(l);
               if(colecaoAutores.cadastraAutor(a))
                   System.out.println("3;" + a.getCodigo() + ";" + a.getNome() + ";" + isbn);
           }

        }
    }

    public void mostraAutoresCadastrados(){
        System.out.println("4;" + colecaoAutores.getColecaoAutores().size());
    }

    public void adicionaLivroAoAutor() {
        int codigo = 0;
        while(true) {
            codigo = entrada.nextInt();
            if(codigo == -1) return;
            entrada.nextLine();
            String isbn = entrada.nextLine();
            if (colecaoLivros.pesquisaLivro(isbn) != null) {
                Livro l = colecaoLivros.pesquisaLivro(isbn);
                Autor a = colecaoAutores.pesquisaAutor(codigo);
                a.adicionarLivro(l);
                System.out.println("5;" + a.getCodigo() + ";" + a.getNome() + ";" + isbn + ";" + l.getTitulo() + ";" + l.getAno());
            }
        }
    }

    public void mostraLivrosDoAutor(){
        int codigo = entrada.nextInt();
        Autor a = colecaoAutores.pesquisaAutor(codigo);
        ArrayList<Livro> aux = a.getLivros();
        for(int i = 0; i < aux.size(); i ++){
            System.out.println("6;" + a.getCodigo() + ";" + a.getNome() + ";" + aux.get(i).getTitulo() + ";" + aux.get(i).getAno());
        }
    }

    public void mostraAutoresDoLivro(){
        String isbn = entrada.nextLine();
        Livro l = colecaoLivros.pesquisaLivro(isbn);
        if(l != null) {
            System.out.print("7;");
            for (int i = 0; i < l.getAutores().size(); i++) {
                System.out.print(l.getAutores().get(i).getNome() + ";");
            }
            System.out.println();
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
        ArrayList<Autor> aux = new ArrayList<Autor>();
        for(int i = 0; i < colecaoAutores.getColecaoAutores().size(); i++){
            if(colecaoAutores.getColecaoAutores().get(i).getLivros().size() > 1){
                aux.add(colecaoAutores.getColecaoAutores().get(i));
            }
        }

        for(int i = 0; i < colecaoAutores.getColecaoAutores().size(); i++){
            if(colecaoAutores.getColecaoAutores().get(i).getLivros().size() > 1) {
                System.out.print("9;" + colecaoAutores.getColecaoAutores().get(i).getNome() + ";");
                System.out.print(colecaoAutores.getColecaoAutores().get(i).getLivros().get(i).getIsbn() + ";");
            }
        }
        System.out.println();
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