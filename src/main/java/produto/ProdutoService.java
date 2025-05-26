package produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	@Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoById(Integer id) {
        return produtoRepository.findById(id);
    }

    public Produto createProduto(Produto produto) {
        if (produtoRepository.findByCodigoProduto(produto.getCodigo()).isPresent()) {
            throw new IllegalArgumentException("Código de produto já existe: " + produto.getCodigo());
        }
        Produto savedProduto = produtoRepository.save(produto);
        return produtoRepository.findById(savedProduto.getIdProduto()).orElse(savedProduto);
    }
    
    public Optional<Produto> updateProduto(Integer id, Produto updatedProduto) {
        return produtoRepository.findById(id).map(produto -> {
            if (updatedProduto.getCodigo() != null) {
                Optional<Produto> existingProduto = produtoRepository.findByCodigoProduto(updatedProduto.getCodigo());
                if (existingProduto.isPresent() && !existingProduto.get().getIdProduto().equals(id)) {
                    throw new IllegalArgumentException("Código de produto já existe: " + updatedProduto.getCodigo());
                }
                produto.setCodigo(updatedProduto.getCodigo());
            }
            if (updatedProduto.getMarca() != null) {
                produto.setMarca(updatedProduto.getMarca());
            }
            if (updatedProduto.getModelo() != null) {
                produto.setModelo(updatedProduto.getModelo());
            }
            if (updatedProduto.getDescricao() != null) {
                produto.setDescricao(updatedProduto.getDescricao());
            }
            if (updatedProduto.getQuantidadeEstoque() != null) {
                produto.setQuantidadeEstoque(updatedProduto.getQuantidadeEstoque());
            }
            if (updatedProduto.getPrecoCusto() != null) {
                produto.setPrecoCusto(updatedProduto.getPrecoCusto());
            }
            if (updatedProduto.getPrecoVenda() != null) {
                produto.setPrecoVenda(updatedProduto.getPrecoVenda());
            }
            if (updatedProduto.getImagemUrl() != null) {
                produto.setImagemUrl(updatedProduto.getImagemUrl());
            }
            if (updatedProduto.getAtivo() != null) {
                produto.setAtivo(updatedProduto.getAtivo());
            }
            return produtoRepository.save(produto);
        });
    }
}
