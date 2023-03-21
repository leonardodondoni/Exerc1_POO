import java.util.ArrayList;

public class Autor {

    private int codigo;
    private String nome;
    private Livro livro;

    public int getCodigo() {
        return codigo;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autor(int codigo, String nome, Livro livro){
        this.codigo = codigo;
        this.nome = nome;
        this.livro = livro;
    }
    public boolean adicionarLivro(Livro livro){

    }
}
