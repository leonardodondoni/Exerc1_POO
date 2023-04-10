import java.util.ArrayList;

public class Grupo {

    private ArrayList<Autor> colecaoAutores;

    public Grupo() {
        this.colecaoAutores = new ArrayList<Autor>(100);
    }

    public ArrayList<Autor> getColecaoAutores(){
        return colecaoAutores;
    }

    public boolean cadastraAutor(Autor autor){
        for(int i = 0;i < this.colecaoAutores.size(); i++){
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


}
