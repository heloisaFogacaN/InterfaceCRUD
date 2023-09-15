public class Comida {
    private double preco;
    private String codigo;
    private int id;
    private static int proximoId = 0;

    public Comida(String codigo, double preco, int id) {
        this(codigo, preco);
        this.id = id;
        proximoId--;
    }

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
        return "Preço: R$ " + preco +
                "\nCódigo:" + codigo +
                "\nID: " + id;
    }

    public String toStringNome() {
        return "";
    }
}
