public class Material {
    private String codigo;
    private double preco;
    private int id;
    private static int proximoId =0;

    public Material(String codigo, double preco){
        this.codigo=codigo;
        this.preco=preco;
        this.id= proximoId;
        proximoId++;
    }

    public Material(String codigo, double preco, int id){
        this(codigo, preco);
        this.id=id;
        proximoId--;
    }
    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String toStringNome() {
        return "";
    }

    @Override
    public String toString() {
               return  "Preço:" + preco +
                       "\nCódigo:" + codigo + '\'' +
                       "\nID: " + id;
    }
}
