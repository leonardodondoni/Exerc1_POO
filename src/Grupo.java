import java.util.ArrayList;

public class Grupo {

    private ArrayList<Autor> colecaoAutores;

    public Grupo() {
        ArrayList<Autor> colecaoAutores = new ArrayList<Autor>();
    }

    public ArrayList<Autor> getColecaoAutores(){
        return colecaoAutores;
    }

    public void setColecaoAutores(ArrayList<Autor> colecaoAutores) {
        this.colecaoAutores = colecaoAutores;
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


}
