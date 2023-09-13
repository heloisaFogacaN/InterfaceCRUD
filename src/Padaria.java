import java.lang.invoke.StringConcatException;

public class Padaria {
    private String tipo;
    private double preco;
    private String codigo;

    public Padaria(String codigo, String tipo, double preco) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.preco = preco;
    }
}
