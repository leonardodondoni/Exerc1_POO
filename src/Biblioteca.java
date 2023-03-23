import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Livro> colecaoLivros;
    private Livro livro;

    public Biblioteca() {
        this.colecaoLivros = new ArrayList<Livro>(100);
    }

    public ArrayList<Livro> getColecaoLivros(){
        return colecaoLivros;
    }

    public void setColecaoLivros(ArrayList<Livro> colecaoLivros) {
        this.colecaoLivros = colecaoLivros;
    }

    public boolean cadastraLivro(Livro livro){
        for(int i = 0;i < colecaoLivros.size(); i++){
            if(colecaoLivros.get(i).getIsbn().equals(livro.getIsbn()))
                return false;
        }
        colecaoLivros.add(livro);
        return true;
    }

    public Livro pesquisaLivro(String isbn){
        for(int i = 0;i < colecaoLivros.size(); i++){
            if(colecaoLivros.get(i).getIsbn().equals(isbn))
            return colecaoLivros.get(i);
        }
        return null;
    }

    public ArrayList<Livro> pesquisaLivro(int ano){
        ArrayList<Livro> livrosAno = new ArrayList<Livro>();
        for(int i = 0;i < colecaoLivros.size(); i ++){
            if(colecaoLivros.get(i).getAno() == ano){
                livrosAno.add(colecaoLivros.get(i));
            }
        }
        if(livrosAno.size() > 0)
            return livrosAno;
        return null;
    }

    public ArrayList<Livro> pesquisaLivroAutor(Autor autor){
        ArrayList<Livro> livrosAutor = new ArrayList<Livro>();
        for(int i = 0;i < colecaoLivros.size(); i ++){
            if(colecaoLivros.get(i).getAutores().stream().findAny().equals(autor)){
                livrosAutor.add(colecaoLivros.get(i));
            }
        }
        if(livrosAutor.size() > 0)
            return livrosAutor;
        return null;
    }

}


