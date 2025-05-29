package com.example.demo.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	
    private final ProdutoRepository produtoRepository;
    
	public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoByCodigoProduto(String codigoProduto) {
        return produtoRepository.findByCodigoProduto(codigoProduto);
    }

    public Produto createProduto(Produto produto) {
        if (produtoRepository.findByCodigoProduto(produto.getCodigoProduto()).isPresent()) {
            throw new IllegalArgumentException("Código de produto já existe: " + produto.getCodigoProduto());
        }
        Produto savedProduto = produtoRepository.save(produto);
        return produtoRepository.findByCodigoProduto(savedProduto.getCodigoProduto()).orElse(savedProduto);
    }
    
    public Optional<Produto> updateProduto(String codigoProduto, Produto updatedProduto) {
        return produtoRepository.findByCodigoProduto(codigoProduto).map(produto -> {
            if (updatedProduto.getCodigoProduto() != null) {
                Optional<Produto> existingProduto = produtoRepository.findByCodigoProduto(updatedProduto.getCodigoProduto());
                if (existingProduto.isPresent() && !existingProduto.get().getIdProduto().equals(codigoProduto)) {
                    throw new IllegalArgumentException("Código de produto já existe: " + updatedProduto.getCodigoProduto());
                }
                produto.setCodigoProduto(updatedProduto.getCodigoProduto());
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
    
//    public void deleteProduto(Long id) {
//        produtoRepository.deleteById(id);
//    }
}
