import java.util.ArrayList;

public class BDComida implements ICRUD<Integer, Comida> {
    private static ArrayList<Comida> comidas = new ArrayList<>();

    @Override
    public void create(Comida comida) {
        comidas.add(comida);
    }

    @Override
    public Comida readOne(Integer id) {
        for (Comida comida : comidas) {
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
    public void upDate(Integer id, Comida comida) {
        for (Comida comidaFor: comidas) {
            if (comidaFor.getId() == id){
                delete(comidaFor.getId());
                create(comida);
                break;
            }
        }
    }

    @Override
    public void delete(Integer id) {
        for (Comida comida : comidas) {
            if (comida.getId() == id) {
                comidas.remove(comida);
                break;
            }
        }

    }

}
