public class Comida {
    private double preco;
    private String codigo;
    private int id;
    private static int proximoId = 0;

    public Comida(String codigo, double preco) {
        this.codigo = codigo;
        this.preco = preco;
        this.id = proximoId;
        proximoId++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Comida: " +
                "Preço: R$ " + preco +
                "Código:" + codigo + '\'' +
                "ID: " + id;
    }

    public String toStringNome() {
        return "";
    }
}
