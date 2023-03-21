import java.util.ArrayList;

public class Autor {

    private int codigo;
    private String nome;
    private Livro livro;
    private ArrayList<Livro> livros;

    public int getCodigo() {
        return codigo;
    }

    public Livro getLivro() {
        return livro;
    }

    public ArrayList<Livro> getLivros(){
        return livros;
    }

    public String getNome() {
        return nome;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autor(int codigo, String nome, Livro livro){
        this.codigo = codigo;
        this.nome = nome;
        this.livro = livro;
        this.livros = livros;
    }
    public boolean adicionarLivro(Livro livro){

    }
}
