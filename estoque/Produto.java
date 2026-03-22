package estoque;

public class Produto {
    private int id;
    private String nomeProduto;
    private double valorProduto;
    private int quantidadeProduto;

    public Produto (String nomeProduto, double valorProduto, int quantidadeProduto) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public Produto (String nomeProduto, double valorProduto, int quantidadeProduto, int id) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.id = id;
    }

    public Produto (String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Produto (double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Produto (int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
    
    public Produto() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto (String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }
}