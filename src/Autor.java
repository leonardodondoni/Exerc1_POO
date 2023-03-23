import java.lang.reflect.Array;
import java.util.ArrayList;

public class Autor {

    private int codigo;
    private String nome;
    private ArrayList<Livro> livros;

    public int getCodigo() {
        return codigo;
    }

    public ArrayList<Livro> getLivros(){
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autor(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
        this.livros = livros;
    }

    public boolean adicionarLivro(Livro livro){
        livros.add(livro);
        return false;
    }

}
