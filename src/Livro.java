import java.util.ArrayList;

public class Livro {

    private String isbn;
    private String titulo;
    private int ano;
    private ArrayList<Autor> autoresDoLivro;

    public Livro(String isbn, String titulo, int ano){
        this.isbn = isbn;
        this.titulo = titulo;
        this.ano = ano;
        this.autoresDoLivro = new ArrayList<Autor>();
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<Autor> getAutores(){
        return autoresDoLivro;
    }

    public int getAno() {
        return ano;
    }

    public boolean adicionaAutor(Autor autor){
        autoresDoLivro.add(autor);
        return false;
    }

}
