import java.util.ArrayList;

public class Livro {

    private String isbn;
    private String titulo;
    private int ano;
    private ArrayList<Autor> autores;

    public Livro(String isbn, String titulo, int ano){
        this.isbn = isbn;
        this.titulo = titulo;
        this.ano = ano;
        this.autores = autores;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Autor> getAutores(){
        return autores;
    }

    public boolean adicionaAutor(Autor autor){
        return autores.add(autor);
    }

}
