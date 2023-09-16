public class Papel extends Material {

    private String tipo;
    private double tamanho;



    public Papel(String codigo, double preco, String tipo, double tamanho) {
        super(codigo, preco);
        this.tipo=tipo;
        this.tamanho=tamanho;
    }

    public Papel(String codigo, double preco, int id, String tipo, double tamanho) {
        super(codigo, preco, id);
        this.tipo=tipo;
        this.tamanho=tamanho;
    }

    @Override
    public String toStringNome() {
        return "Papel" +
                "\nID: " +getId();
    }
    @Override
    public String toString() {
        return "Livro:\n" +
                super.toString() +
                "\nTipo: \n" + tipo +
                "Tamanho: " + tamanho;
    }
}
