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

//    public Autor getAutor(){
//        for(int i = 0;i < autoresDoLivro.size(); i++){
//            autoresDoLivro.get(i);
//        }
//    }

    public int getAno() {
        return ano;
    }

    public void setAutores(ArrayList<Autor> autores){
        this.autoresDoLivro = autores;
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
        autoresDoLivro.add(autor);
        return false;
    }

}
