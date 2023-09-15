public class Pao extends Comida {
    private double comprimento;
    private String tipo;


    public Pao(String codigo, double preco, String tipo, double comprimento) {
        super(codigo, preco);
        this.tipo = tipo;
        this.comprimento = comprimento;
    }

    @Override
    public String toString() {
        return "Pao{" +
                "comprimento=" + comprimento +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public String toStringNome() {
        return "Pão\n" + tipo +
                "ID: " + getId();
    }
}

