public class MarcaTexto extends Material {
    private String tipoPonta;
    private double qtdeTinta;

    public MarcaTexto(String codigo, double preco, String tipoPonta, double qtdeTinta) {
        super(codigo, preco);
        this.tipoPonta=tipoPonta;
        this.qtdeTinta=qtdeTinta;
    }

    public MarcaTexto(String codigo, double preco, int id, String tipoPonta, double qtdeTinta) {
        super(codigo, preco, id);
        this.tipoPonta=tipoPonta;
        this.qtdeTinta=qtdeTinta;
    }

    @Override
    public String toStringNome() {
        return "Marca Texto" +
                "\nID: " + getId();
    }

    @Override
    public String toString() {
        return "Marca Texto:\n" +
                super.toString() +
                "\nTipo de ponta: \n" + tipoPonta +
                "Quantidade de tinta: " + qtdeTinta;
    }
}
