public class Cafe extends Comida {
    private String tipo;
    private double acidez;


    public Cafe(String codigo, double preco, String tipo, double acidez) {
        super(codigo, preco);
        this.tipo = tipo;
        this.acidez = acidez;
    }

    public Cafe(String codigo, double preco, int id, String tipo, double acidez) {
        super(codigo, preco, id);
        this.tipo=tipo;
        this.acidez=acidez;
    }

    @Override
    public String toString() {
        return "Café\n" +
                super.toString() +
                "\nTipo: " + tipo +
                "\nÁcidez: " + acidez;
    }

    public String toStringNome() {
        return "Café\n" + tipo +
                "ID: " + getId();
    }
}
