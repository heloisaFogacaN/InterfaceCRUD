public class Pao extends Comida {
    private double comprimento;
    private String tipo;


    public Pao(String codigo, double preco, String tipo, double comprimento) {
        super(codigo, preco);
        this.tipo = tipo;
        this.comprimento = comprimento;
    }

    public Pao(String codigo, double preco, int id, String tipo, double comprimento) {
        super(codigo, preco, id);
        this.tipo = tipo;
        this.comprimento = comprimento;
    }

    @Override
    public String toString() {
        return "Pão\n" +
                super.toString() +
                "\nComprimento: " + comprimento +
                "\nTipo: " + tipo;
    }

    @Override
    public String toStringNome() {
        return "Pão\n" + tipo +
                "ID: " + getId();
    }
}

