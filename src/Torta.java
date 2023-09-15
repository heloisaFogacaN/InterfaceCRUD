public class Torta extends Comida {
    private String recheio;
    private double diametro;

    public Torta(String codigo, double preco, String recheio, double diametro) {
        super(codigo, preco);
        this.recheio = recheio;
        this.diametro = diametro;
    }

    @Override
    public String toString() {
        return "Torta" +
                "Recheio: " + recheio + '\'' +
                "Diâmetro:" + diametro;
    }

    @Override
    public String toStringNome() {
        return "Torta\n" + recheio +
                "ID: " + getId();
    }
}
