import java.util.ArrayList;

public class BDMaterial implements ICRUD<Integer, Material> {

    private ArrayList<Material> materiais = new ArrayList<>();

    @Override
    public void create(Material material) {
        materiais.add(material);
    }

    @Override
    public Material readOne(Integer id) {
        for (Material material : materiais) {
            if (material.getId() == id) {
                return material;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Material> readAll() {
        return materiais;
    }

    @Override
    public void upDate(Integer id, Material material) {
        for(Material materialFor : materiais){
            if(material.getId() == id){
                delete(materialFor.getId());
                create(material);
                break;
            }
        }

    }

    @Override
    public void delete(Integer id) {
        for (Material material : materiais){
            if(material.getId() == id){
                materiais.remove(material);
                break;
            }
        }

    }

    @Override
    public Material preCadastro(String codigo, double preco, String atributoString, double atributoDouble, int tipo) {
        Material materialAdd = null;
        if (tipo == 1) {
            materialAdd = new Livro(codigo, preco, atributoString, atributoDouble);
        } else if(tipo == 2){
            materialAdd = new MarcaTexto(codigo, preco, atributoString, atributoDouble);
        } else if(tipo == 3){
            materialAdd = new Papel(codigo, preco, atributoString, atributoDouble);
        }
        return  materialAdd;
    }

    @Override
    public boolean verificarSeExisteObjeto(String codigo) {
        for (Material material : materiais) {
            if (material.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public String menuCriar() {
        return "Informe a opção que você deseja criar:\n" +
                "\n" +
                "0- Voltar para o menu principal\n" +
                "1- Livro\n" +
                "2- Marca Texto\n" +
                "3- Papel\n";
    }
}
