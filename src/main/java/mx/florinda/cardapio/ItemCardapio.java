package mx.florinda.cardapio;

import java.math.BigDecimal;

public class ItemCardapio {

    public enum CategoriaCardapio {
        BEBIDA, PRATO_PRINCIPAL, ENTRADA, SOBREMESA
    }

    private final Long id;
    private final String nome;
    private final String descricao;
    private final CategoriaCardapio categoria;
    private final BigDecimal preco;
    private final BigDecimal precoComDesconto;

    public ItemCardapio(Long id, String nome, String descricao, ItemCardapio.CategoriaCardapio categoria,
                        BigDecimal preco, BigDecimal precoComDesconto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.precoComDesconto = precoComDesconto;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public CategoriaCardapio getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public BigDecimal getPrecoComDesconto() {
        return precoComDesconto;
    }

    @Override
    public String toString() {
        return "ItemCardapio [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", categoria=" + categoria
                + ", preco=" + preco + ", precoComDesconto=" + precoComDesconto + "]";
    }

}