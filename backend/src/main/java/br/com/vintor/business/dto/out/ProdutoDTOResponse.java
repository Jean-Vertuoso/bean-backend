package br.com.vintor.business.dto.out;

import br.com.vintor.business.enums.TipoEmbalagem;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProdutoDTOResponse {

    private String nome;
    private String marca;
    private BigDecimal preco;
    private String imgUrl;

    private TipoEmbalagem tipoEmbalagem;

    private EstoqueDTOResponse estoque;

    private Set<CategoriaDTOResponse> categorias = new HashSet<>();

    private Set<ItemVendaDTOResponse> itens = new HashSet<>();

    public ProdutoDTOResponse() {
    }

    public ProdutoDTOResponse(String nome, String marca, BigDecimal preco, String imgUrl, TipoEmbalagem tipoEmbalagem, EstoqueDTOResponse estoque) {
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.imgUrl = imgUrl;
        this.tipoEmbalagem = tipoEmbalagem;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public TipoEmbalagem getTipoEmbalagem() {
        return tipoEmbalagem;
    }

    public void setTipoEmbalagem(TipoEmbalagem tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
    }

    public EstoqueDTOResponse getEstoque() {
        return estoque;
    }

    public void setEstoque(EstoqueDTOResponse estoque) {
        this.estoque = estoque;
    }

    public Set<CategoriaDTOResponse> getCategorias() {
        return categorias;
    }

    public Set<ItemVendaDTOResponse> getItens() {
        return itens;
    }
}
