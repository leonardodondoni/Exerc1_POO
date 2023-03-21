import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> biblioteca;
    public Biblioteca() {
        biblioteca = new ArrayList<Livro>();
    }
    public int livrosCadastrados(){
        return biblioteca.size();
    }
    public boolean cadastraLivro(Livro livro){
        for(int i = 0;i < biblioteca.size(); i++){
            if(biblioteca.get(i).getIsbn().equals(livro.getIsbn()))
                return false;
        }
        biblioteca.add(livro);
        return true;
    }

    public Livro pesquisaLivro(String isbn){
        for(int i = 0;i < biblioteca.size(); i++){
            if(biblioteca.get(i).getIsbn().equals(isbn))
            return biblioteca.get(i);
        }
        return null;
    }

    public ArrayList<Livro> pesquisaLivro(int ano){
        ArrayList<Livro> livrosAno = null;
        for(int i = 0;i < biblioteca.size(); i ++){
            if(biblioteca.get(i).getAno() == ano){
                livrosAno.add(biblioteca.get(i));
            }
        }
        if(livrosAno.size() > 0)
            return livrosAno;
        return null;
    }

}
