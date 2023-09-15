import java.util.ArrayList;

public class BDComida implements ICRUD<Integer, Comida> {
    private static ArrayList<Comida> comidas=new ArrayList<>();

    @Override
    public void create(Comida comida) {
        comidas.add(comida);
    }

    @Override
    public Comida readOne(Integer id) {
        for (Comida comida : getComidas()) {
            if (comida.getId() == id) {
                return comida;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Comida> readAll() {
      return comidas;
    }

    @Override
    public void upDate(Integer id) {

    }

    public static ArrayList<Comida> getComidas() {
        return comidas;
    }

    @Override
    public void delete(Integer id) {
        for (Comida comida : getComidas()) {
            if (comida.getId() == id){
                comidas.remove(comida);
            }
        }

    }


}
