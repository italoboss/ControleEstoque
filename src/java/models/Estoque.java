package models;

public class Estoque {
    private int id;
    private int codUsuario;
    private int codProduto;
    private String nomeProduto;
    private int quantidade;

    public Estoque() {
    }

    public Estoque(int id, int codUsuario, int codProduto, int quantidade) {
        this.id = id;
        this.codUsuario = codUsuario;
        this.codProduto = codProduto;
        this.quantidade = quantidade;
    }

    public Estoque(int codUsuario, int codProduto, int quantidade) {
        this.codUsuario = codUsuario;
        this.codProduto = codProduto;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int cod_usuario) {
        this.codUsuario = cod_usuario;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int cod_produto) {
        this.codProduto = cod_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
           
}
