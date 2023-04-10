import java.lang.reflect.Array;
import java.util.ArrayList;

public class Autor {

    private int codigo;
    private String nome;
    private ArrayList<Livro> livros;
    private Livro livro;

    public int getCodigo() {
        return codigo;
    }

    public ArrayList<Livro> getLivros(){
        return livros;
    }


    public String getNome() {
        return nome;
    }

    public Autor(int codigo, String nome, Livro livro){
        this.codigo = codigo;
        this.nome = nome;
        this.livro = livro;
        this.livros = new ArrayList<Livro>(100);
    }

    public boolean adicionarLivro(Livro livro){
        livros.add(livro);
        return false;
    }

}
