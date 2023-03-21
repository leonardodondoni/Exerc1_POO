import java.util.ArrayList;

public class Grupo {

    private ArrayList<Autor> autores;

    public Grupo() {
        autores = new ArrayList<Autor>();
    }

    public boolean cadastraAutor(Autor autor){
        for(int i = 0;i < autores.size(); i++){
            if(autores.get(i).getCodigo() == autor.getCodigo())
                return false;
        }
        autores.add(autor);
        return true;
    }

    public Autor pesquisaAutor(int codigo){
        for(int i = 0;i < autores.size(); i++){
            if(autores.get(i).getCodigo() == codigo)
                return autores.get(i);
        }
        return null;
    }

}
