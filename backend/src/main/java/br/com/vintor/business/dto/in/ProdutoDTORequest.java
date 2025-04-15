package br.com.vintor.business.dto.in;

import br.com.vintor.infrastructure.entities.enums.TipoEmbalagem;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProdutoDTORequest {

    private String nome;
    private String marca;
    private BigDecimal preco;
    private String imgUrl;

    private TipoEmbalagem tipoEmbalagem;

    private EstoqueDTORequest estoque;

    private Set<CategoriaDTORequest> categorias = new HashSet<>();

    private Set<ItemVendaDTORequest> itens = new HashSet<>();

    public ProdutoDTORequest() {
    }

    public ProdutoDTORequest(String nome, String marca, BigDecimal preco, String imgUrl, TipoEmbalagem tipoEmbalagem, EstoqueDTORequest estoque) {
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

    public EstoqueDTORequest getEstoque() {
        return estoque;
    }

    public void setEstoque(EstoqueDTORequest estoque) {
        this.estoque = estoque;
    }

    public Set<CategoriaDTORequest> getCategorias() {
        return categorias;
    }

    public Set<ItemVendaDTORequest> getItens() {
        return itens;
    }
}
