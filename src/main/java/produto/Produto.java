package produto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PRODUTO")
    private Integer idProduto;

	@Column(name = "CODIGO")
	private String codigo;

	@Column(name = "MARCA")
	private String marca;
	
	@Column(name = "MODELO")
	private String modelo;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "QUANTIDADE_ESTOQUE")
	private Integer quantidadeEstoque;
	
	@Column(name = "PRECO_CUSTO")
	private Double precoCusto;
	
	@Column(name = "PRECO_VENDA")
	private Double precoVenda;
	
	@Column(name = "IMAGEM_URL")
	private String imagemUrl;
	
	@Column(name = "ATIVO")
	private Boolean ativo;
	
	@Column(name = "SHOPEE_ITEM_ID")
	private Integer shopeeItemId;
	
	@Column(name = "SHOPEE_VARIATION_ID")
	private Integer shopeeVariationId;

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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