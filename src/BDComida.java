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
        for (Comida comidaFor : comidas) {
            if (comidaFor.getId() == id) {
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

    @Override
    public Comida preCadastro(String codigo, double preco, String atributoString, double atributoDouble, int tipo) {
        Comida comida = null;
        if (tipo == 1) {
            comida = new Cafe(codigo, preco, atributoString, atributoDouble);
        } else if (tipo == 2) {
            comida = new Pao(codigo, preco, atributoString, atributoDouble);
        } else if (tipo == 3) {
            comida = new Torta(codigo, preco, atributoString, atributoDouble);
        }
        return comida;
    }

    @Override
    public boolean verificarSeExisteObjeto(String codigo) {
        for (Comida comida : comidas) {
            if (comida.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public String menuCriar() {
        return "Informe a opção que você deseja criar:\n" +
                "\n" +
                "0- Voltar para o menu principal\n" +
                "1- Café\n" +
                "2- Pão\n" +
                "3- Torta";
    }

}
