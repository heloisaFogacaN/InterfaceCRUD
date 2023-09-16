public class Livro extends Material {
    private String titulo;
    private double qtdePaginas;


    public Livro(String codigo, double preco, String titulo, double qtdePaginas) {
        super(codigo, preco);
        this.titulo=titulo;
        this.qtdePaginas=qtdePaginas;
    }

    public Livro(String codigo, double preco, int id, String titulo, double qtdePaginas) {
        super(codigo, preco, id);
        this.titulo=titulo;
        this.qtdePaginas=qtdePaginas;
    }

    @Override
    public String toStringNome() {
        return "Livro" +
                "\nID: " + getId();
    }

    @Override
    public String toString() {
        return "Livro\n" +
                super.toString() +
                "\nTítulo:" + titulo +
                "\nQuantidade de páginas: " + qtdePaginas;
    }
}
