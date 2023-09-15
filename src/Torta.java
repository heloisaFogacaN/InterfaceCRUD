public class Torta extends Comida {
    private String recheio;
    private double diametro;

    public Torta(String codigo, double preco, String recheio, double diametro) {
        super(codigo, preco);
        this.recheio = recheio;
        this.diametro = diametro;
    }

    public Torta(String codigo, double preco, int id, String recheio, double diametro) {
        super(codigo, preco, id);
        this.recheio=recheio;
        this.diametro=diametro;
    }

    @Override
    public String toString() {
        return "Torta\n" +
                super.toString() +
                "\nRecheio: " + recheio +
                "\nDiâmetro: " + diametro;
    }

    @Override
    public String toStringNome() {
        return "Torta\n" + recheio +
                "ID: " + getId();
    }
}
