import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Livro> colecaoLivros;
    private Livro livro;

    public Biblioteca() {
        this.colecaoLivros = new ArrayList<Livro>(100);
    }

    public int livrosCadastrados(){
        return colecaoLivros.size();
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

}
