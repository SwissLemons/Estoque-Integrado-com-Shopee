package com.example.demo.produto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduto")
    private Integer idProduto;

	@Column(name = "codigoProduto")
	private String codigoProduto;

	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "quantidadeEstoque")
	private Integer quantidadeEstoque;
	
	@Column(name = "precoCusto")
	private Double precoCusto;
	
	@Column(name = "precoVenda")
	private Double precoVenda;
	
	@Column(name = "imagemUrl")
	private String imagemUrl;
	
	@Column(name = "ativo")
	private Boolean ativo;
	
	@Column(name = "shopeeItemId")
	private Integer shopeeItemId;
	
	@Column(name = "shopeeVariationId")
	private Integer shopeeVariationId;

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getShopeeItemId() {
		return shopeeItemId;
	}

	public void setShopeeItemId(Integer shopeeItemId) {
		this.shopeeItemId = shopeeItemId;
	}

	public Integer getShopeeVariationId() {
		return shopeeVariationId;
	}

	public void setShopeeVariationId(Integer shopeeVariationId) {
		this.shopeeVariationId = shopeeVariationId;
	}
	
}