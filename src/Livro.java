import java.util.ArrayList;

public class Livro {

    private String isbn;
    private String titulo;
    private int ano;
    private Autor autor;
    private ArrayList<Autor> autores;

    public Livro(String isbn, String titulo, int ano){
        this.isbn = isbn;
        this.titulo = titulo;
        this.ano = ano;
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

    public Autor getAutor(){
        return autor;
    }

    public void setAutor(Autor autor){
        this.autor = autor;
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

    public boolean adicionaAutor(Autor autor){
        if (this.autores == null) {
            this.autores = new ArrayList<Autor>();
        }
        return this.autores.add(autor);
    }

}
