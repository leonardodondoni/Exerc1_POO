import java.util.ArrayList;

public class Grupo {

    private ArrayList<Autor> colecaoAutores;

    public Grupo() {
        ArrayList<Autor> colecaoAutores = new ArrayList<Autor>();
    }

    public boolean cadastraAutor(Autor autor){
        for(int i = 0;i < colecaoAutores.size(); i++){
            if(colecaoAutores.get(i).getCodigo() == autor.getCodigo())
                return false;
        }
        colecaoAutores.add(autor);
        return true;
    }

    public Autor pesquisaAutor(int codigo){
        for(int i = 0;i < colecaoAutores.size(); i++){
            if(colecaoAutores.get(i).getCodigo() == codigo)
                return colecaoAutores.get(i);
        }
        return null;
    }

    public int autoresCadastrados() {
        return colecaoAutores.size();
    }

}
